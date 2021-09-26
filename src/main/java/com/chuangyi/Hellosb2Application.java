package com.chuangyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication:标注这个类是一个sb的应用,且这个启动类下的所有资源被导入
@SpringBootApplication
public class Hellosb2Application {

    public static void main(String[] args) {
        //启动sb应用
        //SpringApplication类
        //run方法：开启了一个服务
        SpringApplication.run(Hellosb2Application.class, args);
    }

}
