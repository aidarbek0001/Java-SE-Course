// Practice 1
// Reading and writing text files. Reading data


// Task 1
// Create a User class with parameters:
// - int id;
// - String login;
// - String password;
// Write the String toString() method, which converts all fields of the object
// In the Main class.java, create two methods:
// static ArrayList<User> getUsersList();
// static void saveUsersList(ArrayList<User> users);
// The getUsersList method returns a list of users that we download from a specific memory file.txt
// The save Users List method saves a dynamic array of users to our file memory.txt
// Using these methods, create a mini application with an interface:
//         PRESS [1] TO ADD USERS
//         PRESS [2] TO LIST USERS
//         PRESS [3] TO DELETE USERS
//         PRESS [4] TO EXIT




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("PRESS [1] TO ADD USER");
            System.out.println("PRESS [2] TO LIST USERS");
            System.out.println("PRESS [3] TO DELETE USER");
            System.out.println("PRESS [0] TO EXIT");
            String choice = in.next();
            switch (choice) {
                case "1": {
                    System.out.println("Insert ID:");
                    int id = in.nextInt();
                    System.out.println("Insert login:");
                    String login = in.next();
                    System.out.println("Insert password");
                    String password = in.next();
                    User1 us = new User1(id, login, password);
                    ArrayList<User1> users = getUsersList();
                    users.add(us);
                    saveUsersList(users);
                    break;
                }
                case "2": {
                    ArrayList<User1> users = getUsersList();
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println((i + 1) + ") " + users.get(i)); 
                    }
                    break;
                }
                case "3": {
                    ArrayList<User1> users = getUsersList();
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println((i + 1) + ") " + users.get(i));
                    }
                    System.out.println("Insert index of user to delete: ");
                    int index = in.nextInt();
                    users.remove(index - 1);
                    saveUsersList(users);
                    break;
                }
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Wrong command!!!");
                    break;
            }
        }
    }

    static ArrayList<User1> getUsersList(){
        ArrayList<User1> users = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("memory.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                int id = Integer.parseInt(line);
                String login = br.readLine();
                String password = br.readLine();
                users.add(new User1(id, login, password));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    static void saveUsersList(ArrayList<User1> users){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("memory.txt"));
            for (User1 us : users) {
                bw.write(us.getId()+"\n");
                bw.write(us.getLogin()+"\n");
                bw.write(us.getPassword()+"\n");
            }
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



public class User1 {
    int id;
    String login;
    String password;

    public User1(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
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

    public String toString(){
        return "ID: " + id + ", Login: " + login + ", Password: " + password;
    }
}
