package com.gapache.commons.jvm.classloader;

import java.sql.DriverManager;

public class MyTest27 {

    public static void main(String[] args) throws Exception {
        // 分析这两行代码干了哪些事情？
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb", "username", "password");
    }
}
