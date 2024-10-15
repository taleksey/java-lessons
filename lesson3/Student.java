package lesson3;

import java.util.List;

public record Student(String name, int age, List<Grade> listGradle, String school, Address address) {

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
