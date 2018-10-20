package com.sapob.client.course;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.sapob.client.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassView extends AppCompatActivity {
    private RecyclerView classRecyclerView;
    private CourseAdapter courseAdapter;
    private RecyclerView.LayoutManager courseLayoutManager;

    private final Course[] courses = new Course[]{
            new Course("CS 1331", "Intro to Object Oriented Programming"),
            new Course("ISYE 3770", "Statistics and Applications"),
            new Course("CS 2050", "Intro to Discrete Math"),
            new Course("MATH 1554", "Linear Algebra"),
            new Course("MATH 1553", "Integral Calculus"),
            new Course("MATH 2550", "Multivariable Calculus"),
            new Course("CHEM 1211k", "General Chemistry I"),
            new Course("CHEM 1212k", "General Chemistry II"),
            new Course("ENGL 1101", "English Composition I"),
            new Course("ENGL 1102", "English Composition II"),
            new Course("MATH 3012", "Applied Combinatorics"),
            new Course("CS 2340", "Objects and Design"),
            new Course("CS 3510", "Design & Analysis of Algorithms"),
            new Course("CS 1301", "Introduction to Computing")};
    private final ArrayList<Course> sampleData = new ArrayList<>(Arrays.asList(courses));
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
        courseLayoutManager = new LinearLayoutManager(this);
        classRecyclerView = findViewById(R.id.courseView);
        courseAdapter = new CourseAdapter(dataSet);
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
            if (!(c.getName().toLowerCase().contains(filter.toLowerCase()) || c.getID().toLowerCase().contains(filter.toLowerCase()))) {
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
            if ((c.getName().toLowerCase().contains(filter.toLowerCase()) || c.getID().toLowerCase().contains(filter.toLowerCase())) && !dataSet.contains(c)) {
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
        }
        return list.size() - 1;
    }
}
