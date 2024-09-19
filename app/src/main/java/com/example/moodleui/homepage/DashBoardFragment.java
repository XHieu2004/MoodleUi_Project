package com.example.moodleui.homepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import com.example.moodleui.R;

public class DashBoardFragment extends Fragment {

    private HorizontalScrollView horizontalScrollView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);

        // Find views by their IDs
        horizontalScrollView = view.findViewById(R.id.horizontal_view_courses);
        Button buttonScrollLeft = view.findViewById(R.id.button_left);
        Button buttonScrollRight = view.findViewById(R.id.button_right);
        Button inProgressButton = view.findViewById(R.id.in_progress);

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

        // Set onClick listener for the "In progress" button
        inProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create PopupMenu
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.getMenuInflater().inflate(R.menu.in_progress_menu, popupMenu.getMenu());

                // Show the popup menu
                popupMenu.show();

                // Handle menu item clicks
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Uncheck all items
                        for (int i = 0; i < popupMenu.getMenu().size(); i++) {
                            popupMenu.getMenu().getItem(i).setChecked(false);
                        }

                        // Check the clicked item
                        item.setChecked(true);

                        // Replace switch-case with if-else
                        int itemId = item.getItemId();
                        if (itemId == R.id.all_including_removed) {
                            // Handle "All (including removed from view)" action
                            return true;
                        } else if (itemId == R.id.all) {
                            // Handle "All" action
                            return true;
                        } else if (itemId == R.id.in_progress) {
                            // Handle "In progress" action
                            return true;
                        } else if (itemId == R.id.future) {
                            // Handle "Future" action
                            return true;
                        } else if (itemId == R.id.past) {
                            // Handle "Past" action
                            return true;
                        } else // Handle "Removed from view" action
                            if (itemId == R.id.starred) {
                                // Handle "Starred" action
                                return true;
                            } else return itemId == R.id.removed_from_view;
                    }
                });
            }
        });

        return view; // Return the inflated view
    }
}

