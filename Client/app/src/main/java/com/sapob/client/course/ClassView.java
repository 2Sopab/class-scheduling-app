package com.sapob.client.course;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.sapob.client.Application;
import com.sapob.client.BaseActivity;
import com.sapob.client.R;
import com.sapob.client.data.component.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassView extends BaseActivity {
    private CourseAdapter courseAdapter;

    private final ArrayList<Course> sampleData = new ArrayList<>(Application.getDataModel().getCourses());
    private final ArrayList<Course> dataSet;

    public ClassView() {
        super();
        Collections.sort(sampleData);
        dataSet = (ArrayList<Course>) sampleData.clone();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_view);
        RecyclerView.LayoutManager courseLayoutManager = new LinearLayoutManager(this);
        RecyclerView classRecyclerView = findViewById(R.id.courseView);
        courseAdapter = new CourseAdapter(dataSet, this);
        classRecyclerView.setAdapter(courseAdapter);
        classRecyclerView.setLayoutManager(courseLayoutManager);

        ((EditText) findViewById(R.id.courseSearch)).addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override public void afterTextChanged(Editable s) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String after = s.toString();
                if(after.length() > before) {
                    filterNarrow(after);
                } else filterExpand(after);
            }
        });
    }

    protected void filterNarrow(String filter) {
        List<Integer> culledIndices = new ArrayList<>();
        for (int i = 0; i < dataSet.size(); ++i) {
            Course c = dataSet.get(i);
            if (!(c.getIdentifier().toLowerCase().contains(filter.toLowerCase()) || c.getTitle().toLowerCase().contains(filter.toLowerCase()))) {
                culledIndices.add(i);
            }
        }
        int j = 0;
        for (Integer i : culledIndices) {
            dataSet.remove(i - j);
            courseAdapter.notifyItemRemoved(i - j);
            ++j;
        }
    }

    protected void filterExpand(String filter) {
        List<Course> toAdd = new ArrayList<>();
        for (int i = 0; i < sampleData.size(); ++i) {
            Course c = sampleData.get(i);
            if ((c.getIdentifier().toLowerCase().contains(filter.toLowerCase()) || c.getTitle().toLowerCase().contains(filter.toLowerCase())) && !dataSet.contains(c)) {
                courseAdapter.notifyItemInserted(sortedInsert(dataSet, c));
            }
        }
    }

    protected <T extends Comparable<T>> int sortedInsert(List<T> list, T target) {
        for (int i = 0; i < list.size(); ++i) {
            if(list.get(i).compareTo(target) > 0) {
                list.add(i, target);
                return i;
            }
        }
        if(list.size() != 0) {
            list.add(list.size() - 1, target);
        } else {
            list.add(target);
        }
        return list.size() - 1;
    }
}
