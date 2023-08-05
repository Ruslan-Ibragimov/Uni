package ru.skillfactory.io;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class XLSXReader {
    private static final Logger logger = Logger.getLogger(XLSXReader.class.getName());

    public XLSXReader() {
    }

    public static ArrayList<Student> getStudents(String excelPath) {

        ArrayList<Student> students = new ArrayList<>();

        try {

            logger.log(Level.INFO, "Excel reading started");
            File file = new File(excelPath);
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
            logger.log(Level.SEVERE, "Excel reading failed", e);
            return students;
        }
        logger.log(Level.INFO, "Excel reading finished successfully");
        return students;
    }

    public static ArrayList<University> getUnis(String excelPath) {

        ArrayList<University> unis = new ArrayList<>();

        try {
            logger.log(Level.INFO, "Excel reading started");
            File file = new File(excelPath);
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
            logger.log(Level.SEVERE, "Excel reading failed", e);
            return unis;
        }
        logger.log(Level.INFO, "Excel reading finished successfully");
        return unis;
    }

}
