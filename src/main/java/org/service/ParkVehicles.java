package org.service;


import org.entity.Ticket;
import org.entity.Vehicles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ParkVehicles {
    private static final List<String> allowedTypes = Arrays.asList("CAR","BIKE","TRUCK");
    private HashMap<String, Vehicles> parkVehicles;
    private HashMap<String, CreateTicket> assignedTickets;
    private String regId;
    private String type;
    private String color;
    private CreateFloor createFloor;

    public ParkVehicles(String type,String regId,String color,CreateFloor createFloor) throws Exception {
        if(!allowedTypes.contains(type)){
            throw new Exception("We dont serve "+type+ "of cars");
        }
        this.regId = regId;
        this.type = type;
        this.color = color;
        this.parkVehicles = new HashMap<>();
        this.createFloor = createFloor;
        this.assignedTickets = new HashMap<>();
    }
    public String parkVehicle() throws Exception {
        CreateTicket createTicket = new CreateTicket("PR1234",type,createFloor);
        String ticketNo = createTicket.publishTicket();
        assignedTickets.put(ticketNo,createTicket);
        if(ticketNo==null){
            System.out.println("Parking Skots are full");
            return null;
        }
        Vehicles vehicle = new Vehicles(regId,type,color);
        parkVehicles.put(ticketNo,vehicle);
        System.out.println("Parked Vehicle "+ticketNo);
        return ticketNo;
    }
    public void removeVehicle(String ticketNo){
        Vehicles vehicle=parkVehicles.get(ticketNo);
        CreateTicket createTicket = assignedTickets.get(ticketNo);
        createTicket.removeTicket(ticketNo);
        System.out.println("REMOVED Vehicle "+vehicle.getVehicleNumber()+" of color "+vehicle.getVehicleColor());
        parkVehicles.remove(ticketNo);

    }

}
