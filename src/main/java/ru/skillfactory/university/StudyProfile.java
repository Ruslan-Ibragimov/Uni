package ru.skillfactory.university;

public enum StudyProfile {
    LINGUISTICS("LINGUISTICS"),
    MATHEMATICS("MATHEMATICS"),
    MEDICINE("MEDICINE"),
    PHYSICS("PHYSICS");

    final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
