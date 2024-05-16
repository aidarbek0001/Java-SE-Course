// Practice 1
// Inheritance, polymorphism


// Task 1
// Create a User class. Create 2 classes that inherit from the User class.
// In your Main class Main, you must create at least 5 objects of the Student, Staff and Users class each, and add them to the array from the Users class.
// To add courses to users, simply call the add Subject() & addCourse() method for each object!

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        User[] user = new User[5];
        user[0] = new User(1, "Bill1", "qwer1", "Bill", "Smiths");
        user[1] = new User(2, "Patrick2", "qwer2", "Patrick", "Smooths");
        user[2] = new User(3, "Johnathan3", "qwer3", "Johnathan", "Smiles");
        user[3] = new User(4, "Stephan4", "qwer4", "Stephan", "Smitt");
        user[4] = new User(5, "Donatello5", "qwer5", "Donatello", "Smut");

        Staff[] staff = new Staff[5];
        staff[0] = new Staff(user[0].id, user[0].login, user[0].password, user[0].name, user[0].surname, 250000);
        staff[1] = new Staff(user[1].id, user[1].login, user[1].password, user[1].name, user[1].surname, 220000);
        staff[2] = new Staff(user[2].id, user[2].login, user[2].password, user[2].name, user[2].surname, 230000);
        staff[3] = new Staff(user[3].id, user[3].login, user[3].password, user[3].name, user[3].surname, 240000);
        staff[4] = new Staff(user[4].id, user[4].login, user[4].password, user[4].name, user[4].surname, 260000);

        Student[] student = new Student[5];
        student[0] = new Student(user[0].id, user[0].login, user[0].password, user[0].name, user[0].surname, 3.1);
        student[1] = new Student(user[1].id, user[1].login, user[1].password, user[1].name, user[1].surname, 3.2);
        student[2] = new Student(user[2].id, user[2].login, user[2].password, user[2].name, user[2].surname, 3.3);
        student[3] = new Student(user[3].id, user[3].login, user[3].password, user[3].name, user[3].surname, 3.4);
        student[4] = new Student(user[4].id, user[4].login, user[4].password, user[4].name, user[4].surname, 3.5);

        staff[2].addSubject("Mathematics");
        staff[2].addSubject("Physics");
        staff[1].addSubject("History");
        student[4].addCourse("English");
        student[4].addCourse("Driving");
        student[1].addCourse("Driving");

//        staff[2].getSubjects();
//        staff[1].getSubjects();
//        student[4].getCourses();
//        student[1].getCourses();

        for(int i=0; i<staff.length; i++) {
            System.out.println(staff[i].getdata());
            staff[i].getSubjects();
        }
        for(int i=0; i<student.length; i++) {
            System.out.println(student[i].getdata());
            student[i].getCourses();
        }
    }
}



public class User {
    protected int id;
    protected String login;
    protected String password;
    protected String name;
    protected String surname;

    public User(){

    }
    public User(int id, String login, String password, String name, String surname){
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    String getdata(){
        return "ID: "+id+", Login: "+login+", Password: "+password+", Name: "+name+", Surname: "+surname;
    }
}



public class Staff extends User{
    private double salary;
    private String[] subjects = new String[100];
    private int indexOfSubject = 0;

