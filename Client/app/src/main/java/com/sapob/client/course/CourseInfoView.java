package com.sapob.client.course;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.sapob.client.Application;
import com.sapob.client.BaseActivity;
import com.sapob.client.R;
import com.sapob.client.data.component.Course;

public class CourseInfoView extends BaseActivity {
    private Course course;
    private TextView title;
    private TextView credits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        course = Application.getDataModel().getCourseFromUUID(intent.getIntExtra("course_uuid", 0));

        setContentView(R.layout.activity_course_info_view);
        Toolbar toolbar = findViewById(R.id.anim_toolbar);
        toolbar.setTitle(course.getIdentifier());
        title = findViewById(R.id.courseTitle);
        title.setText(course.getTitle());
        credits = findViewById(R.id.creditsDisplay);
        credits.setText(course.getCreditHours() + " CREDIT HOUR" + (course.getCreditHours() > 1 ? "S" : ""));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
