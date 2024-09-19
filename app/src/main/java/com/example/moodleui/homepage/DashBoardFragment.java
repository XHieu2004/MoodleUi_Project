package com.example.moodleui.homepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.moodleui.R;

public class DashBoardFragment extends Fragment {

    private HorizontalScrollView horizontalScrollView;
    private Button inProgressButton;
    private LinearLayout additionalButtonsContainer;

    // Corrected method signature for onCreateView
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);

        // Scroll functionality components
        horizontalScrollView = view.findViewById(R.id.horizontal_view_courses);
        Button buttonScrollLeft = view.findViewById(R.id.button_left);
        Button buttonScrollRight = view.findViewById(R.id.button_right);

        // In Progress button and the additional buttons container
        inProgressButton = view.findViewById(R.id.in_progress);
        additionalButtonsContainer = view.findViewById(R.id.additional_buttons_container);
        Button buttonAllIncludingRemoved = view.findViewById(R.id.button_all_including_removed);
        Button buttonAll = view.findViewById(R.id.button_all);
        Button buttonInProgress = view.findViewById(R.id.button_in_progress);
        Button buttonFuture = view.findViewById(R.id.button_future);
        Button buttonPast = view.findViewById(R.id.button_past);
        Button buttonStarred = view.findViewById(R.id.button_starred);
        Button buttonRemoved = view.findViewById(R.id.button_removed);

        // Scroll Left Button functionality
        buttonScrollLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Scroll left by 300 pixels
                horizontalScrollView.smoothScrollBy(-300, 0);
            }
        });

        // Scroll Right Button functionality
        buttonScrollRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Scroll right by 300 pixels
                horizontalScrollView.smoothScrollBy(300, 0);
            }
        });

        // Set onClick listener for the "In Progress" button
        inProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of the additional buttons
                if (additionalButtonsContainer.getVisibility() == View.GONE) {
                    additionalButtonsContainer.setVisibility(View.VISIBLE);
                } else {
                    additionalButtonsContainer.setVisibility(View.GONE);
                }
            }
        });

        // Set onClick listeners for the additional buttons
        buttonAllIncludingRemoved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inProgressButton.setText(R.string.all_including_removed);
                additionalButtonsContainer.setVisibility(View.GONE);
            }
        });

        buttonAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inProgressButton.setText(R.string.all);
                additionalButtonsContainer.setVisibility(View.GONE);
            }
        });

        buttonInProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inProgressButton.setText(R.string.in_progress);
                additionalButtonsContainer.setVisibility(View.GONE);
            }
        });

        buttonFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inProgressButton.setText(R.string.future);
                additionalButtonsContainer.setVisibility(View.GONE);
            }
        });

        buttonPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inProgressButton.setText(R.string.past);
                additionalButtonsContainer.setVisibility(View.GONE);
            }
        });

        buttonStarred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inProgressButton.setText(R.string.starred);
                additionalButtonsContainer.setVisibility(View.GONE);
            }
        });

        buttonRemoved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inProgressButton.setText(R.string.removed_from_view);
                additionalButtonsContainer.setVisibility(View.GONE);
            }
        });

        return view; // Return the inflated view
    }
}
