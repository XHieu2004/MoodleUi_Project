package com.example.moodleui.homepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.moodleui.R;

public class DashBoardFragment extends Fragment {

    private HorizontalScrollView horizontalScrollView;

    // Corrected method signature for onCreateView
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);

        // Find views by their IDs
        horizontalScrollView = view.findViewById(R.id.horizontal_view_courses);
        Button buttonScrollLeft = view.findViewById(R.id.button_left);
        Button buttonScrollRight = view.findViewById(R.id.button_right);

        // Scroll Left Button functionality
        buttonScrollLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Scroll left by 200 pixels
                horizontalScrollView.smoothScrollBy(-300, 0);
            }
        });

        // Scroll Right Button functionality
        buttonScrollRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Scroll right by 200 pixels
                horizontalScrollView.smoothScrollBy(300, 0);
            }
        });

        return view; // Return the inflated view
    }
}
