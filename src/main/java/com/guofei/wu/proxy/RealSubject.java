package com.guofei.wu.proxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("request");
    }
}