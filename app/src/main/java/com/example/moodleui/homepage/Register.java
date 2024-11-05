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

public class Register extends AppCompatActivity {

    private EditText editFirstName, editLastName, editPhone, editDateOfBirth, editAdress, editTextEmail, editTextPassword, editTextConfirmPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editPhone = findViewById(R.id.editPhone);
        editDateOfBirth = findViewById(R.id.editDateOfBirth);
        editAdress = findViewById(R.id.editAddress);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        buttonRegister = findViewById(R.id.RegisterForAccount);

        buttonRegister.setOnClickListener(view -> {
            String firstname = editFirstName.getText().toString();
            String lastName = editLastName.getText().toString();
            String phone = editPhone.getText().toString();
            String dateOfBirth = editDateOfBirth.getText().toString();
            String address = editAdress.getText().toString();
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            String confirmPassword = editTextConfirmPassword.getText().toString();

            // Validate all fields
            if (validateRegister(firstname) && validateRegister(lastName) && validateRegister(phone) &&
                    validateRegister(dateOfBirth) && validateRegister(address) && validateRegister(email) &&
                    validateRegister(password) && validateRegister(confirmPassword)) {

                SharedPreferences sharedPreferences = getSharedPreferences("toRegister", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isRegister", true);
                editor.apply();

                // Start Login Activity after successful registration
                Intent intent = new Intent(Register.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // Close Register activity

            } else {
                Toast.makeText(this, "Please enter all information to sign up", Toast.LENGTH_SHORT).show();
            }
        });

        // Back button
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    private boolean validateRegister(String text) {
        return !text.isEmpty();
    }
}
