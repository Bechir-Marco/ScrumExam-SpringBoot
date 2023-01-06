package com.example.coursclassroomexam.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    int id;
    String fName ;
    String email;
    String IName;
    String pwd;
    @Enumerated(EnumType.STRING)
    Role role;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "userList")
            @JsonIgnore
    List <Project> projectList;

    @OneToMany (cascade = CascadeType.ALL)
            @JsonIgnore
    List <Project> projectsUser;
}
