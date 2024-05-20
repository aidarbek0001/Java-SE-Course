// Practice 1
// Interfaces


// Task 1
// Create a Users class. Create a UserBean interface. 
// Create the UserBeanImp class that implements the UserBean interface(UserBeanImp implements from UserBean).
// In the main class, create an array of at least 10 objects of the Users class. 
// Create an object of the UserBeanImp class. Using this class, output a list of all users, 
// and all users with the name "John", and output a list of people with the surname "Smith".

public class Main {
    public static void main(String[] args) {
        Users[] users = new Users[10];
        users[0] = new Users("Mike", "Potter");
        users[1] = new Users("John", "Doe");
        users[2] = new Users("John", "Taylor");
        users[3] = new Users("Jane", "Smith");
        users[4] = new Users("Alice", "Smith");
        users[5] = new Users("Bob", "Jones");
        users[6] = new Users("Mary", "Brown");
        users[7] = new Users("David", "White");
        users[8] = new Users("Michael", "Smith");
        users[9] = new Users("Chris", "Anderson");

        UserBean bean = new UserBeanImp(users);
        bean.getAllUsers();
        bean.getUsersByName("John");
        bean.getUsersBySurname("Smith");
    }
}


public class Users {
    String name;
    String surname;
    public Users(String name, String surname) {
        this.name = name;
        this.surname = surname;
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
    public String getAllData(){
        return name + " " + surname;
    }

}


public interface UserBean {
    void getAllUsers();
    void getUsersByName(String name);
    void getUsersBySurname(String surname);
}



import java.util.Objects;
public class UserBeanImp implements UserBean{
    Users[] users;
    public UserBeanImp(Users[] users) {
        this.users = users;
    }
    public void getAllUsers() {
        int n = 1;
        System.out.println("\nAll users:");
        for(int i=0;i<users.length;i++){
            System.out.println(n+") "+users[i].getAllData());
            n++;
        }
    }
    public void getUsersByName(String name) {
        int n = 1;
        System.out.println("\nUsers with name "+"'"+name+"':");
        for(int i=0;i<users.length;i++){
            if(Objects.equals(name, users[i].name)){
                System.out.println(n+") "+users[i].getAllData());
                n++;
            }
        }
    }
    public void getUsersBySurname(String surname) {
        int n = 1;
        System.out.println("\nUsers with surname "+"'"+surname+"':");
        for(int i=0;i<users.length;i++){
            if(Objects.equals(surname, users[i].surname)){
                System.out.println(n+") "+users[i].getAllData());
                n++;
            }
        }
    }
}


