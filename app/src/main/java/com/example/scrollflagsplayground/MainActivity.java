package com.example.scrollflagsplayground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView collapseModes = findViewById(R.id.recyclerScrollFlags);
        DataProvider dataProvider = new DataProvider(getResources());
        FlagsAdapter adapter = new FlagsAdapter(dataProvider.getScrollFlagItems());
        collapseModes.setAdapter(adapter);

        Spinner spinnerCollapseMode = findViewById(R.id.spinner_collapse_mode);
        spinnerCollapseMode.setAdapter(
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        dataProvider.getCollapseModeItems()
                )
        );

        findViewById(R.id.button_test_flags).setOnClickListener(v -> {
            int scrollFlags = dataProvider.calculateScrollFlags(adapter.getItems());
            CollapseMode collapseMode = (CollapseMode) spinnerCollapseMode.getSelectedItem();
            CoordinatorActivity.launch(this, scrollFlags, collapseMode.getMode());
        });
    }

}
