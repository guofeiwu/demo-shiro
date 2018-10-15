package com.guofei.wu.proxy;


public class DynamicProxyDemo {
    public static void main(String[] args) {
        //1.创建委托对象
        RealSubject realSubject = new RealSubject();
        //2.创建调用处理器对象
        ProxyHandler handler = new ProxyHandler(realSubject);
        //3.动态生成代理对象
        Subject proxySubject = (Subject) java.lang.reflect.Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(), handler);
        //4.通过代理对象调用方法
        proxySubject.request();
    }
}