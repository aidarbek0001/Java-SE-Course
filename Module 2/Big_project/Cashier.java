import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 2020);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            while (true) {
                System.out.println("[1] ADD TICKET");
                System.out.println("[2] LIST TICKETS");
                System.out.println("[3] CHANGE TICKET");
                System.out.println("[4] DELETE TICKET");
                System.out.println("[0] EXIT");
                int choice = in.nextInt();
                if (choice == 1) {
                    System.out.println("ADDING A TICKET..");
                    System.out.println("Insert flight ID:");
                    Long flight_id = in.nextLong();
                    System.out.println("Insert firstname:");
                    String name = in.next();
                    System.out.println("Insert surname:");
                    String surname = in.next();
                    System.out.println("Insert passport number:");
                    String passport_number = in.next();
                    System.out.println("Choose ticket type:");
                    System.out.println("[1] Economy class");
                    System.out.println("[2] Business class");
                    int choice_ticket = in.nextInt();
                    String ticket_type = "";
                    if (choice_ticket == 1) {
                        ticket_type = "ec";
                    } else if (choice_ticket == 2) {
                        ticket_type = "bc";
                    }
                    Tickets t = new Tickets(null, flight_id, name, surname, passport_number, ticket_type);
                    outputStream.writeObject(new TicketsPD("ADD_TICKET", null, t));
                } else if (choice == 2) {
                    System.out.println("LIST OF TICKETS");
                    outputStream.writeObject(new TicketsPD("LIST_TICKETS", null, null));
                    ArrayList<Tickets> tickets = (ArrayList<Tickets>) inputStream.readObject();
                    for (Tickets t : tickets) {
                        System.out.println(t);
                    }
                } else if (choice == 3) {
                    System.out.println("UPDATING A TICKET..");
                    System.out.println("Insert ticket ID:");
                    Long id = in.nextLong();
                    System.out.println("Insert flight ID:");
                    Long flight_id = in.nextLong();
                    System.out.println("Insert firstname:");
                    String name = in.next();
                    System.out.println("Insert surname:");
                    String surname = in.next();
                    System.out.println("Insert passport number:");
                    String passport_number = in.next();
                    System.out.println("Choose ticket type:");
                    System.out.println("[1] Economy class");
                    System.out.println("[2] Business class");
                    int choice_ticket = in.nextInt();
                    String ticket_type = "";
                    if (choice_ticket == 1) {
                        ticket_type = "ec";
                    } else if (choice_ticket == 2) {
                        ticket_type = "bc";
                    }
                    Tickets t = new Tickets(id, flight_id, name, surname, passport_number, ticket_type);
                    outputStream.writeObject(new TicketsPD("CHANGE_TICKET", null, t));
                } else if (choice == 4) {
                    System.out.println("DELETING A TICKET..");
                    System.out.println("Insert ID:");
                    int id = in.nextInt();
                    outputStream.writeObject(id);
                } else if (choice == 0) {
                    System.out.println("EXITING");
                    outputStream.writeObject(new TicketsPD("EXIT", null, null));
                    socket.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}