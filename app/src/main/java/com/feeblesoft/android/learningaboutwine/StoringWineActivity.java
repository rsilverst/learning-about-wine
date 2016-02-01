package com.feeblesoft.android.learningaboutwine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StoringWineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storing_wine);
    }

    public void displayTaggingWine(View view) {
        Intent intent = new Intent(this, TaggingWineActivity.class);
        startActivity(intent);
    }

}