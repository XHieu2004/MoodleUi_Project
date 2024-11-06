package com.example.moodleui.homepage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moodleui.R;

public class ResetPassword extends AppCompatActivity {

    private EditText editNewPassword, editConfirmPassword;
    private Button changePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword);

        editNewPassword = findViewById(R.id.text_password1);
        editConfirmPassword = findViewById(R.id.text_password2);
        changePassword = findViewById(R.id.change_password);

        changePassword.setOnClickListener(view -> {
            String newPassword = editNewPassword.getText().toString();
            String confirmPassword = editConfirmPassword.getText().toString();

            if (validateResetPassword(newPassword) && validateResetPassword(confirmPassword)) {
                if (newPassword.equals(confirmPassword)) {
                    // Store password change status in SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("toResetpassword", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isChange", true);
                    editor.apply();

                    // Navigate back to Login screen
                    Intent intent = new Intent(ResetPassword.this, Login.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish(); // Close ResetPassword activity
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter both passwords to change", Toast.LENGTH_SHORT).show();
            }
        });

        // Back button functionality
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    // Validate if input is non-empty
    private boolean validateResetPassword(String text) {
        return !text.isEmpty();
    }
}
