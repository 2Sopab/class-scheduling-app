package com.sapob.client.data;

import com.sapob.client.data.component.Block;
import com.sapob.client.data.component.Course;
import java.util.List;

public interface DataModel {
    public List<Course> getCourses();
    public List<Block> getBlocks();
    public Course getCourseFromUUID(int uuid);
}
