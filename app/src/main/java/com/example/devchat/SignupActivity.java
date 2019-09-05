package com.example.devchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {
    private final String TAG = SignupActivity.class.getSimpleName();

    TextInputEditText mEmailEditText, mPasswordEditText, mConfirmPasswordEditText;
    TextInputLayout mEmailInputLayout, mPasswordInputLayout, mConfirmPasswordInputLayout;
    ProgressBar mLoadingIndicatorProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mEmailEditText  = findViewById(R.id.email_et);
        mEmailInputLayout= findViewById(R.id.email_iL);

        mPasswordEditText = findViewById(R.id.password_et);
        mPasswordInputLayout = findViewById(R.id.password_il);

        mConfirmPasswordEditText = findViewById(R.id.confirm_password_et);
        mConfirmPasswordInputLayout = findViewById(R.id.confirm_password_il);

        mLoadingIndicatorProgress = findViewById(R.id.loading_indicator_pb);
        mLoadingIndicatorProgress.setVisibility(View.INVISIBLE);

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.signup_btn).setOnClickListener(signupClicked );
    }


    private View.OnClickListener signupClicked = new View.OnClickListener() {
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

            signup(email, password);
        }
    };

    private void signup(String email, String password) {

    }
}
