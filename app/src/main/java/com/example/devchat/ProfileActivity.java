package com.example.devchat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProfileActivity extends AppCompatActivity {
    final int RESULT_LOAD_IMG = 1234;

    TextInputEditText mDisplayNameEt;
    TextInputLayout mDisplayNameIL;
    ImageView mProfileImageView;

    InputStream imageStream;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mProfileImageView = findViewById(R.id.profile_iv);
        mDisplayNameEt = findViewById(R.id.display_name_et);
        mDisplayNameIL = findViewById(R.id.display_name_iL);

        findViewById(R.id.select_img_btn).setOnClickListener(selectImage);
        findViewById(R.id.update_btn).setOnClickListener(updateAccount);
    }

    View.OnClickListener selectImage = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //select image
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
        }
    };

    View.OnClickListener updateAccount = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //select image
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            try {
                imageUri = data.getData();
                imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                mProfileImageView.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(ProfileActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(ProfileActivity.this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }
}
