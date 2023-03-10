package com.example.coursclassroomexam.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Sprint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    int id ;
   String description;
    @Temporal(TemporalType.DATE)
   Date startDate;
    @ManyToOne(cascade = CascadeType.ALL)
            @JsonIgnore
    Project project;

}
