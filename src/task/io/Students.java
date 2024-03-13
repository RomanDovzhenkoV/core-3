package task.io;


import java.util.*;

public class Students {

    // TODO: Реализуйте класс, который представляет список студентов. Реализуйте метод для добавления
    //  студента в список. Обработайте исключение, если список уже содержит студента с таким же именем.

    public static void addStudent(List<Student> list, Student student) throws DuplicateName {
        if (list.isEmpty()) list.add(student);
        else {
            for (Student students : list) {
                if (students.getName().equals(student.getName())) {
                    throw new DuplicateName("Студент с таким именем уже есть в списке");
                }
            }
            list.add(student);
        }
    }

    public static void main(String[] args) throws DuplicateName {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student("Roman", "Dovzhenko", 3, 36, 7.5);
        Student student2 = new Student("Akim", "Parish", 5, 27, 8.7);
        Student student3 = new Student("Vadim", "Zharkov", 1, 25, 6.2);
        Student student4 = new Student("Vadim", "Zharkov", 1, 25, 6.2);
        addStudent(students, student1);
        addStudent(students, student2);
        addStudent(students, student3);

        try {
            addStudent(students, student4);
        } catch (DuplicateName exception) {
            System.out.println(exception);
        }
        System.out.println("____________________________________________________________________________");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
