package org.aleksey.lessonThird;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class Service {
    public static String toString(StudentGradeRecord studentGradeRecord) {
        return "StudentGradeRecord{"
            + "studentName='" + studentGradeRecord.studentName() + '\''
            + ", schoolName='" + studentGradeRecord.schoolName() + '\''
            + ", subjectName='" + studentGradeRecord.subjectName() + '\''
            + ", score=" + studentGradeRecord.score()
            + '}';
    }
}
