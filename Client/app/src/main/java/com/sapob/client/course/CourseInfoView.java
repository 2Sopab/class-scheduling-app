package com.sapob.client.course;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sapob.client.Application;
import com.sapob.client.BaseActivity;
import com.sapob.client.R;
import com.sapob.client.data.component.Course;

public class CourseInfoView extends BaseActivity {
    private Course course;
    private CollapsingToolbarLayout toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar = findViewById(R.id.toolbar_layout);
        Intent intent = getIntent();
        course = Application.getDataModel().getFromUUID(intent.getIntExtra("course_uuid", 0));
        toolbar.setTitle(course.getIdentifier());

        setContentView(R.layout.activity_course_info_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
