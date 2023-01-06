package com.example.coursclassroomexam.Controllers;


import com.example.coursclassroomexam.Entities.*;
import com.example.coursclassroomexam.Serv.Serv;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam")
public class CcController {
    private final Serv serv;
        @PostMapping("/addUser")
    public User addUser (@RequestBody User user) {
        return serv.addUser(user);
    }
    @PostMapping("/addProject")
    public Project addProject (@RequestBody Project project) {
            return serv.addProject(project);
    }

    @PostMapping("/assignProjectToDeveloper/{projectId}/{devId}")
    public void assignProjectToDeveloper (@PathVariable("projectId") int projectId,@PathVariable("devId") int devId) {
        serv.assignProjectToDeveloper(projectId, devId);
    }
    @PostMapping("/assignProjectToScrumMaster/{projectId}/{fName}/{lName}")
    public void assignProjectToScrumMaster(@PathVariable("projectId") int projectId,@PathVariable("fName")  String fName,@PathVariable("lName")  String lName) {
            serv.assignProjectToScrumMaster(projectId, fName, lName);
    }
    @GetMapping("/getProjectsByScrumMaster/{fName}/{lName}")
    public List<Project> getProjectsByScrumMaster(@PathVariable ("fName") String fName,@PathVariable ("lName") String lName) {
         return    serv.getProjectsByScrumMaster(fName, lName);
    }
    @PostMapping("/addSprintAndAssignToProject/{sprint}/{idProject}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable ("idProject")  int idProject) {
            serv.addSprintAndAssignToProject(sprint, idProject);
    }

}
