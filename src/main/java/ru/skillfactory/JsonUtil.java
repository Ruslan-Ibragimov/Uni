package ru.skillfactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.skillfactory.students.Student;
import ru.skillfactory.university.University;

import java.util.ArrayList;
import java.util.List;

public final class JsonUtil {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static String uniToJson(University university){
        return gson.toJson(university);
    }

    public static String unisToJson(ArrayList<University> unis){
        return gson.toJson(unis);
    }
    public static String studentToJson (Student student){
        return gson.toJson(student);
    }

    public static String studentsToJson(ArrayList<Student> students){
        return gson.toJson(students);
    }

    public static University jsonToUni(String json){
        return gson.fromJson(json, University.class);
    }

    public static ArrayList<University> jsonToUnis(String json){
        return gson.fromJson(json, new TypeToken<List<University>>(){}.getType());
    }
    public static Student jsonToStudent(String json){
        return gson.fromJson(json, Student.class);
    }

    public static ArrayList<Student> jsonToStudents(String json){
        return gson.fromJson(json, new TypeToken<List<Student>>(){}.getType());
    }
}
