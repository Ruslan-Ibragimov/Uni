package ru.skillfactory;

import ru.skillfactory.interfaces.IStudentComparator;
import ru.skillfactory.interfaces.IUniComparator;
import ru.skillfactory.students.comparators.CourseNumberComparator;
import ru.skillfactory.students.comparators.ScoreComparator;
import ru.skillfactory.students.comparators.StudentComparators;
import ru.skillfactory.students.comparators.UIDComparator;
import ru.skillfactory.university.comparators.*;

import java.util.NoSuchElementException;

public final class ComparisonFilter {
    public static IUniComparator getUniComparator(UniComparators uc) {
        switch (uc) {
            case ID -> {
                return new IdComparator();
            }
            case NAME -> {
                return new NameComparator();
            }
            case PROFILE -> {
                return new ProfileComparator();
            }
            case SHORT_NAME -> {
                return new ShortNameComparator();
            }
            case FOUNDATION_YEAR -> {
                return new FYComparator();
            }
        }
        throw new NoSuchElementException("There's no such university comparator");
    }

    public static IStudentComparator getStudentComparator(StudentComparators sc) {
        switch (sc) {
            case NAME -> {
                return new ru.skillfactory.students.comparators.NameComparator();
            }
            case UID -> {
                return new UIDComparator();
            }
            case AVG_SCORE -> {
                return new ScoreComparator();
            }
            case COURSE_NUMBER -> {
                return new CourseNumberComparator();
            }
        }
        throw new NoSuchElementException("There's no such student comparator");
    }
}
