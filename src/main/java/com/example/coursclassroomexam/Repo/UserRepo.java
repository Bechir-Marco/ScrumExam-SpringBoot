package com.example.coursclassroomexam.Repo;
import com.example.coursclassroomexam.Entities.Role;
import com.example.coursclassroomexam.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository <User, Integer> {
    User findUserByFNameAndIName(String FName, String IName);
    User findUserByFNameAndINameAndRole(String fName, String lName, Role role);
}
