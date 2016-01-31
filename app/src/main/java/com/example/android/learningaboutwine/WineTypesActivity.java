package com.example.android.learningaboutwine;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WineTypesActivity extends AppCompatActivity {

    private final ArrayList<List<String>> completeWineList = new ArrayList<>();
    private final List<String> completeWineListNames = new ArrayList<>();
    private int typeIndex = 1;
    private int regionIndex = 5;

    private String typeAppend = "";
    private String regionAppend = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_types);

        Spinner regionsSpinner = (Spinner) findViewById(R.id.regions_spinner);
        final ArrayAdapter<CharSequence> regionsAdapter = ArrayAdapter.createFromResource(this,
                R.array.regions_spinner_elements, android.R.layout.simple_spinner_item);
        regionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regionsSpinner.setAdapter(regionsAdapter);

        Spinner typesSpinner = (Spinner) findViewById(R.id.types_spinner);
        ArrayAdapter<CharSequence> typesAdapter = ArrayAdapter.createFromResource(this,
                R.array.types_spinner_elements, android.R.layout.simple_spinner_item);
        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typesSpinner.setAdapter(typesAdapter);

        List<String> csvWineList = Arrays.asList(getResources().getStringArray(R.array.complete_list));

        for (int i = 0; i < csvWineList.size(); i++) {
            String singleRow = csvWineList.get(i);
            List<String> items = Arrays.asList(singleRow.split("\\s*,\\s*"));
            completeWineList.add(items);
            completeWineListNames.add(items.get(0));

        }

        updateWineList(completeWineListNames);

        typesSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                    typeIndex =position+1;
                typeAppend = parent.getItemAtPosition(position).toString();
                    filterWines();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        regionsSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                regionIndex =position+5;
                regionAppend = parent.getItemAtPosition(position).toString();
                filterWines();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    /**
     * @param wineArray list of wines to be written to the filtered_wine_list TextView
     */
    private void updateWineList(List<String> wineArray) {

        StringBuffer winesString = new StringBuffer();
        for (int i = 0; i < wineArray.size(); i++) {
            winesString.append(wineArray.get(i)).append("\n");
        }
        TextView textView = (TextView) findViewById(R.id.filtered_wine_list);
        textView.setText(winesString);

    }

    private void filterWines() {
        ArrayList<String> filteredWineListNames = new ArrayList();
        for (int i = 0; i < completeWineList.size(); i++) {
            String extractedName = completeWineList.get(i).get(0);
            String a = completeWineList.get(i).get(typeIndex);
            String b = completeWineList.get(i).get(regionIndex);
            if (a.equals("true") && b.equals("true")) {
                filteredWineListNames.add(extractedName);
            }
        }
        TextView wineListTitleView = (TextView) findViewById(R.id.wine_list_title);
        if (typeAppend.contains("All") && regionAppend.contains("All")) {
            wineListTitleView.setText("All Wines");
        } else if (regionAppend.contains("All")) {
            wineListTitleView.setText("All " + typeAppend + " wines");
        } else {
            wineListTitleView.setText(typeAppend + " Wines From " + regionAppend);
        }
        updateWineList(filteredWineListNames);
    }
}