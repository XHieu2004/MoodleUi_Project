package com.example.moodleui.homepage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.moodleui.MainActivity;
import com.example.moodleui.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private EditText editUserName, editRole, editPhone, editDateOfBirth, editAddress, editTextEmail, editTextPassword, editTextConfirmPassword;
    private Button buttonRegister;
    private static final String REGISTER_URL = "https://954f-118-70-176-212.ngrok-free.app/api/auth/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        editUserName = findViewById(R.id.editFirstName);
        editRole = findViewById(R.id.editLastName);
        editPhone = findViewById(R.id.editPhone);
        editDateOfBirth = findViewById(R.id.editDateOfBirth);
        editAddress = findViewById(R.id.editAddress);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        buttonRegister = findViewById(R.id.RegisterForAccount);

        buttonRegister.setOnClickListener(v -> {
            String username = editUserName.getText().toString().trim();
            String role = editRole.getText().toString().trim();
            String phone = editPhone.getText().toString().trim();
            String dOb = editDateOfBirth.getText().toString().trim();
            String address = editAddress.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            String confirmPassword = editTextConfirmPassword.getText().toString();


            if (validateRegister(username) && validateRegister(role) && validateRegister(phone) &&
                    validateRegister(dOb) && validateRegister(address) && validateRegister(email) &&
                    validateRegister(password) && validateRegister(confirmPassword)) {

                SharedPreferences sharedPreferences = getSharedPreferences("toRegister", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isRegister", true);
                editor.apply();


                registerUser(username, role, phone, dOb, address, email, password);

            } else {
                Toast.makeText(this, "Please enter all information to sign up", Toast.LENGTH_SHORT).show();
            }
        });

        // Back button
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> onBackPressed());
    }

    private boolean validateRegister(String text) {
        return !text.isEmpty();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    private void registerUser(String username, String role, String phone, String dOb, String address, String email, String password) {
        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("username", username);
            jsonParams.put("password", password);
            jsonParams.put("phonenumber", phone);
            jsonParams.put("email", email);
            jsonParams.put("dob", dOb);
            jsonParams.put("address", address);
            jsonParams.put("role", role);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, REGISTER_URL, jsonParams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.has("token")) {
                                String token = response.getString("token");

//                                SharedPreferences sharedPreferences = getSharedPreferences("TOLogin", MODE_PRIVATE);
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.putBoolean("isLoggedIn", true);
//                                editor.putString("token", token);
//                                editor.apply();

                                Intent intent = new Intent(Register.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            } else {
                                String message = response.getString("message");
                                Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Register.this, "Register error! Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(Register.this, "Error connecting to server", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                return headers;
            }
        };

        // Add request to queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
