package com.example.moodleui.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moodleui.R;
import com.example.moodleui.fragment.CommentAdapter;
import com.example.moodleui.fragment.SiteBlog_Fragment;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {
    private List<SiteBlog_Fragment.BlogEntry> blogEntries;

    public BlogAdapter(List<SiteBlog_Fragment.BlogEntry> blogEntries) {
        this.blogEntries = blogEntries;
    }

    public void updateData(List<SiteBlog_Fragment.BlogEntry> newEntries) {
        this.blogEntries = newEntries;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog_entry, parent, false);
        return new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        SiteBlog_Fragment.BlogEntry blog = blogEntries.get(position);
        holder.tvTitle.setText(blog.getTitle());
        holder.tvContent.setText(blog.getContent());
        holder.tvDate.setText("Date placeholder");  // Placeholder for date; update as needed

        // Set up the CommentAdapter for each blog entry’s comments
        CommentAdapter commentAdapter = new CommentAdapter(blog.getComments());
        holder.recyclerViewComments.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.recyclerViewComments.setAdapter(commentAdapter);
    }

    @Override
    public int getItemCount() {
        return blogEntries.size();
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvContent, tvDate;
        RecyclerView recyclerViewComments;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_blog_title);
            tvContent = itemView.findViewById(R.id.tv_blog_content);

            recyclerViewComments = itemView.findViewById(R.id.recycler_view_comments);  // Comments RecyclerView
        }
    }
}

