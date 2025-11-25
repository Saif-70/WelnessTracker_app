package com.example.weinesstracker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView recentEntriesList;
    private Button addEntryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        recentEntriesList = findViewById(R.id.recentEntriesList);
        addEntryButton = findViewById(R.id.addEntryButton);

        // Setup recent entries list with static data
        setupRecentEntries();

        // Set click listener for add entry button
        addEntryButton.setOnClickListener(v -> {
            // For now, just show a message since this is static UI
            android.widget.Toast.makeText(
                    MainActivity.this,
                    "Add Entry Feature - To be implemented",
                    android.widget.Toast.LENGTH_SHORT
            ).show();
        });
    }

    private void setupRecentEntries() {
        // Static data for demonstration
        List<String> recentEntries = Arrays.asList(
                "Nov 15: 76.2 kg - Good progress",
                "Nov 14: 76.5 kg - Maintained",
                "Nov 13: 76.8 kg - Light workout",
                "Nov 12: 77.0 kg - Rest day",
                "Nov 11: 77.2 kg - Intense workout"
        );

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                recentEntries
        );

        recentEntriesList.setAdapter(adapter);
    }
}