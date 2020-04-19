package com.example.sugeng;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imgDetail;
    TextView tvDetailName;
    TextView tvDetailDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.img_detail);
        tvDetailName = findViewById(R.id.tv_detail_name);
        tvDetailDetail = findViewById(R.id.tv_detail_detail);

        getIncomingExtra();
    }

    private void getIncomingExtra() {

        if (getIntent().hasExtra("img_url") && getIntent().hasExtra("name_url") && getIntent().hasExtra("detail_url")) {

            String makananImages = getIntent().getStringExtra("img_url");
            String makananNames = getIntent().getStringExtra("name_url");
            String makananDetails = getIntent().getStringExtra("detail_url");

            setDataActivity(makananImages, makananNames, makananDetails);
        }
    }

    private void setDataActivity( String makananImages, String makananNames, String makananDetails) {

        Glide.with(this).load(makananImages).into(imgDetail);

        tvDetailName.setText(makananNames);
        tvDetailDetail.setText(makananDetails);
    }
}