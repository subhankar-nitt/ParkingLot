package org.service;

import org.entity.Floor;
import org.entity.Ticket;

import java.util.HashMap;
import java.util.Map;

public class CreateTicket {
    private HashMap<String, Ticket> tickets;
    private String parkingLotId;
    private String type;
    private  CreateFloor createFloor;

    public CreateTicket(String parkingLotId,String type,CreateFloor createFloor) {
        this.parkingLotId=parkingLotId;
        this.type=type;
        this.createFloor=createFloor;
        this.tickets=new HashMap<>();
    }
    public String publishTicket() throws Exception {
        SearchForSlot searchForSlot=new SearchForSlot(type,createFloor);
        Map.Entry<Integer, Integer> floorAndSlot=searchForSlot.getFloorAndSlot();

        if (floorAndSlot==null){
            return null;
        }
        int floor=floorAndSlot.getKey();
        int slot=floorAndSlot.getValue();

        Ticket ticket=new Ticket(parkingLotId,floor,slot);

        String ticketId = ticket.toString();

        this.tickets.put(ticketId,ticket);

        return ticketId;
    }
    public void removeTicket(String ticketId) {

//        String ticketId=this.tickets.
        String [] arr = ticketId.split("_");
        int floor = Integer.parseInt(arr[1]);
        int slot = Integer.parseInt(arr[2]);
        this.createFloor.removeSlots(floor,slot,type);
        this.tickets.remove(ticketId);

    }
}

