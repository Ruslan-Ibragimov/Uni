package ru.skillfactory.university;

public enum StudyProfile {
    ENGINEER("Инженер"),
    PROGRAMMER("Программист"),
    MATHEMATICIAN("Математик");
    String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
