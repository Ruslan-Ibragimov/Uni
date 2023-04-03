package ru.skillfactory;


import ru.skillfactory.interfaces.IStudentComparator;
import ru.skillfactory.interfaces.IUniComparator;
import ru.skillfactory.students.Student;
import ru.skillfactory.students.comparators.StudentComparators;
import ru.skillfactory.university.University;
import ru.skillfactory.university.comparators.UniComparators;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class Main {

//    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        XLSXReader reader = new XLSXReader("src/main/resources/universityInfo.xlsx");
        IUniComparator uniComparator = ComparisonFilter.getUniComparator(UniComparators.ID);
        IStudentComparator studentComparator = ComparisonFilter.getStudentComparator(StudentComparators.AVG_SCORE);

        // get original lists
        ArrayList<University> uniList = (reader.getUnis()).stream()
                .sorted(uniComparator)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Student> stList = (reader.getStudents()).stream()
                .sorted(studentComparator)
                .collect(Collectors.toCollection(ArrayList::new));

        //to json and print
        String uniJson = JsonUtil.unisToJson(uniList);
        String stJson = JsonUtil.studentsToJson(stList);
        System.out.println(stJson);
        System.out.println(uniJson);

        // deserialize
        ArrayList<University> deUnis = JsonUtil.jsonToUnis(uniJson);
        ArrayList<Student> deStudents = JsonUtil.jsonToStudents(stJson);

        // show if lists are the same size
        if (uniList.size() == deUnis.size() && stList.size() == deStudents.size()){
            System.out.println("Collections are the same size");
        }

        // separate universities to json, print, then deserialize, and print again,
        System.out.println("----------------------------------------\n Universities:");
        deUnis.stream().sorted(uniComparator).forEach(uni -> {
            String jUni = JsonUtil.uniToJson(uni);
            System.out.println(jUni);
            System.out.println("toString() result: " + JsonUtil.jsonToUni(jUni));
        });

        // separate students to json, print, then deserialize, and print again,
        System.out.println("----------------------------------------\n Students:");
        deStudents.stream().sorted(studentComparator).forEach(student -> {
            String jStudent = JsonUtil.studentToJson((student));
            System.out.println(jStudent);
            System.out.println("toString() result: " + JsonUtil.jsonToStudent(jStudent));
        });




    }
}
