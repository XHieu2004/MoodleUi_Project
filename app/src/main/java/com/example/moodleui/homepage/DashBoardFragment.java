package com.example.moodleui.homepage;

import android.content.Intent;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);

        // Initialize scroll functionality components
        horizontalScrollView = view.findViewById(R.id.horizontal_view_courses);
        Button buttonScrollLeft = view.findViewById(R.id.button_left);
        Button buttonScrollRight = view.findViewById(R.id.button_right);

        // Initialize In Progress button and additional buttons container
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
        buttonScrollLeft.setOnClickListener(v -> horizontalScrollView.smoothScrollBy(-300, 0));

        // Scroll Right Button functionality
        buttonScrollRight.setOnClickListener(v -> horizontalScrollView.smoothScrollBy(300, 0));

        // Toggle visibility of additional buttons when "In Progress" button is clicked
        inProgressButton.setOnClickListener(v -> {
            if (additionalButtonsContainer.getVisibility() == View.GONE) {
                additionalButtonsContainer.setVisibility(View.VISIBLE);
            } else {
                additionalButtonsContainer.setVisibility(View.GONE);
            }
        });

        // Set onClick listeners for each additional button, updating the inProgressButton text and hiding the additional buttons container
        buttonAllIncludingRemoved.setOnClickListener(v -> setFilterText(R.string.all_including_removed));
        buttonAll.setOnClickListener(v -> setFilterText(R.string.all));
        buttonInProgress.setOnClickListener(v -> setFilterText(R.string.in_progress));
        buttonFuture.setOnClickListener(v -> setFilterText(R.string.future));
        buttonPast.setOnClickListener(v -> setFilterText(R.string.past));
        buttonStarred.setOnClickListener(v -> setFilterText(R.string.starred));
        buttonRemoved.setOnClickListener(v -> setFilterText(R.string.removed_from_view));

        // Add click listener for "Introduction to Algorithms" to navigate to Course activity
        View courseItem = view.findViewById(R.id.course_algorithm); // Update this ID if needed
        courseItem.setOnClickListener(v -> openCourseActivity());

        return view;
    }

    private void setFilterText(int stringResId) {
        // Update inProgressButton text and hide additional buttons container
        inProgressButton.setText(stringResId);
        additionalButtonsContainer.setVisibility(View.GONE);
    }

    private void openCourseActivity() {
        // Start Course activity
        Intent intent = new Intent(requireContext(), Course.class);
        startActivity(intent);
    }
}
