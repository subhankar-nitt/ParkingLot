package org.service;

public class UnParkVehicle {
    private String ticketId;
    private ParkVehicles parkVehicles;

    public UnParkVehicle(String ticketId, ParkVehicles parkVehicles) {
        this.ticketId = ticketId;
        this.parkVehicles=parkVehicles;
    }

    public void removeCar(){
        parkVehicles.removeVehicle(ticketId);
    }

}
