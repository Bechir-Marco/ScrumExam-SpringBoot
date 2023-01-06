package com.example.coursclassroomexam.Serv;
import com.example.coursclassroomexam.Entities.Project;
import com.example.coursclassroomexam.Entities.Role;
import com.example.coursclassroomexam.Entities.Sprint;
import com.example.coursclassroomexam.Entities.User;
import com.example.coursclassroomexam.Repo.ProjectRepo;
import com.example.coursclassroomexam.Repo.SprintRepo;
import com.example.coursclassroomexam.Repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServImp implements Serv {

    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    SprintRepo sprintRepo;
    @Autowired
    UserRepo userRepo;

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public Project addProject(Project project) {

        return projectRepo.save(project);
    }

    public void assignProjectToDeveloper(int projectId, int devId) {
        Project p = projectRepo.findById(projectId).orElse(null);
        User u = userRepo.findById(devId).orElse(null);

        p.getUserList().add(u);
        projectRepo.save(p);

    }

    public void assignProjectToScrumMaster(int projectId, String fName, String lName) {
        Project p = projectRepo.findById(projectId).orElse(null);
        User u = userRepo.findUserByFNameAndIName(fName, lName);
        u.getProjectsUser().add(p);
        userRepo.save(u);
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        User u = userRepo.findUserByFNameAndINameAndRole(fName, lName, Role.SCRUM_MASTER);
        return u.getProjectsUser();
    }

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepo.findById(idProject).orElse(null);
        sprint.setProject(project);
        sprintRepo.save(sprint);
    }

    @Scheduled (cron = "*/5 * * * * *")
    public void getProjectsCurrentSprints() {
        List<Project> projects = projectRepo.findAll();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        for (Project project : projects) {
            for (Sprint sp : project.getSprintList()) {
                if (sp.getStartDate().before(new Date())) {
                    log.info(project.getTitle());
                }
            }
        }
    }
}

