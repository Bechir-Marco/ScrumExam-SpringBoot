package com.example.coursclassroomexam.Repo;



import com.example.coursclassroomexam.Entities.Sprint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepo extends JpaRepository<Sprint, Integer> {

}
