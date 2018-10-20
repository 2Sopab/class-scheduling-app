package com.sapob.client.data;

import android.util.Log;

import com.sapob.client.data.component.Block;
import com.sapob.client.data.component.BlockUnit;
import com.sapob.client.data.component.Course;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class SampleData implements DataModel {
    private final List<List<BlockUnit>> timeSlotPool;
    private final List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("CS 1331", "Intro to Object Oriented Programming"),
            new Course("ISYE 3770", "Statistics and Applications"),
            new Course("CS 2050", "Intro to Discrete Math"),
            new Course("MATH 1554", "Linear Algebra", 4),
            new Course("MATH 1553", "Integral Calculus", 4),
            new Course("MATH 2550", "Multivariable Calculus", 2),
            new Course("CHEM 1211k", "General Chemistry I", 4),
            new Course("CHEM 1212k", "General Chemistry II", 4),
            new Course("ENGL 1101", "English Composition I"),
            new Course("ENGL 1102", "English Composition II"),
            new Course("MATH 3012", "Applied Combinatorics"),
            new Course("CS 2340", "Objects and De   sign"),
            new Course("CS 3510", "Design & Analysis of Algorithms"),
            new Course("CS 1301", "Introduction to Computing")));

    public SampleData() {
        this.timeSlotPool = buildTimeSlotPool();

    }

    public static List<List<BlockUnit>> buildTimeSlotPool() {
        List<List<BlockUnit>> newPool = new ArrayList<>();
        Random rand = new Random();
        final Date begin = new Date(0);
        begin.setHours(8);
        final Date recitationBegin = (Date) begin.clone();
        recitationBegin.setHours(18);
        final int numOfSections = 10;
        Date current = begin;
        for(int i = 0; i < numOfSections; ++i) {
            Date start = (Date) current.clone();
            current.setMinutes(current.getMinutes() + 55);
            Date end = (Date) current.clone();
            List<BlockUnit> weekBlock = new ArrayList<>();
            weekBlock.add(new BlockUnit(1, start, end));
            weekBlock.add(new BlockUnit(3, start, end));
            weekBlock.add(new BlockUnit(5, start, end));
            if(rand.nextBoolean()) {
                Date recitationEnd = (Date) recitationBegin.clone();
                recitationEnd.setMinutes(recitationBegin.getMinutes() + (rand.nextInt(4) + 4) * 15);
                weekBlock.add(new BlockUnit(rand.nextBoolean() ? 2 : 4, recitationBegin, recitationEnd));
            }
            current.setMinutes(current.getMinutes() + 15);
            newPool.add(weekBlock);
        }
        for(int i = 0; i < numOfSections; ++i) {
            Date start = (Date) current.clone();
            current.setMinutes(current.getMinutes() + 75);
            Date end = (Date) current.clone();
            List<BlockUnit> weekBlock = new ArrayList<>();
            weekBlock.add(new BlockUnit(2, start, end));
            weekBlock.add(new BlockUnit(4, start, end));
            current.setMinutes(current.getMinutes() + 15);
            newPool.add(weekBlock);
        }
        return newPool;
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public List<Block> getBlocks() {
        return this.getCourses().stream().map(new Function<Course, List<Block>>() {
            @Override
            public List<Block> apply(Course c) {
                return c.getBlocks();
            }
        }).reduce(new ArrayList<Block>(), new BinaryOperator<List<Block>>() {
            @Override
            public List<Block> apply(List<Block> blocks, List<Block> blocks2) {
                blocks.addAll(blocks2);
                return blocks;
            }
        });
    }

    @Override
    public Course getCourseFromUUID(int uuid) {
        final int uuidRef = uuid;
        return courses.stream().filter(new Predicate<Course>() {
            @Override
            public boolean test(Course c) {
                return c.getUUID() == uuidRef;
            }
        }).findFirst().orElse(null);
    }
}
