package ru.skillfactory;


import ru.skillfactory.interfaces.IStudentComparator;
import ru.skillfactory.interfaces.IUniComparator;
import ru.skillfactory.students.comparators.StudentComparators;
import ru.skillfactory.university.comparators.UniComparators;


public class Main {

//    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        XLSXReader reader = new XLSXReader("src/main/resources/universityInfo.xlsx");
        IUniComparator uniComparator = ComparisonFilter.getUniComparator(UniComparators.ID);
        IStudentComparator studentComparator = ComparisonFilter.getStudentComparator(StudentComparators.AVG_SCORE);

        (reader.getStudents()).stream().sorted(studentComparator).forEach(System.out::println);
        (reader.getUnis()).stream().sorted(uniComparator).forEach(System.out::println);



    }
}
