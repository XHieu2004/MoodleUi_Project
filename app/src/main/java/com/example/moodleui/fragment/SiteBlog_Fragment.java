package com.example.moodleui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.example.moodleui.R;

import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SiteBlog_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class SiteBlog_Fragment extends Fragment {


    public static SiteBlog_Fragment newInstance() {
        return new SiteBlog_Fragment();
    }

    public class Comment {
        private String username;
        private String content;

        public Comment(String username, String content) {
            this.username = username;
            this.content = content;
        }

        public String getUsername() {
            return username;
        }

        public String getContent() {
            return content;
        }
    }


    public class BlogEntry {
        private String title;
        private String content;
        private boolean isUserPost;
        private List<Comment> comments;

        public BlogEntry(String title, String content, boolean isUserPost) {
            this.title = title;
            this.content = content;
            this.isUserPost = isUserPost;
            this.comments = new ArrayList<>();
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public boolean isUserPost() {
            return isUserPost;
        }

        public List<Comment> getComments() {
            return comments;
        }

        public void addComment(Comment comment) {
            comments.add(comment);
        }
    }



    private RecyclerView recyclerView;
    private BlogAdapter blogAdapter;
    private List<BlogEntry> blogList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_site_blog_, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_blog);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize blog data (replace with actual data fetching logic)
        blogList = new ArrayList<>();
        blogAdapter = new BlogAdapter(blogList);
        recyclerView.setAdapter(blogAdapter);

        // Toggle switch functionality (stubbed out for now)
        Switch toggleSwitch = view.findViewById(R.id.switch_show_entries);
        toggleSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Update blogList based on the toggle state
            filterBlogEntries(isChecked);
        });

        return view;
    }

    private void filterBlogEntries(boolean showOnlyUserEntries) {
        // Implement filter logic here (e.g., query backend with a parameter)
    }
}

