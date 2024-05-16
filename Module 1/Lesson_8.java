// Practice 1
// Classes and objects


// Task 1
// In the Main class, you have to create 5 objects of different students with different parameters.
// Create an array from the Student class, fill the array with 5 objects of the Student class that we created before, 
// and using a loop, output data for each student.

public class Main {
    public static void main(String[] args) {
        Student [] students = new Student[5];
        students[0] = new Student(1, "Aidar", "Molzhigit", 3.1);
        students[1] = new Student(2, "Indira", "Kapsalyamova", 3.53);
        students[2] = new Student(3, "Aidos", "Maylau", 3.22);
        students[3] = new Student(4, "Alibi", "Sapanov", 3.71);
        students[4] = new Student(5, "Marlen", "Poluanov", 3.39);
        
        for(int i=0; i<students.length; i++){
            System.out.println(students[i].getStudentData());
        }
    }
}

public class Student {
    int id;
    String name;
    String surname;
    double gpa;
    public Student(){
        id=0;
        name="No name";
        surname="No surname";
        gpa=0.0;
    }
    public Student(int id, String name, String surname, double gpa){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.gpa=gpa;
    }
    String getStudentData(){
        return "ID: " +this.id+" Name: "+this.name+" Surname: "+this.surname+" GPA: "+this.gpa;
    }
}


// Task 2
// Use the previous Student class.
// Create a special top Student method in the Main class(Student students[]), which takes an array of students as arguments. 
// The method should output the data of the best student with a high GPA from the list. 
// Create 10 objects of different students with different parameters. Apply this method.

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[10];
        students[0] = new Student(1, "Aidar", "Molzhigit", 3.1);
        students[1] = new Student(2, "Indira", "Kapsalyamova", 3.53);
        students[2] = new Student(3, "Aidos", "Maylau", 3.22);
        students[3] = new Student(4, "Alibi", "Sapanov", 3.71);
        students[4] = new Student(5, "Marlen", "Poluanov", 3.39);
        students[5] = new Student(6, "Karina", "Turbekova", 3.33);
        students[6] = new Student(7, "Altay", "Aikeev", 3.42);
        students[7] = new Student(8, "Aidos", "Asan", 3.28);
        students[8] = new Student(9, "Ibragim", "Zholshibek", 3.65);
        students[9] = new Student(10, "Zhuldyz", "Bekbolatkyzy", 3.56);
        topStudent(students);
    }
    public static void topStudent(Student students[]){
            double max_gpa = 0;
            for (int i = 0; i < students.length; i++) {
                if (students[i].gpa > max_gpa) {
                    max_gpa = students[i].gpa;
                }
            }
            for (int i = 0; i < students.length; i++) {
                if (students[i].gpa == max_gpa) {
                    System.out.println("The top student is: "+students[i].name+" "+students[i].surname+
                            " with GPA: "+students[i].gpa);
            }
        }
    }
}
public class Student {
    int id;
    String name;
    String surname;
    double gpa;
    public Student(){
        id=0;
        name="No name";
        surname="No surname";
        gpa=0.0;
    }
    public Student(int id, String name, String surname, double gpa){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.gpa=gpa;
    }
    String getStudentData(){
        return "ID: " +this.id+" Name: "+this.name+" Surname: "+this.surname+" GPA: "+this.gpa;
    }
}


// Task 3
// Create a mini program with the menu bar displayed below.
// PRESS [1] TO ADD STUDENT
// PRESS [2] TO LIST STUDENT
// PRESS [0] TO EXIT

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean process = true;
        int num;
        int n = 0;
        Student[] students = new Student[9999999];
        do {
            System.out.println("\nPRESS [1] TO ADD STUDENT \nPRESS [2] TO LIST STUDENT \nPRESS [0] TO EXIT");
            num = in.nextInt();
            if (num == 1) {
                System.out.println("\nInsert name:");
                String name = in.next();
                System.out.println("Insert surname:");
                String surname = in.next();
                System.out.println("Insert GPA:");
                double gpa = in.nextDouble();
                students[n] = new Student(name, surname, gpa);
                n++;
            } else if (num == 2) {
                int m = 1;
                System.out.println("\nList of students with their GPA:");
                for (int i=0; i<n; i++) {
                    System.out.println(m + ") " + students[i].getStudentData());
                    m++;
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
public class Student {
    String name;
    String surname;
    double gpa;
    public Student(){
        name="No name";
        surname="No surname";
        gpa=0.0;
    }
    public Student(String name, String surname, double gpa){
        this.name=name;
        this.surname=surname;
        this.gpa=gpa;
    }
    String getStudentData(){
        return this.name+" "+this.surname+" "+this.gpa;
    }
}


// Task 4
// Create the Player and Club classes
// In the main class Main, create 2 arrays of different players. (Each of them has 5 players).
// Next, create two clubs and assign arrays of players to them. 
// Next, create an array of clubs, and add those 2 of our clubs there. 
// At the end, use a loop to output the data of each club.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player[] players1 = new Player[5];
        Player[] players2 = new Player[5];
        players1[0] = new Player(10, "Aidar", "Molzhigit", "Goalkeeper");
        players1[1] = new Player(33, "Aidos", "Maylau", "Defender");
        players1[2] = new Player(44, "Alibi", "Sapanov", "Midfielder");
        players1[3] = new Player(5, "Marlen", "Poluanov", "Midfielder");
        players1[4] = new Player(7, "Altay", "Aikeev", "Forward");
        players2[0] = new Player(81, "Aidos", "Asan", "Goalkeeper");
        players2[1] = new Player(91, "Ibragim", "Zholshibek", "Defender");
        players2[2] = new Player(13, "Nartay", "Kali", "Midfielder");
        players2[3] = new Player(17, "Meirzhan", "Mukatay", "Midfielder");
        players2[4] = new Player(9, "Kudaybergen", "Beksh", "Forward");
        Club club1 = new Club("Inter", "Italy", 8, players1);
        Club club2 = new Club("Liverpool", "England", 9, players2);

        Club[] clubs = new Club[2];
        clubs[0] = club1;
        clubs[1] = club2;

        for(int i=0; i<clubs.length; i++){
            clubs[i].printClubData();
        }
    }
}
public class Player {
    int number;
    String name;
    String surname;
    String position;

    public Player(){
        number = 0;
        name = "No name";
        surname = "No surname";
        position = "No position";
    }
    public Player(int number, String name, String surname, String position){
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.position = position;
    }
    public String toString(){
        return "Number: " + number + ", Name: " + name + ", Surname: " + surname + ", Position: " + position;
    }
}
public class Club {
    String name;
    String country;
    int ratingPoints;
    Player []players;
    public Club(){
        name = "No name";
        country = "No country";
        ratingPoints = 0;
    }
    public Club(String name, String country, int ratingPoints, Player []players){
        this.name = name;
        this.country = country;
        this.ratingPoints = ratingPoints;
        this.players = players;
    }
    public void printClubData(){
        System.out.println("Club name: " + name + ", Country:" + country + ", Rating points: " +
                ratingPoints + "\nPlayers:");
        for(int i=0; i<players.length; i++){
            System.out.println(players[i]);
        }
    }
}




