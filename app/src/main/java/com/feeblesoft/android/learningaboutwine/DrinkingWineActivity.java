package com.feeblesoft.android.learningaboutwine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class DrinkingWineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinking_wine);

        TextView linkAromaWheel = (TextView) findViewById(R.id.aroma_wheel_view);
        linkAromaWheel.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkWinePairing = (TextView) findViewById(R.id.wine_pairing_overview_text);
        linkWinePairing.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkWineDrinking = (TextView) findViewById(R.id.wine_drinking_overview_text);
        linkWineDrinking.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
