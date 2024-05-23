// Practice 1
// Exception handling, try – catch


// Task 1
// In the Main.java I have an array of users, with a maximum size of 5 people. 
// My program asks the user to enter the data of these 5 users through the console. 
// Use a loop to repeat the operation of filling in user data and creating a new object 5 times. 
// You can use the For loop, it will be much easier this way.

// But if, during the introduction of the age, I enter incorrect data (not a whole number), 
// then the program should automatically enter the number 0 in the age field and add the object to the array. 
// Use try-catch to find out if the user entered the age correctly or screwed up.

// At the end of the input, the program should output the average age value in the array 
// and we will be able to see where the user entered the incorrect data.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        User[] users = new User[5];
        String name, surname;
        int sum = 0;
        int age;
        for (int i=0;i<users.length;i++){
            System.out.println("Insert name:");
            name = in.next();
            System.out.println("Insert surname:");
            surname = in.next();
            System.out.println("Insert age:");
            try{
                age = in.nextInt();
            }catch (Exception e){
                age = 0;
                in.nextLine();
            }
            users[i] = new User(name, surname, age);
        }
        for(int i=0;i<users.length;i++){
            sum += users[i].getAge();
            System.out.println(users[i].getdata());
        }
        int average = sum/users.length;
        System.out.println("\nAverage age: " + average);
    }
}


public class User {
    String name;
    String surname;
    int age;


    public User(){

    }
    public User(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String getdata(){
        return "Name: " + name + ", Surname: " + surname + ", Age: " + age;
    }
}


