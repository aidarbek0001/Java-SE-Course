import sun.util.resources.cldr.kea.TimeZoneNames_kea;

import java.io.Serializable;
import java.util.ArrayList;

public class TicketsPD implements Serializable {
    String operation_type;
    ArrayList<Tickets> tickets;
    Tickets ticket;

    public TicketsPD(){}

    public TicketsPD(String operation_type, ArrayList<Tickets> tickets, Tickets ticket) {
        this.operation_type = operation_type;
        this.tickets = tickets == null ? null : (ArrayList<Tickets>) tickets.clone();
        this.ticket = ticket;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public ArrayList<Tickets> getTickets() {
        if (tickets == null){
            return new ArrayList<>();
        }
        return (ArrayList<Tickets>) tickets.clone();
    }

    public void setTickets(ArrayList<Tickets> tickets) {
        this.tickets = tickets;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "TicketsPD{" +
                "operation_type='" + operation_type + '\'' +
                ", tickets=" + tickets +
                ", ticket=" + ticket +
                '}';
    }
}
