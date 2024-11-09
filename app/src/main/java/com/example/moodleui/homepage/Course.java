package com.example.moodleui.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moodleui.FileDownloader;
import com.example.moodleui.R;

import java.io.File;

public class Course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algorithms); // Ensure this layout has the required buttons

        // Initialize the download button
        ImageButton downloadButton = findViewById(R.id.button1); // Ensure the ID is correct in the XML
        if (downloadButton != null) {
            downloadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Trigger your download logic here
                    String pdfUrl = "https://9cc7-2405-4802-1828-ae70-bc1e-db82-f31e-ae48.ngrok-free.app/file_upload_download/uploads/1.%20intro.md.pdf"; // Replace with actual URL

                    // Define the path where the file should be saved (e.g., in app-specific external storage)
                    File downloadFolder = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "MoodleDownloads");
                    if (!downloadFolder.exists()) {
                        downloadFolder.mkdirs();
                    }
                    String savePath = downloadFolder.getAbsolutePath(); // Directory path to save the file

                    // Call the download method
                    FileDownloader downloader = new FileDownloader();
                    downloader.downloadPdf(Course.this, savePath);
                }
            });
        } else {
            Log.e("CourseActivity", "Download button with ID 'button1' not found in layout");
        }

        // Initialize the back button (ImageButton) and set up navigation
        ImageButton backArrow = findViewById(R.id.back_icon); // Ensure this ID is correct in XML
        if (backArrow != null) {
            backArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate back to the dashboard (or another appropriate activity)
                    Intent intent = new Intent(Course.this, DashBoardFragment.class); // Ensure DashBoardFragment is an activity or fragment
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            Log.e("CourseActivity", "Back button with ID 'back_icon' not found in layout");
        }
    }
}
