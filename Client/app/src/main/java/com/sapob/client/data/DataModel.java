package com.sapob.client.data;

import com.sapob.client.data.component.Course;
import java.util.List;

public interface DataModel {
    public List<Course> getCourses();
    public Course getFromUUID(int uuid);
}
