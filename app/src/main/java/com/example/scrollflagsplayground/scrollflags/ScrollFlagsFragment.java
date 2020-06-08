package com.example.scrollflagsplayground.scrollflags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scrollflagsplayground.R;
import com.example.scrollflagsplayground.data.DataProvider;
import com.example.scrollflagsplayground.flagsadapter.FlagsAdapter;

/**
 * @author Evgeny Chumak
 **/
public class ScrollFlagsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scroll_flags, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView collapseModes = view.findViewById(R.id.recyclerScrollFlags);
        DataProvider dataProvider = new DataProvider(getResources());
        FlagsAdapter adapter = new FlagsAdapter(dataProvider.getScrollFlagItems());
        collapseModes.setAdapter(adapter);

        Spinner spinnerCollapseMode = view.findViewById(R.id.spinner_collapse_mode);
        spinnerCollapseMode.setAdapter(
                new ArrayAdapter<>(
                        requireActivity(),
                        android.R.layout.simple_spinner_dropdown_item,
                        dataProvider.getCollapseModeItems()
                )
        );

        view.findViewById(R.id.button_test_flags).setOnClickListener(v -> {
            int scrollFlags = dataProvider.calculateScrollFlags(adapter.getItems());
            CollapseMode collapseMode = (CollapseMode) spinnerCollapseMode.getSelectedItem();
            ScrollFlagsActivity.launch(requireActivity(), scrollFlags, collapseMode.getMode());
        });
    }
}
