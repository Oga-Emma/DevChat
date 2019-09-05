package com.example.devchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nguyenhoanglam.imagepicker.model.Config;
import com.nguyenhoanglam.imagepicker.model.Image;
import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfileSetupActivity extends AppCompatActivity {
    private final String TAG = ProfileSetupActivity.class.getSimpleName();

    private String imagePath;

    private ImageView mProfileIV;
    private TextView mDisplayNameET;
    private ProgressBar mSavingProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setup);

        getSupportActionBar().setTitle("Profile Setup");

        mProfileIV = findViewById(R.id.profile_image);
        mDisplayNameET = findViewById(R.id.display_name_edit_text);

        mSavingProgress = findViewById(R.id.saving_progress);
        mSavingProgress.setVisibility(View.INVISIBLE);

        findViewById(R.id.save_changes_btn).setOnClickListener(saveChanges);

        findViewById(R.id.change_profile_pic_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(ProfileSetupActivity.this)              //  Camera mode
                        .setMultipleMode(false)          //  Folder mode
                        .setShowCamera(true)
                        .setSavePath("ImagePicker")         //  Image capture folder name
                        .setRequestCode(100)                //  Set request code, default Config.RC_PICK_IMAGES
                        .setKeepScreenOn(true)              //  Keep screen on when selecting images
                        .start();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
        if (requestCode == Config.RC_PICK_IMAGES && resultCode == RESULT_OK && data != null) {
            ArrayList<Image> images = data.getParcelableArrayListExtra(Config.EXTRA_IMAGES);
            Image image = images.get(0);
            if(image != null){
                imagePath = image.getPath();
                Glide.with(this)
                        .load(imagePath)
                        .into(mProfileIV);
            }

            // do your logic here...
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private View.OnClickListener saveChanges = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

}
