package com.sapob.client.course;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sapob.client.BaseActivity;
import com.sapob.client.R;
import java.util.List;

import com.sapob.client.data.*;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private List<Course> dataSet;
    private BaseActivity parent;
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView nameView;
        private final TextView idView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameView = itemView.findViewById(R.id.nameView);
            idView = itemView.findViewById(R.id.idView);
        }

        public TextView getNameView() {
            return nameView;
        }

        public TextView getIdView() {
            return idView;
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && position < dataSet.size()) {
                Course c = dataSet.get(position);
                Intent intent = new Intent(parent, CourseInfoView.class);
                intent.putExtra("course_id", c.getID());
                parent.startActivity(intent);
                parent.overridePendingTransitionEnter();
            }
        }
    }

    public CourseAdapter(List<Course> dataSet, BaseActivity newParent) {
        this.dataSet = dataSet;
        parent = newParent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_row_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getIdView().setText(dataSet.get(position).getID());
        viewHolder.getNameView().setText(dataSet.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
