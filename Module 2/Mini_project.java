// Client-server application (MYSQL + JDBC)

// Our client application must connect to the server via a specific port and IP address. 
//  It turns out that our server will always be available to every client.
//  In order to connect multiple clients, use streams.
//  Our client, when adding a student, sends data to the server through the PackageData class. 
//  The server will check the data of the Package Data class if the operationType field is equal to "ADD_STUDENT" the server adds the student object to our database. 
//  When displaying the list of students, the client sends back an object of the Package Data class with the value of the field operation Type = "LIST_STUDENTS". 
//  The server then sends the list of students through the Package Data class object of the students list field;
//  Thus, you create a reliable multiclient application that works with a MYSQL database.




import java.io.Serializable;

public class Students implements Serializable {
    Long id;
    String name;
    String surname;
    int age;

    public Students(){
    }

    public Students(Long id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}


import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Students> students;
    Students student;

    public PackageData(){
    }

    public PackageData(String operationType, ArrayList<Students> students, Students student) {
        this.operationType = operationType;
        this.students = students == null ? null : (ArrayList<Students>) students.clone();
        this.student = student;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Students> getStudents() {
        if (students == null) {
            return new ArrayList<>();
        }
        return (ArrayList<Students>) students.clone();
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = (ArrayList<Students>) students.clone();
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", students=" + students +
                ", student=" + student +
                '}';
    }
}


import java.net.ServerSocket;
import java.net.Socket;

public class server{
    public static void main(String[] args) {

        try{
            ServerSocket server = new ServerSocket(2000);
            int id = 0;
            System.out.println("Server started.");
            while(true){
                Socket socket = server.accept();
                id++;
                System.out.println("User #"+id+" connected");
                ClientHandler ch = new ClientHandler(socket,id);
                ch.start();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 2000);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            while (true) {
                System.out.println("[1] ADD STUDENT");
                System.out.println("[2] LIST STUDENTS");
                System.out.println("[0] EXIT");
                int choice = in.nextInt();
                if(choice == 1){
                    System.out.println("Insert name:");
                    String name = in.next();
                    System.out.println("Insert surname:");
                    String surname = in.next();
                    System.out.println("Insert age:");
                    int age = in.nextInt();
                    Students s = new Students(null, name, surname, age);
                    outputStream.writeObject(new PackageData("ADD_STUDENT", null, s));
                } else if (choice == 2) {
                    outputStream.writeObject(new PackageData("LIST_STUDENTS", null, null));
                    ArrayList<Students> students = (ArrayList<Students>) inputStream.readObject();
                    for (Students s : students){
                        System.out.println(s);
                    }
                } else if (choice == 0) {
                    outputStream.writeObject(new PackageData("EXIT", null, null));
                    socket.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientHandler extends Thread{
    private Socket socket;
    private int id;

    public ClientHandler(Socket socket,int id) {
        this.socket = socket;
        this.id = id;
    }

    public void run(){
        try {
            connectToDB();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData data;
            while((data = (PackageData) inputStream.readObject())!=null){
                if (data.getOperationType().equals("ADD_STUDENT")){
                    addStudent(data.getStudent());
                } else if (data.getOperationType().equals("LIST_STUDENTS")) {
                    outputStream.writeObject(getAllStudents());
                } else if (data.getOperationType().equals("EXIT")){
                    disconnectFromDB();
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection conn;
    public static void connectToDB () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true$serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void disconnectFromDB(){
        try {
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addStudent(Students s){
        try {
            PreparedStatement st = conn.prepareStatement("insert into students(name, surname, age) values(?,?,?)");
            st.setString(1,s.getName());
            st.setString(2, s.getSurname());
            st.setInt(3, s.getAge());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Students> getAllStudents(){
        ArrayList<Students> students = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("select * from students");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                students.add(new Students(id, name, surname, age));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
}


