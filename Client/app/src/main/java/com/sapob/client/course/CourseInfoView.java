package com.sapob.client.course;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sapob.client.BaseActivity;
import com.sapob.client.R;

public class CourseInfoView extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info_view);

        Bundle resultIntent = getIntent().getExtras();
        String id = "";
        if(resultIntent != null)
        {
            id = resultIntent.getString("course_id");
        }

        TextView textElement = (TextView) findViewById(R.id.course_info_title);
        textElement.setText(id);

    }
}
