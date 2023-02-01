package com.async.example.springbootasyncexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.core.task.TaskExecutor;

@RestController
public class HelloWorldCompletableFutureController {

    private final TaskExecutor taskExecutor;

    public HelloWorldCompletableFutureController(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @GetMapping(value = "/testCompletableFuture")
    public CompletableFuture<String> echoHelloWorld2() {
        return CompletableFuture.supplyAsync(() -> {
            randomDelay();
            return "Hello World !!";
        }, taskExecutor);
    }

    private void randomDelay() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
