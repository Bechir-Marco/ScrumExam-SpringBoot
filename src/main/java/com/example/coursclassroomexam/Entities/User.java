package com.example.coursclassroomexam.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    int id;
    String FName ;
    String email;
    String IName;
    String pwd;
    @Enumerated(EnumType.STRING)
    Role role;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "userList")
            @JsonIgnore
    Set<Project> projectList;

    @OneToMany (cascade = CascadeType.ALL)
            @JsonIgnore
    List <Project> projectsUser;
}
