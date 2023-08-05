package ru.skillfactory.university;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class University {
    @SerializedName("universityId")
    @XmlElement(name = "universityId")
    final String id;
    @SerializedName("universityName")
    @XmlElement(name = "universityName")
    private String fullName;
    @SerializedName("shortName")
    @XmlTransient
    private String shortName;
    @SerializedName("foundationYear")
    @XmlTransient
    final int yearOfFoundation;
    @SerializedName("universityProfile")
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;


    public University(String id, String fullName, int yearOfFoundation) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfFoundation = yearOfFoundation;
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }


    public String getId() {
        return id;
    }


    public String getFullName() {
        return fullName;
    }


    public String getShortName() {
        return shortName;
    }


    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}
