package com.sapob.client.data;

import java.time.LocalTime;

public class Block {
    private int day; 
    private LocalTime start;
    private LocalTime end;

    public Block(int day, LocalTime start, LocalTime end) {
        this.day = day;
        this.start = start;
        this.end = end; 
    }

    public int getDay() {
        return day;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end; 
    }

    @Override 
    public boolean equals(Object o) {
        if(this == o) {
            return true; 
        }
        if(!(o instanceof Block)) {
            return false;
        }
        Block a = (Block)o;
        return a.day == this.day && a.start.equals(this.start) && a.end.equals(this.end);
    }
}