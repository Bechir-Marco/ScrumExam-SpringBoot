package com.example.coursclassroomexam.Serv;


import com.example.coursclassroomexam.Entities.*;

import java.util.List;

public interface Serv {

    public User addUser (User user);
    public Project addProject (Project project);
    public void assignProjectToDeveloper (int projectId, int devId);
    public void assignProjectToScrumMaster(int projectId, String fName, String lName);
    public List<Project> getProjectsByScrumMaster(String fName, String lName);
    public void addSprintAndAssignToProject(Sprint sprint, int idProject);

    public void getProjectsCurrentSprints();
}
