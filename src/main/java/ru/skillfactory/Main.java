package ru.skillfactory;


import ru.skillfactory.auxiliary.ComparisonFilter;
import ru.skillfactory.auxiliary.FullInfo;
import ru.skillfactory.auxiliary.Statistics;
import ru.skillfactory.io.JSONWriter;
import ru.skillfactory.io.XLSXReader;
import ru.skillfactory.io.XLSWriter;
import ru.skillfactory.interfaces.IStudentComparator;
import ru.skillfactory.interfaces.IUniComparator;
import ru.skillfactory.io.XMLWriter;
import ru.skillfactory.students.Student;
import ru.skillfactory.students.comparators.StudentComparators;
import ru.skillfactory.university.University;
import ru.skillfactory.university.comparators.UniComparators;
import ru.skillfactory.utils.StuUniUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e);
        }

        logger.log(Level.INFO, "Application started, Logger configured");


        IUniComparator uniComparator = ComparisonFilter.getUniComparator(UniComparators.ID);
        IStudentComparator studentComparator = ComparisonFilter.getStudentComparator(StudentComparators.AVG_SCORE);

        ArrayList<University> universitiesList = (XLSXReader.getUnis("src/main/resources/universityInfo.xlsx")).stream()
                .sorted(uniComparator)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Student> studentsList = (XLSXReader.getStudents("src/main/resources/universityInfo.xlsx")).stream()
                .sorted(studentComparator)
                .collect(Collectors.toCollection(ArrayList::new));

        List<Statistics> statisticsList = StuUniUtil.createStatistics(studentsList, universitiesList);
        XLSWriter.writeXlsStatistics(statisticsList, "generatedFiles/statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(studentsList)
                .setUniversityList(universitiesList)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XMLWriter.generateXmlReq(fullInfo, "generatedFiles/xmlReqs", "infoReq");
        JSONWriter.writeJsonReq(fullInfo, "generatedFiles/jsonReqs");


        logger.log(Level.INFO, "Execution shutdown");




    }
}
