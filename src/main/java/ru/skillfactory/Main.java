package ru.skillfactory;


import ru.skillfactory.students.Student;
import ru.skillfactory.university.University;


public class Main {

//    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {


        XLSXReader reader = new XLSXReader("src/main/resources/universityInfo.xlsx");
        for (Student s : reader.getStudents()){
            System.out.println(s);
        }

        for (University u : reader.getUnis()){
            System.out.println(u);
        }

    }
}
