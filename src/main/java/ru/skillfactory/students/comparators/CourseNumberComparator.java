package ru.skillfactory.students.comparators;

import ru.skillfactory.interfaces.IStudentComparator;
import ru.skillfactory.students.Student;

public class CourseNumberComparator implements IStudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getCurrentCourseNumber(), s2.getCurrentCourseNumber());
    }
}
