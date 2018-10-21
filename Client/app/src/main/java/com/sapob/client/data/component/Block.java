package com.sapob.client.data.component;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private List<Section> sections;
    private List<BlockUnit> times;
    private Course course;

    public Block(Course c, List<Section> sections, List<BlockUnit> times) {
        this.sections = sections;
        this.times = times;
        this.course = c;
    }

    public Block(Course c, List<BlockUnit> times) {
        this(c, new ArrayList<Section>(), times);
    }

    public Block(Course c) {
        this(c, new ArrayList<Section>(), new ArrayList<BlockUnit>());
    }

    public List<Section> getSections() {
        return sections;
    }

    public List<BlockUnit> getTimes() {
        return times;
    }

    public Course getCourse() {
        return course;
    }
}