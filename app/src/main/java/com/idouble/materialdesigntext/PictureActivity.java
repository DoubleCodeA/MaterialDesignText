package com.idouble.materialdesigntext;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class PictureActivity extends AppCompatActivity {
    private TextView pictureText;
    private ImageView pictureImage;
    public static final String PICTURE_NAME = "picture_name";
    public static final String PICTURE_IAMGE_ID = "picture_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_picture);
        Intent intent = getIntent ();
        String pictureName = intent.getStringExtra (PICTURE_NAME);
        int pictureImageId = intent.getIntExtra (PICTURE_IAMGE_ID,0);
        pictureImage = (ImageView)findViewById (R.id.picture_image_view);
        pictureText = (TextView)findViewById (R.id.picture_content_text);
        Toolbar toolbar = (Toolbar)findViewById (R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)
                findViewById (R.id.collapsing_toolbar);
        setSupportActionBar (toolbar);
    }
}
