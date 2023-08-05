package ru.skillfactory.io;

import ru.skillfactory.auxiliary.FullInfo;
import ru.skillfactory.utils.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONWriter {

    private static final Logger logger = Logger.getLogger(JSONWriter.class.getName());
    private JSONWriter() {
    }

    public static void writeJsonReq(FullInfo fullInfo, String jsonPath) {

        logger.log(Level.INFO, "JSON writing started");

        try {
            Files.createDirectory(Paths.get(jsonPath));
            logger.log(Level.INFO, "Directory is successfully created");
        } catch (IOException ioEx) {
            logger.log(Level.FINE, "Directory is already created", ioEx);
        }

        writeStudents(fullInfo, jsonPath, "students");
        writeUniversities(fullInfo, jsonPath, "universities");
        writeStatisticsList(fullInfo, jsonPath, "statistics");

        logger.log(Level.INFO, "JSON writing finished successfully");
    }

    private static void writeStudents(FullInfo fullInfo, String jsonPath, String fileName) {
        String studentsJson = JsonUtil.writeListToJson(fullInfo.getStudentList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream(jsonPath + "/" + fileName + fullInfo.getProcessDate() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students JSON writing failed", e);
        }
        logger.log(Level.INFO, "File saved to " + jsonPath + "/" + fileName + fullInfo.getProcessDate() + ".json");
    }

    private static void writeUniversities(FullInfo fullInfo, String jsonPath, String fileName) {
        String universitiesJson = JsonUtil.writeListToJson(fullInfo.getUniversityList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream(jsonPath + "/" + fileName + fullInfo.getProcessDate() + ".json");
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities JSON writing failed", e);
        }
        logger.log(Level.INFO, "File saved to " + jsonPath + "/" + fileName + fullInfo.getProcessDate() + ".json");
    }

    private static void writeStatisticsList(FullInfo fullInfo, String jsonPath, String fileName) {
        String studentsJson = JsonUtil.writeListToJson(fullInfo.getStatisticsList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream(jsonPath + "/" + fileName + fullInfo.getProcessDate() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics JSON writing failed", e);
        }
        logger.log(Level.INFO, "File saved to " + jsonPath + "/" + fileName + fullInfo.getProcessDate() + ".json");
    }
}
