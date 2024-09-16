package com.example.moodleui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.moodleui.R;

public class More_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more_, container, false);

        // Find the App Settings button
        Button btnAppSettings = view.findViewById(R.id.btnappsettings_button);

        // Set click listener to navigate to App_settings activity
        btnAppSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to App_settings Activity
                Intent intent = new Intent(getActivity(), App_settings.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
