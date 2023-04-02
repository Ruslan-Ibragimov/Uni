package ru.skillfactory.students.comparators;

import ru.skillfactory.interfaces.IStudentComparator;
import ru.skillfactory.students.Student;

public class ScoreComparator implements IStudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getAvgExamScore(), s1.getAvgExamScore());
    }
}
