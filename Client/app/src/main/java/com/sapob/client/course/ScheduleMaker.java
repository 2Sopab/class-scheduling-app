package com.sapob.client.course;
import com.sapob.client.data.component.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ScheduleMaker {
    final Section[] sections;
    final Professor[] professors;

    public ScheduleMaker(Section[] sections, Professor[] professors) {
        this.sections = sections;
        this.professors = professors;
    }

    public ArrayList<Section> makeSchedule() {
        ArrayList<String> classNames = new ArrayList<>();
        for (int i = 0; i < sections.length; i++) {
            if (!classNames.contains(sections[i].getCourseName())) {
                classNames.add(sections[i].getCourseName());
            }
        }
        //Reorganize arrays so each array holds only one type of class
        ArrayList<ArrayList<Section>> separatedClasses = new ArrayList<>();
        for (int i = 0; i < sections.length; i++) {
            separatedClasses.get(classNames.indexOf(sections[i].getCourseName())).add(sections[i]);
        }
        //Make permutation of all non-conflicting schedules
        ArrayList<ArrayList<Section>> potentialSchedules =
                recursiveFunction(separatedClasses.get(0), separatedClasses.subList(1, separatedClasses.size()), new ArrayList<Section>());

        if(potentialSchedules.size() == 0)
            return null;
        else {
            ArrayList<Section> ans = potentialSchedules.get(0);
            int maxVal = 0;
            for (int i = 0; i < potentialSchedules.size(); i++) {
                int val = 0;
                for (int j = 0; j < classNames.size(); j++) {
                    Section a = potentialSchedules.get(i).get(j);
                    val += a.getProf().getGPA() + a.getProf().getGPA() + a.getRating();
                }
                if (val >= maxVal) {
                    ans = potentialSchedules.get(i);
                    maxVal = val;
                }
            }
            return ans;
        }
    }

    public ArrayList<ArrayList<Section>> recursiveFunction(ArrayList<Section> current,
                                                           List<ArrayList<Section>> remainder,
                                                           ArrayList<Section> path) {
        ArrayList<ArrayList<Section>> childPaths = new ArrayList<>();
        for (int i = 0; i < current.size(); i++) {
            ArrayList<Section> tempList = (ArrayList) path.clone();
            tempList.add(current.get(i));
            if (remainder.size() != 0 && checkValidity(tempList)) {
                childPaths.addAll(recursiveFunction(remainder.get(0), remainder.subList(1, remainder.size()), tempList));
            } else {
                childPaths.add(tempList);
            }
        }
        return childPaths;
    }

    public boolean checkValidity(ArrayList<Section> schedule) {
        for(int i = 0; i < schedule.size() - 1; i++) {
            for(int j = 0; j < 7; j++) {
                ArrayList<Block> bloks = (ArrayList) schedule.get(i).getBlocks();
                if(bloks.get(0).getStart().compareTo(bloks.get(1).getStart()) >= 0 &&
                        bloks.get(0).getEnd().compareTo(bloks.get(1).getEnd()) <= 0)
                    return false;
                if(bloks.get(0).getStart().compareTo(bloks.get(1).getStart()) <= 0 &&
                        bloks.get(0).getEnd().compareTo(bloks.get(1).getEnd()) >= 0)
                    return false;
            }
        }
    }
}
