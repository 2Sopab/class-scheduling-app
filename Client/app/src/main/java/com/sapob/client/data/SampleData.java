package com.sapob.client.data;

import com.sapob.client.data.component.Block;
import com.sapob.client.data.component.BlockUnit;
import com.sapob.client.data.component.Course;
import com.sapob.client.data.component.Professor;
import com.sapob.client.data.component.Section;

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
    private final List<Professor> professorPool;
    private final Random rand = new Random();
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

    private final List<String> names = new ArrayList<>(Arrays.asList(
            "Domingo Jankowski",
            "Kassandra Mizrahi",
            "Ofelia Odea",
            "Anderson Goodner",
            "Deb Dressel",
            "Donnetta Waguespack",
            "Krissy Geisel",
            "Elba Delucca",
            "Eliana Sabourin",
            "Ozell Lerma",
            "Hannelore Andujar",
            "Talitha Nunemaker",
            "Love Joye",
            "Willette Braxton",
            "Alton Velasquez",
            "Nicholas Calle",
            "Val Wassink",
            "Shan Shuman",
            "Shameka Coghlan",
            "Jacqui Labelle",
            "Rosenda Pelham",
            "Deanne Dinh",
            "Brian Platter",
            "Nolan Hulet",
            "Diane Marr",
            "Trudy Dunkin",
            "Sterling Mor",
            "Carli Bob",
            "Jamel Monsour",
            "Maddie Yoo",
            "Marnie Towle",
            "Laverne Jose",
            "Perry Hough",
            "Telma Rolland",
            "Sanora Klug",
            "Tuan Behar",
            "Theda Leighty",
            "Sonny Murchison",
            "Joanie Strausbaugh",
            "Estelle Wand",
            "Claude Leake",
            "Art Bastin",
            "Douglass Brizendine",
            "Roxie Beauford",
            "Margarett Mcgahan",
            "Joette Haswell",
            "Wendi Raatz",
            "Yasuko Bassler",
            "Irish Davi",
            "Gaston Weiland",
            "Thanh Allin",
            "Larissa Shephard",
            "Angelika Marshburn",
            "Cassondra Letchworth",
            "Elenora Schlatter",
            "Queenie Bowie",
            "Lula Pooler",
            "Andrea Rothchild",
            "Lamont Mani",
            "Tawna Vieyra",
            "Mila Milstead",
            "Tommy Ong",
            "Mellissa Mau",
            "Brigitte Tomita",
            "Denese Wickline",
            "Racquel Nakasone",
            "Shondra Binette",
            "Anderson Lanasa",
            "Marcie Rutledge",
            "Domonique Jobin",
            "Beckie Scianna",
            "Laveta Retherford",
            "Justin Randel",
            "Susan Ishibashi",
            "Alexandria Kaler",
            "Ellena Thoreson",
            "Ladawn Linke",
            "Ora Slover",
            "Imogene Laverdiere",
            "Milagros Ebarb",
            "Marylynn Mortellaro",
            "Keena Greeson",
            "Holly Gettings",
            "Florene Mariscal",
            "Leida Lusher",
            "Milagro Stever",
            "Virgie Leppert",
            "Elyse Kubacki",
            "Inge Kitterman",
            "Noriko Massenburg",
            "Kitty Boulton",
            "Dewitt Devenport",
            "Vanessa Roiger",
            "Hiroko Gouveia",
            "Sharice Drost",
            "Flora Pauley",
            "Amberly Vannoy",
            "Molly Nunley",
            "Chu Darwin",
            "John Riviera"
            ));

    public SampleData() {
        this.timeSlotPool = buildTimeSlotPool();
        this.professorPool = buildProfessorPool();
        for(Course c : courses) {
            int blocks = 1 + rand.nextInt(3);
            int charStart = rand.nextInt(25 - blocks);
            int g = 0;
            for(int i = 0; i < blocks; ++i) {
                List<BlockUnit> timeSlot = this.timeSlotPool.get(rand.nextInt(this.timeSlotPool.size()));
                Block block = new Block(c, timeSlot);
                Professor prof = getRandomProf();
                int sections = 2 + rand.nextInt(4);
                for(int j = 0; j < sections; ++j) {
                    String id = (char) (charStart + 'A' + i) + String.valueOf(j + 1);
                    Section s = new Section(id, rand.nextInt(1000000), getRandomProf(), rand.nextInt(50), block, rand.nextDouble() * 5d);
                    prof.getSections().add(s);
                    block.getSections().add(s);
                }
                c.getBlocks().add(block);
            }
        }
        int i = 0;
    }

    public Professor getRandomProf() {
        return professorPool.get(rand.nextInt(professorPool.size()));
    }

    public List<Professor> buildProfessorPool() {
        ArrayList<String> namesLeft = (ArrayList<String>) ((ArrayList<String>) names).clone();
        List<Professor> professors = new ArrayList<>();
        for(int i = 0; i < names.size(); ++i) {
            professors.add(new Professor(namesLeft.get(rand.nextInt(names.size())), rand.nextDouble() * 4d, rand.nextDouble() * 5d, new ArrayList<Section>()));
        }
        return professors;
    }

    public List<List<BlockUnit>> buildTimeSlotPool() {
        List<List<BlockUnit>> newPool = new ArrayList<>();
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
