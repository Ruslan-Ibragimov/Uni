package ru.skillfactory.students.comparators;

public enum StudentComparators {
    COURSE_NUMBER("COURSE_NUMBER"),
    NAME("NAME"),
    AVG_SCORE("AVG_SCORE"),
    UID("UID");

    final String comparator;

    StudentComparators(String comparator) {
        this.comparator = comparator;
    }
}
