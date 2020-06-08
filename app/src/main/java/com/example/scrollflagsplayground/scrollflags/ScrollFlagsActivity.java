package com.example.scrollflagsplayground.scrollflags;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.scrollflagsplayground.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class ScrollFlagsActivity extends AppCompatActivity {

    private static final String EXTRA_SCROLL_FLAGS = "EXTRA_SCROLL_FLAGS";
    private static final String EXTRA_COLLAPSE_MODE = "EXTRA_COLLAPSE_MODE";
    private static final int NOTHING = -1;

    public static void launch(Activity from, int scrollFlags, int collapseMode) {
        Intent intent = new Intent(from, ScrollFlagsActivity.class);
        intent.putExtra(EXTRA_SCROLL_FLAGS, scrollFlags);
        intent.putExtra(EXTRA_COLLAPSE_MODE, collapseMode);
        from.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        setupAppbar();

        // apply scroll flags
        Intent intent = getIntent();
        int scrollFlags = intent.getIntExtra(EXTRA_SCROLL_FLAGS, NOTHING);
        if (scrollFlags != NOTHING) {
            AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) findViewById(R.id.collapsing_toolbar_layout)
                    .getLayoutParams();
            params.setScrollFlags(scrollFlags);
        }

        // apply collapse mode
        int collapseMode = intent.getIntExtra(EXTRA_COLLAPSE_MODE, NOTHING);
        if (collapseMode != NOTHING) {
            CollapsingToolbarLayout.LayoutParams params = (CollapsingToolbarLayout.LayoutParams) findViewById(R.id.image)
                    .getLayoutParams();
            params.setCollapseMode(collapseMode);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void setupAppbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("4%");
        }
    }
}
