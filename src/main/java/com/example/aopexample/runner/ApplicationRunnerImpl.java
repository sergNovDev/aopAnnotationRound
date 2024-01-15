package com.example.aopexample.runner;

import com.example.aopexample.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationRunnerImpl implements ApplicationRunner {
    private final MyService myService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        myService.test("FirstParam1",123);
    }
}
