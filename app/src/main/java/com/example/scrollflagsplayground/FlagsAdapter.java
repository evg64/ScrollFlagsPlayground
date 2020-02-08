package com.example.scrollflagsplayground;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Evgeny Chumak
 **/
public class FlagsAdapter extends RecyclerView.Adapter<FlagsAdapter.Holder> {

    private final List<FlagItem> mItems;

    public FlagsAdapter(@NonNull List<FlagItem> items) {
        mItems = Collections.unmodifiableList(items);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flag, parent, false);
        return new Holder(view);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(mItems.get(position));
    }

    public List<FlagItem> getItems() {
        return new ArrayList<>(mItems);
    }

    class Holder extends RecyclerView.ViewHolder {
        private final TextView mFlagText;

        public Holder(@NonNull View itemView) {
            super(itemView);
            mFlagText = itemView.findViewById(R.id.flag_text);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                FlagItem clickedItem = mItems.get(position);
                clickedItem.setSelected(!clickedItem.isSelected());
                notifyItemChanged(position);
                // notifyDataSetChanged();
            });
        }

        private void bind(FlagItem item) {
            mFlagText.setText(item.getText());
            itemView.setActivated(item.isSelected());
        }
    }
}
