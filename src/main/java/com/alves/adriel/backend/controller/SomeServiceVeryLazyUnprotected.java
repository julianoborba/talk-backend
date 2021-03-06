package com.alves.adriel.backend.controller;

import com.alves.adriel.backend.service.MyExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verylazy/unprotected")
public class SomeServiceVeryLazyUnprotected {

    private final MyExecutorService myExecutorService;

    @Autowired
    public SomeServiceVeryLazyUnprotected(final MyExecutorService myExecutorService) {

        this.myExecutorService = myExecutorService;
    }

    @GetMapping
    public String get() throws Exception {

        System.out.println("Very lazy service reached...");

        myExecutorService.execute();

        return "Very lazy service returning...";
    }
}

