package com.sapob.client.course;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sapob.client.BaseActivity;
import com.sapob.client.R;
import com.sapob.client.data.component.Block;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder> {
    private List<Block> dataSet;
    private BaseActivity parent;
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Layout variables

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            // Initialize view

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && position < dataSet.size()) {
                // Check box
            }
        }
    }

    public TimeAdapter(List<Block> dataSet, BaseActivity newParent) {
        this.dataSet = dataSet;
        parent = newParent;
    }

    @NonNull
    @Override
    public TimeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_row_item, viewGroup, false);
        return new TimeAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TimeAdapter.ViewHolder viewHolder, final int position) {
        // Init view
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
