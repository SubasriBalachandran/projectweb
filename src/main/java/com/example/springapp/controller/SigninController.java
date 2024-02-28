package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Signin;
import com.example.springapp.service.SigninService;

@RestController
@RequestMapping("/api")
public class SigninController {
    @Autowired
    private final SigninService signinService;

    public SigninController(SigninService signinService) {
        this.signinService = signinService;
    }

    @PostMapping("/signin")
    // insert the data
    public ResponseEntity<Signin> createSignin(@RequestBody Signin client) {
        Signin createSignin = signinService.createSignin(client);
        return new ResponseEntity<>(createSignin, HttpStatus.CREATED);
    }

    @GetMapping("/signin")
    public ResponseEntity<List<Signin>> getAllSignin() {
        List<Signin> client = signinService.getAllSignin();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/signin/{signinId}")
    public ResponseEntity<Signin> getById(@PathVariable int signinId) {
        Signin client = signinService.getSigninId(signinId);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/signin/{id}")
    public ResponseEntity<Signin> update(@PathVariable int id, @RequestBody Signin client) {
        return new ResponseEntity<>(signinService.update(id, client), HttpStatus.OK);
    }

    @DeleteMapping("/signin/{signId}")
    public ResponseEntity<Void> delete(@PathVariable int signId) {
        signinService.delete(signId);
        return ResponseEntity.noContent().build();
    }
}