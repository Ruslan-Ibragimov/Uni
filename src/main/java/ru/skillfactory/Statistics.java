package ru.skillfactory;

import ru.skillfactory.university.StudyProfile;

public class Statistics {
    public StudyProfile studyProfile;
    public float avgExamScore;
    public int numberOfStudents;
    public int numberOfUniversities;
    public String universities;

    public Statistics() {
    }

    public Statistics(StudyProfile studyProfile, float avgExamScore, int numberOfStudents, int numberOfUniversities, String universities) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.numberOfStudents = numberOfStudents;
        this.numberOfUniversities = numberOfUniversities;
        this.universities = universities;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    public String getUniversities() {
        return universities;
    }

    public Statistics setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
        return this;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public Statistics setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public Statistics setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
        return this;
    }

    public Statistics setUniversities(String universities) {
        this.universities = universities;
        return this;
    }
}
