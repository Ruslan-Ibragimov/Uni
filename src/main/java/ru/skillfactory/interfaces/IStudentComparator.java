package ru.skillfactory.interfaces;

import ru.skillfactory.students.Student;

import java.util.Comparator;

public interface IStudentComparator extends Comparator<Student> {
    @Override
    int compare(Student s1, Student s2);

    @Override
    boolean equals(Object obj);
}
