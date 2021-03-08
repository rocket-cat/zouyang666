package com.itheima.service.user;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provide {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");

        context.start();
        System.in.read();
    }
}
