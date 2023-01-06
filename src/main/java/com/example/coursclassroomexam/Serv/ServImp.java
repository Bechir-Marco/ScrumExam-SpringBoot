package com.example.coursclassroomexam.Serv;
import com.example.coursclassroomexam.Entities.User;
import com.example.coursclassroomexam.Repo.ProjectRepo;
import com.example.coursclassroomexam.Repo.SprintRepo;
import com.example.coursclassroomexam.Repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User addUser (User user) {
        return userRepo.save(user);
    }
}

