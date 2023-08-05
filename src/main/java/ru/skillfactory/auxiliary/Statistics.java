package ru.skillfactory.auxiliary;

import ru.skillfactory.university.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)

public class Statistics {
    @XmlElement(name = "studyProfile")
    public StudyProfile studyProfile;
    @XmlElement(name = "avgExamScore")
    public float avgExamScore;
    @XmlElement(name = "numberOfStudents")
    public int numberOfStudents;
    @XmlTransient
    public int numberOfUniversities;
    @XmlElement(name = "universities")
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
