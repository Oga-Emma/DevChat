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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SigninActivity extends AppCompatActivity {
    private final String TAG = SigninActivity.class.getSimpleName();

    TextInputEditText mEmailEditText, mPasswordEditText;
    TextInputLayout mEmailInputLayout, mPasswordInputLayout;
    ProgressBar mLoadingIndicatorProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mEmailEditText  = findViewById(R.id.email_et);
        mEmailInputLayout= findViewById(R.id.email_iL);

        mPasswordEditText = findViewById(R.id.password_et);
        mPasswordInputLayout = findViewById(R.id.password_il);

        mLoadingIndicatorProgress = findViewById(R.id.loading_indicator_pb);
        mLoadingIndicatorProgress.setVisibility(View.INVISIBLE);

        findViewById(R.id.login_btn).setOnClickListener(loginClicked);
        findViewById(R.id.signup_btn).setOnClickListener(signupClicked);

    }


    private View.OnClickListener loginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mEmailInputLayout.setErrorEnabled(false);
            mPasswordInputLayout.setErrorEnabled(false);

            String email = mEmailEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();

            //validate inputs

            if(TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                mEmailInputLayout.setError("Invalid email");
                return;
            }
            if(password.isEmpty() || password.length() < 6){
                mPasswordInputLayout.setError("Enter a valid password");
                return;
            }

            loginUser(email, password);
        }
    };


    private View.OnClickListener signupClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent signupIntent = new Intent(SigninActivity.this, SignupActivity.class);
            startActivity(signupIntent );
        }
    };

    private void loginUser(String email, String password) {


    }
}
