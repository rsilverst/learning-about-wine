package com.feeblesoft.android.learningaboutwine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void displayWineTypes(View view){
        Intent intent = new Intent(this, WineTypesActivity.class);
        startActivity(intent);
    }

    public void displayBuyingWine(View view){
        Intent intent = new Intent(this, BuyingWineActivity.class);
        startActivity(intent);
    }

    public void displayDrinkingWine(View view){
        Intent intent = new Intent(this, DrinkingWineActivity.class);
        startActivity(intent);
    }

    public void displayStoringWine(View view){
        Intent intent = new Intent(this, StoringWineActivity.class);
        startActivity(intent);
    }

}

