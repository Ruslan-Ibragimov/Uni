package ru.skillfactory.university.comparators;

import ru.skillfactory.interfaces.IUniComparator;
import ru.skillfactory.university.University;

public class FYComparator implements IUniComparator {
    @Override
    public int compare(University u1, University u2) {
        return Integer.compare(u1.getYearOfFoundation(), u2.getYearOfFoundation());
    }
}
