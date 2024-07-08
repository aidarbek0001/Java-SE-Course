// Practice 1
// Serialization, deserialization. Saving files.


// Task 1
// Create a serializable Subject class:
// - String name;
// - int credits;
// Getters and setters
// Redefine the String toString() method where we output all the fields of the object
// Create a serializable Student class:
// - String name;
// - String surname;
// - ArrayList<Subject> subjects = new ArrayList<Subject>();
// Getters and setters
// In the main class, create a menu.
// The state of the shared ArrayList<Student> array should be saved to the serialized memory.dat file and loaded from there when accessing the list.




import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        loadStudents();
        while (true) {
            System.out.println("PRESS [1] TO ADD STUDENT");
            System.out.println("PRESS [2] TO LIST STUDENTS");
            System.out.println("PRESS [0] TO EXIT");
            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    listStudents();
                    break;
                case 0:
                    saveStudents();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong command!!!");
            }
        }
    }

    public static void addStudent() {
        Scanner in = new Scanner(System.in);
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Surname: ");
        String surname = in.nextLine();
        Student student = new Student(name, surname);
        boolean procces = true;
        while (procces) {
            System.out.println("PRESS [1] TO ADD SUBJECT");
            System.out.println("PRESS [0] TO GO TO MAIN MENU");
            int choice = in.nextInt();
            in.nextLine();
            if (choice == 1) {
                System.out.print("Name: ");
                String subName = in.nextLine();
                System.out.print("Credits: ");
                int credits = in.nextInt();
                in.nextLine();
                Subject subject = new Subject(subName, credits);
                student.addSubject(subject);
            } else if (choice == 0) {
                students.add(student);
                saveStudents();
                procces = false;
            }
        }
    }

    public static void listStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void saveStudents() {
        try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("memory.dat"))) {
            outStream.writeObject(students);
        } catch (Exception ignored) {
        }
    }

    public static void loadStudents() {
        File file = new File("memory.dat");
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                students = (ArrayList<Student>)inputStream.readObject();
            } catch (Exception ignored) {
            }
        }
    }
}



import java.io.Serializable;

public class Subject implements Serializable {
    String name;
    int credits;

    public Subject(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String toString() {
        return "Subject name=" + name + ", credits=" + credits;
    }
}



import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    String name;
    String surname;
    ArrayList<Subject> subjects;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public String toString() {
        return "name= " + name + ", surname= " + surname + ", subjects= " + subjects;
    }
}

