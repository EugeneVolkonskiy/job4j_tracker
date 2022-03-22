package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Орлов Аркадий Иванович");
        student.setGroup("Job4j");
        student.setDate("15.07.2021");
        System.out.println(student.getName());
        System.out.println(student.getGroup());
        System.out.println(student.getDate());
    }
}
