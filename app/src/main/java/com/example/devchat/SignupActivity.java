package com.example.devchat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {

    TextInputEditText mEmailEditText, mPasswordEditText, mConfirmPasswordEditText;
    TextInputLayout mEmailInputLayout, mPasswordInputLayout, mConfirmPasswordInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mEmailEditText  = findViewById(R.id.email_et);
        mEmailInputLayout= findViewById(R.id.email_iL);

        mPasswordEditText = findViewById(R.id.password_et);
        mPasswordInputLayout = findViewById(R.id.password_il);

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.login_btn).setOnClickListener(loginClicked);

    }


    private View.OnClickListener loginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mEmailInputLayout.setErrorEnabled(false);
            mPasswordInputLayout.setErrorEnabled(false);

            String email = mEmailEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();
            String confirmPassword = mConfirmPasswordEditText.getText().toString();

            //validate inputs

            if(TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                mEmailInputLayout.setError("Invalid email");
                return;
            }
            if(password.isEmpty() || password.length() < 6){
                mPasswordInputLayout.setError("Enter a valid password");
                return;
            }
            if(!confirmPassword.equals(password)){
                mConfirmPasswordInputLayout.setError("Password do not match");
                return;
            }

            loginUser(email, password);
        }
    };

    private void loginUser(String email, String password) {

    }
}
