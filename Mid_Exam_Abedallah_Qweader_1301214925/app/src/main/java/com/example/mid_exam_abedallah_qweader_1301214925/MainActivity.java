
package com.example.mid_exam_abedallah_qweader_1301214925;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mid_exam_abedallah_qweader_1301214925.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean backPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                String email = binding.emailEditText.getText().toString().trim();

                String password = binding.passwordEditText.getText().toString();

                boolean validEmail =
                        Patterns.EMAIL_ADDRESS.matcher(email).matches();

                boolean validPassword = password.length() >= 6;

                binding.loginButton.setEnabled(
                        validEmail && validPassword
                );
            }
        };

        binding.emailEditText.addTextChangedListener(textWatcher);
        binding.passwordEditText.addTextChangedListener(textWatcher);

        binding.loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ModeActivity.class);
            startActivity(intent);
        });
    }
    @Override
    public void onBackPressed() {

        if (backPressedOnce) {
            super.onBackPressed();
            return;
        }

        backPressedOnce = true;

        Snackbar snackbar = Snackbar.make(
                binding.getRoot(),
                "Press back again to exit",
                Snackbar.LENGTH_SHORT
        );

        snackbar.addCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar bar, int event) {
                backPressedOnce = false;
            }
        });

        snackbar.show();
    }

}
