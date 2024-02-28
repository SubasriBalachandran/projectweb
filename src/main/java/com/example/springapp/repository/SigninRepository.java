package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Signin;

@Repository
public interface SigninRepository extends JpaRepository<Signin, Integer> {

}