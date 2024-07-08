// Practice 1
// Networks + Streams. The concept of a secure server and client.


// Task 1
// Create a mini client-server application where your client will download the data of the Book class list from the server.
// Create a special Package Data class that will act as a data transfer package over the network.
// It turns out that on the server side we have a list of books that we store in a specialized file.
// Our client connects to the server and makes a request for a list of books, and the server sends the list to the client via a special PackageData class.
// The client panel looks like this:
// PRESS 1 TO LIST BOOKS
// PRESS 2 TO ADD BOOKS
// PRESS 0 TO DISCONNECT FROM SERVER
// Make it so that multiple clients can connect to the server at the same time. (Use streams).




import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) {

        try{
            ServerSocket server = new ServerSocket(1998);
            int id = 0;
            System.out.println("Waiting...");
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
        System.out.println("Insert your name");
        String name = in.next();
        try{
            Socket socket = new Socket("127.0.0.1",1998);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            while(true){
                System.out.println("PRESS 1 TO LIST BOOKS" +
                        "\nPRESS 2 TO ADD BOOKS" +
                        "\nPRESS 0 TO DISCONNECT FROM SERVER");
                String choice = in.next();
                if (choice.equals("1")){
                    outputStream.writeObject(new PackageData("1", null, null));
                    outputStream.flush();
                    PackageData response = (PackageData) inputStream.readObject();
                    ArrayList<Book> books = response.getBooks();
                    for (Book book : books) {
                        System.out.println(book);
                    }
                } else if (choice.equals("2")) {
                    System.out.println("Insert book ID:");
                    int id = in.nextInt();
                    System.out.println("Insert book name:");
                    String bookname = in.next();
                    System.out.println("Insert book author:");
                    String author = in.next();

                    Book book = new Book(id, bookname, author);
                    outputStream.writeObject(new PackageData("2", null, book));
                } else if (choice.equals("0")) {
                    outputStream.writeObject(new PackageData("0", null, null));
                    socket.close();
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


import java.io.Serializable;

public class Book implements Serializable {
    int id;
    String name;
    String author;

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return "Book{" + "id=" + id + ", name='" + name + '\'' + ", author='" + author + '\'' + '}';
    }

}


import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
   String operationType;
   ArrayList<Book> books;
   Book book;

   public String getOperationType() {
      return operationType;
   }

   public void setOperationType(String operationType) {
      this.operationType = operationType;
   }

   public ArrayList<Book> getBooks() {
      if (books == null) {
         return new ArrayList<>();
      }
      return (ArrayList<Book>) books.clone();
   }

   public void setBooks(ArrayList<Book> books) {
      this.books = (ArrayList<Book>) books.clone();
   }

   public Book getBook() {
      return book;
   }

   public void setBook(Book book) {
      this.book = book;
   }

   public PackageData(String operationType, ArrayList<Book> books, Book book) {
      this.operationType = operationType;
      this.book = book;
      this.books = books == null ? null : (ArrayList<Book>) books.clone();
   }
}


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread{
    private Socket socket;
    private int id;
    private static ArrayList<Book> books = new ArrayList<>();

    public ClientHandler(Socket socket,int id) {
        this.socket = socket;
        this.id = id;
    }

    public void run(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData data;
            while((data = (PackageData) inputStream.readObject())!=null){
                switch (data.getOperationType()) {
                    case "1":
                        synchronized (books) {
                            outputStream.writeObject(new PackageData("1", new ArrayList<>(books), null));
                        }
                        break;
                    case "2":
                        synchronized (books) {
                            books.add(data.getBook());
                            outputStream.writeObject(new PackageData("2", null, data.getBook()));
                            outputStream.flush();
                        }
                        break;
                    case "0":
                        System.out.println("disconnecting...");
                        socket.close();
                        return;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}






