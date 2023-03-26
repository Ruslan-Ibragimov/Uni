package ru.skillfactory;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.skillfactory.students.Student;
import ru.skillfactory.university.StudyProfile;
import ru.skillfactory.university.University;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class XLSXReader {
    String path;

    public XLSXReader(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public XLSXReader setPath(String path) {
        this.path = path;
        return this;
    }

    public ArrayList<Student> getStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("Студенты");
            Iterator<Row> rowIterator = sheet.iterator();


            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() > 0) {
                    Student s = new Student(
                            row.getCell(1).getStringCellValue(),
                            row.getCell(0).getStringCellValue(),
                            (int) row.getCell(2).getNumericCellValue(),
                            (float) row.getCell(3).getNumericCellValue());
                    students.add(s);
                }

            }

        } catch (
                IOException e) {
            System.out.println(e);
        }
        return students;
    }

    public ArrayList<University> getUnis() {

        ArrayList<University> unis = new ArrayList<>();

        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("Университеты");
            Iterator<Row> rowIterator = sheet.iterator();


            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() > 0) {
                    University uni = new University(
                            row.getCell(0).getStringCellValue(),
                            row.getCell(1).getStringCellValue(),
                            row.getCell(2).getStringCellValue(),
                            (int)row.getCell(3).getNumericCellValue(),
                            StudyProfile.valueOf(row.getCell(4).getStringCellValue()));
                    unis.add(uni);
                }

            }

        } catch (
                IOException e) {
            System.out.println(e);
        }
        return unis;
    }

}
