package com.example.mongo;

import com.example.mongo.model.User;
import com.example.mongo.repo.UserRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
@SpringBootApplication
public class SpringMongoApplication {

    @Autowired
    private UserRepository user;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoApplication.class, args);
    }

    @PostConstruct
    private void postInit() {

    }

    @GetMapping("")
    public List<User> getAll() {
        return user.findAll();

    }

    @PostMapping("/simpan")
    public User save(@RequestBody User p) {
        return user.save(p);

    }

}
