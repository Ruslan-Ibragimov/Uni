package ru.skillfactory;

import ru.skillfactory.students.Student;
import ru.skillfactory.university.StudyProfile;
import ru.skillfactory.university.University;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<University> universities = new ArrayList<>();

        ArrayList<Student> students = new ArrayList<>();

        University spbUni = new University("спб1",
                "Санкт-Петербургский Политехнический Университет",
                "СПБПУ",
                1899,
                StudyProfile.ENGINEER);

        University spbUni1 = new University("спб2",
                "Национальный исследовательский университет ИТМО",
                "ИТМО",
                1900,
                StudyProfile.PROGRAMMER);

        universities.add(spbUni);
        universities.add(spbUni1);




        Student student = new Student("Полный Владимир Сергеевич", "спб1", 1);
        Student student1 = new Student("Ибрагимов Руслан Рустамович", "спб1", 5, 4.2F);
        Student student2 = new Student("Польский Максим Сергеевич", "спб1", 3, 4.9F);
        Student student3 = new Student("Рубцов Александр Дмитриевич", "спб2", 2, 3.6F);
        student.setCurrentCourseNumber(2);
        student.setAvgExamScore(4.8F);

        student1.setAvgExamScore(4.2F);

        student2.setUniversityId("спб2");

        student3.setAvgExamScore(4.1F);
        student3.setCurrentCourseNumber(3);

        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);

        for (University u : universities){
            System.out.println(u);
        }

        for (Student s : students){
            System.out.println(s);
        }

    }
}
