package com.example.moodleui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileDownloader {

    private static final String SERVER_URL = "https://9cc7-2405-4802-1828-ae70-bc1e-db82-f31e-ae48.ngrok-free.app/file_upload_download/uploads/1.%20intro.md.pdf";

    // Download the PDF
    public void downloadPdf(Context context, String savePath) {
        OkHttpClient client = new OkHttpClient();

        // Create request to fetch the file
        Request request = new Request.Builder()
                .url(SERVER_URL)
                .build();

        // Perform the download asynchronously
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                // Handle failure - show a Toast message on the main thread
                new Handler(Looper.getMainLooper()).post(() ->
                        Toast.makeText(context, "Download failed: " + e.getMessage(), Toast.LENGTH_LONG).show()
                );
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    // Get the InputStream of the file from the response body
                    InputStream inputStream = response.body().byteStream();

                    // Check if the directory exists, if not create it
                    File downloadFolder = new File(savePath);
                    if (!downloadFolder.exists()) {
                        downloadFolder.mkdirs();
                    }

                    File file = new File(downloadFolder, "intro.md.pdf");

                    // Write the file to disk
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, length);
                    }

                    // Close streams
                    fileOutputStream.close();
                    inputStream.close();

                    // Notify the user on the main thread
                    new Handler(Looper.getMainLooper()).post(() -> {
                        Toast.makeText(context, "Download complete: " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                        openPdf(context, file);
                    });
                } else {
                    // Handle unsuccessful response
                    new Handler(Looper.getMainLooper()).post(() ->
                            Toast.makeText(context, "Download failed: Server error", Toast.LENGTH_LONG).show()
                    );
                }
            }
        });
    }

    // Open the PDF after download using FileProvider
    private void openPdf(Context context, File file) {
        // Get content URI using FileProvider
        Uri uri = FileProvider.getUriForFile(context, "com.example.moodleui.fileprovider", file);

        // Create the Intent to open the PDF
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/pdf");
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); // Grant permission to read URI

        // Start the activity to open the PDF viewer
        context.startActivity(Intent.createChooser(intent, "Open PDF with"));
    }
}
