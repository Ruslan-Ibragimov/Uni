package ru.skillfactory.university.comparators;

public enum UniComparators {
    FOUNDATION_YEAR("FOUNDATION_YEAR"),
    ID("ID"),
    NAME("NAME"),
    PROFILE("PROFILE"),
    SHORT_NAME("SHORT_NAME");

    final String comparator;

    UniComparators(String comparator) {
        this.comparator = comparator;
    }
}
