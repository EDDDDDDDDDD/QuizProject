package com.example.personalproject.controller;

import com.example.personalproject.domain.Quiz;
import com.example.personalproject.domain.User;
import com.example.personalproject.service.QuizService;
import com.example.personalproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class APIController {
    private UserService userService;
    private QuizService quizService;

    @GetMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }
    @GetMapping("/user")
    public User getUserByID(@RequestParam int userID) {
        return userService.getUserByID(userID);
    }
    @GetMapping("/quiz")
    public List<Quiz> getAllQuizByUser(@RequestParam int userID) {
        User target = userService.getUserByID(userID);
        return quizService.getAllQuizByUser(target);
    }
    @PostMapping("/user")
    public String createUser(@Valid @RequestBody User user) {
        Optional<User> possibleUser = userService.validateLogin(user);
        if (!possibleUser.isPresent()) {
            userService.createNewUser(user);
            return "Created User";
        }
        else {
            System.out.println(possibleUser.get().toString());
            return "User existed";
        }
    }
    @DeleteMapping("/user")
    public String deleteUser(@RequestParam int userID) {
        userService.deleteUser(userID);
        return "Deleted UserID: " + userID;
    }
    @PatchMapping("/user/{userid}/status")
    public User changeUserStatus(@RequestParam boolean activate, @PathVariable int userid) {
        User target = userService.getUserByID(userid);
        target.setActive(activate);
        userService.updateUser(target);
        if (activate) {
            return target;
        } else {
            return target;
        }
    }
}
