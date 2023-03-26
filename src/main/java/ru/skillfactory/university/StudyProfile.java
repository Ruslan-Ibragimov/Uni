package ru.skillfactory.university;

public enum StudyProfile {
    PHYSICS("PHYSICS"),
    MEDICINE("MEDICINE"),
    LINGUISTICS("LINGUISTICS"),
    MATHEMATICS("MATHEMATICS");
    String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
