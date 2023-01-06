package com.example.coursclassroomexam.Repo;
import com.example.coursclassroomexam.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository <User, Integer> {

}
