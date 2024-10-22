package com.bchupika.lesson3;

public record StudentGradeRecord(String studentName, String schoolName, String subjectName, double score) {

    @SuppressWarnings("checkstyle:OperatorWrap")
    @Override
    public String toString() {
        return "StudentGradeRecord{" +
                "studentName='" + studentName + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", score=" + score +
                '}';
    }
}
