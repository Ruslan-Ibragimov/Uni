package ru.skillfactory.students.comparators;

import org.apache.commons.lang3.StringUtils;
import ru.skillfactory.interfaces.IStudentComparator;
import ru.skillfactory.students.Student;

public class UIDComparator implements IStudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return StringUtils.compare(s1.getUniversityId(), s2.getUniversityId());
    }
}
