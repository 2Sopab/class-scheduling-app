package com.sapob.client.data.component;

import java.util.Date;

public class BlockUnit {
    private int day; 
    private Date start;
    private Date end;

    public BlockUnit(int day, Date start, Date end) {
        this.day = day;
        this.start = start;
        this.end = end; 
    }

    public int getDay() {
        return day;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end; 
    }

    @Override 
    public boolean equals(Object o) {
        if(this == o) {
            return true; 
        }
        if(!(o instanceof BlockUnit)) {
            return false;
        }
        BlockUnit a = (BlockUnit)o;
        return a.day == this.day && a.start.equals(this.start) && a.end.equals(this.end);
    }
}