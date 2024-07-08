import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 2020);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            while (true) {
                System.out.println("[1] AIRCRAFTS");
                System.out.println("[2] CITIES");
                System.out.println("[3] FLIGHTS");
                int choice = in.nextInt();
                if (choice == 1) {
                    System.out.println("CHOOSE AN ACTION WITH AIRCRAFTS");
                    System.out.println("[1] ADD");
                    System.out.println("[2] LIST");
                    System.out.println("[3] UPDATE");
                    System.out.println("[4] DELETE");
                    int choice_1 = in.nextInt();
                    if (choice_1 == 1) {
                        System.out.println("ADDING AN AIRCRAFT..");
                        System.out.println("Insert name:");
                        String name = in.next();
                        System.out.println("Insert model:");
                        String model = in.next();
                        System.out.println("Insert business class capacity:");
                        Long bc_cap = in.nextLong();
                        System.out.println("Insert economy class capacity:");
                        Long ec_cap = in.nextLong();
                        Aircrafts a = new Aircrafts(null, name, model, bc_cap, ec_cap);
                        outputStream.writeObject(new AircraftPD("ADD_AIRCRAFT", null, a));
                    } else if (choice_1 == 2) {
                        System.out.println("LIST OF AIRCRAFTS:");
                        outputStream.writeObject(new AircraftPD("LIST_AIRCRAFTS", null, null));
                        ArrayList<Aircrafts> aircrafts = (ArrayList<Aircrafts>) inputStream.readObject();
                        for (Aircrafts a : aircrafts) {
                            System.out.println(a);
                        }
                    } else if (choice_1 == 3) {
                        System.out.println("UPDATING AN AIRCRAFT..");
                        System.out.println("Insert ID:");
                        Long id = in.nextLong();
                        System.out.println("Insert name:");
                        String name = in.next();
                        System.out.println("Insert model:");
                        String model = in.next();
                        System.out.println("Insert business class capacity:");
                        Long bc_cap = in.nextLong();
                        System.out.println("Insert economy class capacity:");
                        Long ec_cap = in.nextLong();
                        Aircrafts a = new Aircrafts(id, name, model, bc_cap, ec_cap);
                        outputStream.writeObject(new AircraftPD("UPDATE_AIRCRAFT", null, a));
                    } else if (choice_1 == 4) {
                        System.out.println("DELETING AN AIRCRAFT..");
                        System.out.println("Insert ID:");
                        Long id = in.nextLong();
                        Aircrafts a = new Aircrafts(id, null, null, null, null);
                        outputStream.writeObject(new AircraftPD("DELETE_AIRCRAFT", null, a));
                    }
                } else if (choice == 2) {
                    System.out.println("CHOOSE AN ACTION WITH CITIES");
                    System.out.println("[1] ADD");
                    System.out.println("[2] LIST");
                    System.out.println("[3] UPDATE");
                    System.out.println("[4] DELETE");
                    int choice_2 = in.nextInt();
                    if (choice_2 == 1) {
                        System.out.println("ADDING A CITY..");
                        System.out.println("Insert name:");
                        String name = in.next();
                        System.out.println("Insert country:");
                        String country = in.next();
                        System.out.println("Insert short name:");
                        String short_name = in.next();
                        Cities c = new Cities(null, name, country, short_name);
                        outputStream.writeObject(new CitiesPD("ADD_CITY", null, c));
                    } else if (choice_2 == 2) {
                        System.out.println("LIST OF CITIES:");
                        outputStream.writeObject(new CitiesPD("LIST_CITIES", null, null));
                        ArrayList<Cities> cities = (ArrayList<Cities>) inputStream.readObject();
                        for (Cities c : cities) {
                            System.out.println(c);
                        }
                    } else if (choice_2 == 3) {
                        System.out.println("UPDATING AN AIRCRAFT..");
                        System.out.println("Insert ID:");
                        Long id = in.nextLong();
                        System.out.println("Insert name:");
                        String name = in.next();
                        System.out.println("Insert country:");
                        String country = in.next();
                        System.out.println("Insert short name:");
                        String short_name = in.next();
                        Cities c = new Cities(id, name, country, short_name);
                        outputStream.writeObject(new CitiesPD("UPDATE_CITY", null, c));
                    } else if (choice_2 == 4) {
                        System.out.println("DELETING AN AIRCRAFT..");
                        System.out.println("Insert ID:");
                        Long id = in.nextLong();
                        Cities c = new Cities(id, null, null, null);
                        outputStream.writeObject(new CitiesPD("DELETE_CITY", null, c));
                    }
                } else if (choice == 3) {
                    System.out.println("CHOOSE AN ACTION WITH FLIGHTS");
                    System.out.println("[1] ADD");
                    System.out.println("[2] LIST");
                    System.out.println("[3] UPDATE");
                    System.out.println("[4] DELETE");
                    int choice_3 = in.nextInt();
                    if (choice_3 == 1) {
                        System.out.println("ADDING A FLIGHT..");
                        System.out.println("Insert aircraft ID:");
                        Long aircraft_id = in.nextLong();
                        System.out.println("Insert departure city ID:");
                        Long departure_city_id = in.nextLong();
                        System.out.println("Insert arrival city ID:");
                        Long arrival_city_id = in.nextLong();
                        System.out.println("Insert departure time:");
                        String departure_time = in.next();
                        System.out.println("Insert economy class price:");
                        Long ec_price = in.nextLong();
                        System.out.println("Insert business class price:");
                        Long bc_price = in.nextLong();
                        Flights f = new Flights(null, aircraft_id, departure_city_id, arrival_city_id, departure_time, ec_price, bc_price);
                        outputStream.writeObject(new FlightsPD("ADD_FLIGHT", null, f));
                    } else if (choice_3 == 2) {
                        System.out.println("LIST OF FLIGHTS:");
                        outputStream.writeObject(new FlightsPD("LIST_FLIGHTS", null, null));
                        ArrayList<Flights> flights = (ArrayList<Flights>) inputStream.readObject();
                        for (Flights f : flights) {
                            System.out.println(f);
                        }
                    } else if (choice_3 == 3) {
                        System.out.println("UPDATING A FLIGHT..");
                        System.out.println("Insert ID:");
                        Long id = in.nextLong();
                        System.out.println("Insert aircraft ID:");
                        Long aircraft_id = in.nextLong();
                        System.out.println("Insert departure city ID:");
                        Long departure_city_id = in.nextLong();
                        System.out.println("Insert arrival city ID:");
                        Long arrival_city_id = in.nextLong();
                        System.out.println("Insert departure time:");
                        String departure_time = in.next();
                        System.out.println("Insert economy class price:");
                        Long ec_price = in.nextLong();
                        System.out.println("Insert business class price:");
                        Long bc_price = in.nextLong();
                        Flights f = new Flights(id, aircraft_id, departure_city_id, arrival_city_id, departure_time, ec_price, bc_price);
                        outputStream.writeObject(new FlightsPD("UPDATE_FLIGHT", null, f));
                    } else if (choice_3 == 4) {
                        System.out.println("DELETING A FLIGHT..");
                        System.out.println("Insert ID:");
                        Long id = in.nextLong();
                        Flights f = new Flights(id, null, null, null, null, null, null);
                        outputStream.writeObject(new FlightsPD("DELETE_FLIGHT", null, f));
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
