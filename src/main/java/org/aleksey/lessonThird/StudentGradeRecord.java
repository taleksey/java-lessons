package org.aleksey.lessonThird;

public record StudentGradeRecord(String studentName, String schoolName, String subjectName, double score) {
    @Override
    public String toString() {
        return "StudentGradeRecord{"
            + "studentName='" + studentName + '\''
            + ", schoolName='" + schoolName + '\''
            + ", subjectName='" + subjectName + '\''
            + ", score=" + score
            + '}';
    }
}
