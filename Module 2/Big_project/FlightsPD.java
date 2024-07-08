import java.io.Serializable;
import java.util.ArrayList;

public class FlightsPD implements Serializable {
    String operation_type;
    ArrayList<Flights> flights;
    Flights flight;

    public FlightsPD(){}

    public FlightsPD(String operation_type, ArrayList<Flights> flights, Flights flight) {
        this.operation_type = operation_type;
        this.flights = flights == null ? null : (ArrayList<Flights>) flights.clone();
        this.flight = flight;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public ArrayList<Flights> getFlights() {
        if (flights == null){
            return new ArrayList<>();
        }
        return (ArrayList<Flights>) flights.clone();
    }

    public void setFlights(ArrayList<Flights> flights) {
        this.flights = (ArrayList<Flights>) flights.clone();
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "FlightsPD{" +
                "operation_type='" + operation_type + '\'' +
                ", flights=" + flights +
                ", flight=" + flight +
                '}';
    }
}
