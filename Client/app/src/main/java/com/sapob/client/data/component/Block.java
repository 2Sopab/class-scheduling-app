package com.sapob.client.data.component;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private List<Section> sections;
    private List<BlockUnit> times;

    public Block(List<Section> sections, List<BlockUnit> times) {
        this.sections = sections;
        this.times = times;
    }

    public Block(List<BlockUnit> times) {
        this(new ArrayList<Section>(), times);
    }

    public Block() {
        this(new ArrayList<Section>(), new ArrayList<BlockUnit>());
    }

    public List<Section> getSections() {
        return sections;
    }

    public List<BlockUnit> getTimes() {
        return times;
    }
}