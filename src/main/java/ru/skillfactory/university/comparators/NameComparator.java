package ru.skillfactory.university.comparators;

import org.apache.commons.lang3.StringUtils;
import ru.skillfactory.interfaces.IUniComparator;
import ru.skillfactory.university.University;

public class NameComparator implements IUniComparator {
    @Override
    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getFullName(), u2.getFullName());
    }
}
