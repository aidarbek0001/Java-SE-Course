import java.io.Serializable;
import java.util.ArrayList;

public class AircraftPD implements Serializable {
    String operation_type;
    ArrayList<Aircrafts> aircrafts;
    Aircrafts aircraft;

    public AircraftPD(){}

    public AircraftPD(String operation_type, ArrayList<Aircrafts> aircrafts, Aircrafts aircraft) {
        this.operation_type = operation_type;
        this.aircrafts = aircrafts == null ? null : (ArrayList<Aircrafts>) aircrafts.clone();
        this.aircraft = aircraft;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public ArrayList<Aircrafts> getAircrafts() {
        if (aircrafts == null){
            return new ArrayList<>();
        }
        return (ArrayList<Aircrafts>) aircrafts.clone();
    }

    public void setAircrafts(ArrayList<Aircrafts> aircrafts) {
        this.aircrafts = (ArrayList<Aircrafts>) aircrafts.clone();
    }

    public Aircrafts getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircrafts aircraft) {
        this.aircraft = aircraft;
    }

    @Override
    public String toString() {
        return "AircraftPD{" +
                "operation_type='" + operation_type + '\'' +
                ", aircrafts=" + aircrafts +
                ", aircraft=" + aircraft +
                '}';
    }
}
