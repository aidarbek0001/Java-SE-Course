// Practice 1
// Networks, using the Socket class.


// Task 1
// Create a mini application in which I send a message to the server.
// My message class:
//         MessageData.java
//         - String userName;
//         - String messageText;
//         - Date sentDate; // java.util.Date
//  Make two constructors :)
// It turns out that I have two applications: 1-server, 2-client 
// The server creates a ServerSocket at startup and starts waiting for the client. When the client connects, the server creates an output and input stream (ObjectOutputStream, ObjectInputStream), and accepts an object of the MessageData class that the client should send to us.
// The client starts requesting the user name at startup. Then it connects to the server and displays this menu:
// PRESS [1] TO SEND MESSAGE
//       Insert message text:
// PRESS [2] TO EXIT
// After entering the message, our client creates an object of the Message class by configuring the userName value with the user name, the value of the messageText with the message text and the sentDate with the current time. The current time can be obtained when creating a new java.util.Date object. It turns out that when creating a new object, we will get the current time by default. Date date = new Date();
// The toString() method of the Date class returns a text time value.
// After sending the message, we need to display the client's message data on the server.
//         For example:
//                “Hello” from Ilyas at 11.11.2017 15:34




import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1998);
            System.out.println("Waiting...");
            Socket socket = server.accept();
            System.out.println("Client connected.");
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            MessageData m = null;
                while ((m = (MessageData) inStream.readObject()) != null) {
                    m.getAll();
                }
            } catch (Exception e) {
                System.out.println("Client disconnected.");
        }
    }
}




import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert your name:");
        String name = in.next();
        try {
            Socket socket = new Socket("127.0.0.1", 1998);
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            while (true){
                System.out.println("PRESS [1] TO SEND MESSAGE" +
                        "\nPRESS [0] TO EXIT");
                String choise = in.next();
                if (choise.equals("1")){
                    System.out.println("Insert message:");
                    String message = in.next();
                    Date date = new Date();
                    MessageData m = new MessageData(name, message, date);
                    outStream.writeObject(m);
                } else if (choise.equals("0")) {
                    System.out.println("Exiting...");
                    socket.close();
                    break;
                } else {
                    System.out.println("Insert invalid number!");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

