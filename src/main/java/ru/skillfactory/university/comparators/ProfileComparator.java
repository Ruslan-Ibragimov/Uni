package ru.skillfactory.university.comparators;

import ru.skillfactory.interfaces.IUniComparator;
import ru.skillfactory.university.University;

public class ProfileComparator implements IUniComparator {
    @Override
    public int compare(University u1, University u2) {
        return u1.getMainProfile().compareTo(u2.getMainProfile());
    }
}
