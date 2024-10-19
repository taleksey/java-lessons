package com.learn.lesson3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Student> students = generateStudents();
        List<StudentGradeRecord> studentGradeRecord = students.stream()
                .filter(student -> student.address().city().equals("New York"))
                .filter(student -> student.age() > 15)
                .flatMap(student ->
                        student.listGradle().stream()
                                .map(grade -> new StudentGradeRecord(student.name(), student.school(), grade.name(), grade.score()))
                )
                .sorted(Comparator.comparingDouble(StudentGradeRecord::score).reversed())
                .limit(3)
                .toList();

        studentGradeRecord.stream().map(Service::toString)
                .forEach(System.out::println);
    }

    public static List<Student> generateStudents() {
        List<Student> students = new ArrayList<>();

        String[] address = new String[]{"New York", "Dallas", "Toronto", "Los Angeles", "Tampa"};
        int age;

        for (int i = 0; i < 10; i++) {
            String studentName = "name " + i;
            String schoolName = "school " + i;
            List<Grade> listGrade = new ArrayList<>();
            String city;
            if (i % 2 == 0) {
                city = address[0];
                if (i != 8) {
                    age = 18 + new Random().nextInt();
                } else {
                    int min = 1;
                    int max = 14;
                    age = new Random().nextInt(max - min + 1) + min;
                }
            } else {
                int index = new Random().nextInt(4 - 1 + 1) + 1;
                city = address[index];
                age = 18 + new Random().nextInt();
            }

            if (i == 0 || i == 3 || i == 5 || i == 8) {
                double score = 100 + i;
                Grade grade = new Grade("Big grade " + i, score);
                listGrade.add(grade);
            } else {
                double score = 60 + i;
                Grade grade = new Grade("Grade " + i, score);
                listGrade.add(grade);
            }
            double score = 40 + i;
            Grade grade = new Grade("Grade another " + i, score);
            listGrade.add(grade);

            score = 20 + i;
            grade = new Grade("Grade another another " + i, score);
            listGrade.add(grade);
            String street = "Address street " + i;

            Address addressObject = new Address(street, city);
            Student student = new Student(studentName, age, listGrade, schoolName, addressObject);
            students.add(student);
        }

        return students;
    }
}
