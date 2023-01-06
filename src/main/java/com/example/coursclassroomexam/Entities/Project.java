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
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    int id;
    String title;
    String description;

    @ManyToMany(cascade = CascadeType.ALL)
    List <User> userList;
}