    public Staff(){
    }
    public Staff(int id, String login, String password, String name, String surname,
                 double salary){
        super(id, login, password, name,surname);
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getIndexOfSubject() {
        return indexOfSubject;
    }
    public void setIndexOfSubject(int indexOfSubject) {
        this.indexOfSubject = indexOfSubject;
    }
    public void addSubject(String subject){
        subjects[indexOfSubject] = subject;
        indexOfSubject++;
    }
    public void getSubjects(){
//        System.out.println("-----------");
//        System.out.println(name+"'s subjects:");
        if(indexOfSubject > 0) {
            for (int i = 0; i < indexOfSubject; i++) {
                System.out.println(subjects[i]);
            }
        }
    }
    String getdata() {

        return "ID: " + id + ", Login: " + login + ", Password: " + password + ", Name: " + name + ", Surname: " + surname +
                ", Salary: " + salary + ", Subjects:";

    }
}



public class Student extends User{
    private double gpa;
    private String[] courses = new String[100];
    private int indexOfCourses = 0;
    public Student(){
    }
    public Student(int id, String login, String password, String name, String surname,
            double gpa){
        super(id, login, password, name,surname);
        this.gpa=gpa;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public int getIndexOfCourses() {
        return indexOfCourses;
    }
    public void setIndexOfCourses(int indexOfCourses) {
        this.indexOfCourses = indexOfCourses;
    }
    public void addCourse(String course){
        courses[indexOfCourses] = course;
        indexOfCourses++;
    }
    public void getCourses(){
//        System.out.println("-----------");
//        System.out.println(name+"'s courses:");
        if(indexOfCourses > 0) {
            for (int i = 0; i < indexOfCourses; i++) {
                System.out.println(courses[i]);
            }
        }
    }
    String getdata() {
        return "ID: " + id + ", Login: " + login + ", Password: " + password + ", Name: " + name + ", Surname: " + surname +
                ", GPA: " + gpa + ", Courses:";
    }
}





// Task 2
// Create a menu for the first assignment where you manage students, workers, and users.
// (Hint: The student or worker output filter needs to be implemented using the keyword: instanceof)

// PRESS [1] ADD USER
//     PRESS [1] TO ADD STUDENT    
//     PRESS [2] TO ADD STAFF
 
// PRESS [2] TO LIST USERS
//     PRESS [1] TO LIST STUDENTS
//     PRESS [2] TO LIST STAFF

// PRESS [0] TO EXIT

 




import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean process = true;
        int num;
        int num1;
        int num2;
        int k = 0;
        User[] user = new User[9999999];
        Student[] student = new Student[9999999];
        Staff[] staff = new Staff[9999999];
        do {
            System.out.println("\nPRESS [1] TO ADD USER \nPRESS [2] TO LIST USERS \nPRESS [0] TO EXIT");
            num = in.nextInt();
            if (num == 1) {
                System.out.println("\nPRESS [1] TO ADD STUDENT \nPRESS [2] TO ADD STAFF");
                num1 = in.nextInt();
                if (num1 == 1) {
                    System.out.println("Insert ID:");
                    int id = in.nextInt();
                    System.out.println("Insert Login:");
                    String login = in.next();
                    System.out.println("Insert Password:");
                    String password = in.next();
                    System.out.println("Insert name:");
                    String name = in.next();
                    System.out.println("Insert surname:");
                    String surname = in.next();
                    System.out.println("Insert GPA:");
                    double gpa = in.nextDouble();
                    user[k] = new Student(id, login, password, name, surname, gpa);
                    k++;
                } else if (num1 == 2) {
                    System.out.println("Insert ID:");
                    int id = in.nextInt();
                    System.out.println("Insert Login:");
                    String login = in.next();
                    System.out.println("Insert Password:");
                    String password = in.next();
                    System.out.println("Insert name:");
                    String name = in.next();
                    System.out.println("Insert surname:");
                    String surname = in.next();
                    System.out.println("Insert salary:");
                    int salary = in.nextInt();
                    user[k] = new Staff(id, login, password, name, surname, salary);
                    k++;
                }else {
                    System.out.println("Enter a valid number!");
                }
            } else if (num == 2) {
                System.out.println("\nPRESS [1] TO LIST STUDENTS \nPRESS [2] TO LIST STAFF");
                num2 = in.nextInt();
                if(num2 == 1) {
                    System.out.println("\nList of students:");
                    for (int i = 0; i < k; i++) {
                        if (user[i] instanceof Student){
                            System.out.println(user[i].getdata());
                        }
                    }
                } else if (num2 == 2) {
                    System.out.println("\nList of staff:");
                    for (int i = 0; i < k; i++) {
                        if (user[i] instanceof Staff){
                            System.out.println(user[i].getdata());
                        }
                    }
                }else {
                    System.out.println("Enter a valid number!");
                }
            } else if (num == 0) {
                System.out.println("Exiting..");
                process = false;
            } else {
                System.out.println("Enter a valid number!");
            }
        } while (process);
    }
}


