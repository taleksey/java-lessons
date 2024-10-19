package com.learn.lesson3;

public class Service {
    @SuppressWarnings("checkstyle:OperatorWrap")
    public static String toString(StudentGradeRecord studentGradeRecord) {
        return "StudentGradeRecord{" +
                "studentName='" + studentGradeRecord.studentName() + '\'' +
                ", schoolName='" + studentGradeRecord.schoolName() + '\'' +
                ", subjectName='" + studentGradeRecord.subjectName() + '\'' +
                ", score=" + studentGradeRecord.score() +
                '}';
    }
}
