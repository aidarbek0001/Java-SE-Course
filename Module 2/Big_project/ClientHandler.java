import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    private Socket socket;
    private int id;

    public ClientHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    public void run() {
        try {
            connectToDB();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                Object obj = inputStream.readObject();
                if (obj instanceof AircraftPD) {
                    AircraftPD data = (AircraftPD) obj;
                    if (data.getOperation_type().equals("ADD_AIRCRAFT")) {
                        addAircraft(data.getAircraft());
                    } else if (data.getOperation_type().equals("LIST_AIRCRAFTS")) {
                        outputStream.writeObject(getAllAircrafts());
                    } else if (data.getOperation_type().equals("UPDATE_AIRCRAFT")) {
                        updateAircraft(data.getAircraft());
                    } else if (data.getOperation_type().equals("DELETE_AIRCRAFT")) {
                        deleteAircraft(data.getAircraft());
                        break;
                    }
                } else if (obj instanceof CitiesPD) {
                    CitiesPD data = (CitiesPD) obj;
                    if (data.getOperation_type().equals("ADD_CITY")) {
                        addCity(data.getCity());
                    } else if (data.getOperation_type().equals("LIST_CITIES")) {
                        outputStream.writeObject(getAllCities());
                    } else if (data.getOperation_type().equals("UPDATE_CITY")) {
                        updateCity(data.getCity());
                    } else if (data.getOperation_type().equals("DELETE_CITY")) {
                        deleteCity(data.getCity());
                        break;
                    }
                } else if (obj instanceof FlightsPD) {
                    FlightsPD data = (FlightsPD) obj;
                    if (data.getOperation_type().equals("ADD_FLIGHT")) {
                        addFlight(data.getFlight());
                    } else if (data.getOperation_type().equals("LIST_FLIGHTS")) {
                        outputStream.writeObject(getAllFlights());
                    } else if (data.getOperation_type().equals("UPDATE_FLIGHT")) {
                        updateFlight(data.getFlight());
                    } else if (data.getOperation_type().equals("DELETE_FLIGHT")) {
                        deleteFlight(data.getFlight());
                    }
                } else if (obj instanceof TicketsPD) {
                    TicketsPD data = (TicketsPD) obj;
                    if (data.getOperation_type().equals("ADD_TICKET")) {
                        addTicket(data.getTicket());
                    } else if (data.getOperation_type().equals("LIST_TICKETS")) {
                        outputStream.writeObject(getAllTickets());
                    } else if (data.getOperation_type().equals("UPDATE_TICKET")) {
                        updateTicket(data.getTicket());
                    } else if (data.getOperation_type().equals("DELETE_TICKET")) {
                        deleteTicket(data.getTicket());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection conn;
    public static void connectToDB () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_big_project?useUnicode=true$serverTimezone=UTC", "root", "");
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

    public static void addAircraft(Aircrafts a){
        try {
            PreparedStatement st = conn.prepareStatement("insert into aircrafts(name, model, business_class_capacity, econom_class_capacity) values(?,?,?,?)");
            st.setString(1, a.getName());
            st.setString(2, a.getModel());
            st.setLong(3, a.getBusiness_class_capacity());
            st.setLong(4, a.getEconom_class_capacity());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addCity(Cities c){
        try {
            PreparedStatement st = conn.prepareStatement("insert into cities(name, country, short_name) values(?,?,?)");
            st.setString(1, c.getName());
            st.setString(2, c.getCountry());
            st.setString(3, c.getShort_name());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addFlight(Flights f){
        try {
            PreparedStatement st = conn.prepareStatement("insert into flights(aircraft_id, departure_city_id, arrival_city_id, departure_time, econom_place_price, business_place_price) values(?,?,?,?,?,?)");
            st.setLong(1, f.getAircraft_id());
            st.setLong(2, f.getDeparture_city_id());
            st.setLong(3, f.getArrival_city_id());
            st.setString(4, f.getDeparture_time());
            st.setLong(5, f.getEconom_place_price());
            st.setLong(6, f.getBusiness_place_price());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addTicket(Tickets t){
        try {
            PreparedStatement st = conn.prepareStatement("insert into tickets(flight_id, name, surname, passport_number, ticket_type) values(?,?,?,?,?)");
            st.setLong(1, t.getFlight_id());
            st.setString(2, t.getName());
            st.setString(3, t.getSurname());
            st.setString(4, t.getPassport_number());
            st.setString(5, t.getTicket_type());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Aircrafts> getAllAircrafts(){
        ArrayList<Aircrafts> aircrafts = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("select * from aircrafts");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                Long business_class_capacity = rs.getLong("business_class_capacity");
                Long econom_class_capacity = rs.getLong("econom_class_capacity");
                aircrafts.add(new Aircrafts(id, name, model, business_class_capacity, econom_class_capacity));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (aircrafts == null){
            return new ArrayList<>();
        }
        return aircrafts;
    }

    public static ArrayList<Cities> getAllCities(){
        ArrayList<Cities> cities = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("select * from cities");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String short_name = rs.getString("short_name");
                cities.add(new Cities(id, name, country, short_name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (cities == null){
            return new ArrayList<>();
        }
        return cities;
    }

    public static ArrayList<Flights> getAllFlights(){
        ArrayList<Flights> flights = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("select * from flights");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                Long aircraft_id = rs.getLong("aircraft_id");
                Long departure_city_id = rs.getLong("departure_city_id");
                Long arrival_city_id = rs.getLong("arrival_city_id");
                String departure_time = rs.getString("departure_time");
                Long econom_place_price = rs.getLong("econom_place_price");
                Long business_place_price = rs.getLong("business_place_price");
                flights.add(new Flights(id, aircraft_id, departure_city_id, arrival_city_id, departure_time, econom_place_price, business_place_price));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (flights == null){
            return new ArrayList<>();
        }
        return flights;
    }

    public static ArrayList<Tickets> getAllTickets(){
        ArrayList<Tickets> tickets = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("select * from tickets");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                Long flight_id = rs.getLong("flight_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String passport_number = rs.getString("passport_number");
                String ticket_type = rs.getString("ticket_type");
                tickets.add(new Tickets(id, flight_id, name, surname, passport_number, ticket_type));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (tickets == null){
            return new ArrayList<>();
        }
        return tickets;
    }

    public static void updateAircraft(Aircrafts a){
        try {
            PreparedStatement st = conn.prepareStatement("update aircrafts set name=?, model=?, business_class_capacity=?, econom_class_capacity=? where id=?");
            st.setString(1, a.getName());
            st.setString(2, a.getModel());
            st.setLong(3, a.getBusiness_class_capacity());
            st.setLong(4, a.getEconom_class_capacity());
            st.setLong(5, a.getId());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateCity(Cities c){
        try {
            PreparedStatement st = conn.prepareStatement("update cities set name=?, country=?, short_name=? where id=?");
            st.setString(1, c.getName());
            st.setString(2, c.getCountry());
            st.setString(3, c.getShort_name());
            st.setLong(4, c.getId());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateFlight(Flights f){
        try {
            PreparedStatement st = conn.prepareStatement("update flights set aircraft_id=?, departure_city_id=?, arrival_city_id=?, departure_time=?, econom_place_price=?, business_place_price=? where id=?");
            st.setLong(1, f.getAircraft_id());
            st.setLong(2, f.getDeparture_city_id());
            st.setLong(3, f.getArrival_city_id());
            st.setString(4, f.getDeparture_time());
            st.setLong(5, f.getEconom_place_price());
            st.setLong(6, f.getBusiness_place_price());
            st.setLong(7, f.getId());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateTicket(Tickets t){
        try {
            PreparedStatement st = conn.prepareStatement("update tickets ser flight_id=?, name=?, surname=?, passport_number=?, ticket_type=? where id=?");
            st.setLong(1, t.getFlight_id());
            st.setString(2, t.getName());
            st.setString(3, t.getSurname());
            st.setString(4, t.getPassport_number());
            st.setString(5, t.getTicket_type());
            st.setLong(6, t.getId());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void deleteAircraft(Aircrafts a){
        try {
            PreparedStatement st = conn.prepareStatement("delete from aircrafts where id=?");
            st.setLong(1, a.getId());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteCity(Cities c){
        try {
            PreparedStatement st = conn.prepareStatement("delete from cities where id=?");
            st.setLong(1, c.getId());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteFlight(Flights f){
        try {
            PreparedStatement st = conn.prepareStatement("delete from flights where id=?");
            st.setLong(1, f.getId());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteTicket(Tickets t){
        try {
            PreparedStatement st = conn.prepareStatement("delete from tickets where id=?");
            st.setLong(1, t.getId());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
