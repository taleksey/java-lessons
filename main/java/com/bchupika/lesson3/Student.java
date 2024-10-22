package com.bchupika.lesson3;

import java.util.List;

public record Student(String name, int age, List<Grade> listGradle, String school, Address address) {

    @SuppressWarnings("checkstyle:OperatorWrap")
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", listGradle=" + listGradle +
                ", school='" + school + '\'' +
                ", address=" + address +
                '}';
    }
}
