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
}
