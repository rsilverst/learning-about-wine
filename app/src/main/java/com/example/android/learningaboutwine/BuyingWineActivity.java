package com.example.android.learningaboutwine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class BuyingWineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying_wine);

        TextView linkAromaWheel = (TextView) findViewById(R.id.buying_wine_textview);
        linkAromaWheel.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
