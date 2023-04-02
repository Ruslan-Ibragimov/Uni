package ru.skillfactory.interfaces;

import ru.skillfactory.university.University;

import java.util.Comparator;

public interface IUniComparator extends Comparator<University> {
    @Override
    int compare(University u1, University u2);

    @Override
    boolean equals(Object obj);
}
