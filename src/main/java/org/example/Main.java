package org.example;

import org.service.CreateFloor;
import org.service.ParkVehicles;
import org.service.UnParkVehicle;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {

        HashMap<String,ParkVehicles> parkVehicles = new HashMap<>();

        CreateFloor createFloor = new CreateFloor(2,6);
        createFloor.getNoOfFreeSlotsByType("CAR");
        createFloor.getNoOfFreeSlotsByType("BIKE");
        createFloor.getNoOfFreeSlotsByType("TRUCK");

        createFloor.getOccupiedSlotsByType("CAR");

        ParkVehicles parkVehicles1 = new ParkVehicles("CAR","KA-01-DB-1234","BLACK",createFloor);
        String key =parkVehicles1.parkVehicle();
        if(key!=null)
           parkVehicles.put(key,parkVehicles1);

        ParkVehicles parkVehicles2 = new ParkVehicles("CAR","KA-02-CB-1334","RED",createFloor);

        key=parkVehicles2.parkVehicle();
        if(key!=null)
            parkVehicles.put(key,parkVehicles2);

        ParkVehicles parkVehicles3 = new ParkVehicles("CAR","KA-01-DB-1133","BLACK",createFloor);
        key = parkVehicles3.parkVehicle();
        if(key!=null)
                parkVehicles.put(key,parkVehicles3);

        createFloor.getOccupiedSlotsByType("CAR");

        ParkVehicles parkVehicles4 = new ParkVehicles("CAR","KA-05-HJ-8432","WHITE",createFloor);
        key=parkVehicles4.parkVehicle();
        if(key!=null)
            parkVehicles.put(key,parkVehicles4);

        ParkVehicles parkVehicles5 = new ParkVehicles("CAR","WB-45-HO-9032","WHITE",createFloor);

        key=parkVehicles5.parkVehicle();
        if(key!=null)
            parkVehicles.put(key,parkVehicles5);
        ParkVehicles parkVehicles6 = new ParkVehicles("CAR","KA-01-DF-8230","BLACK",createFloor);
        key=parkVehicles6.parkVehicle();
        if (key!=null)
            parkVehicles.put(key,parkVehicles6);
        ParkVehicles parkVehicles7 = new ParkVehicles("CAR","KA-21-HS-2347","RED",createFloor);
        key=parkVehicles7.parkVehicle();
        if(key!=null)
            parkVehicles.put(key,parkVehicles7);

        createFloor.getOccupiedSlotsByType("CAR");

        createFloor.getNoOfFreeSlotsByType("CAR");


        if(!parkVehicles.containsKey("PR1234_2_5")){
            System.out.println("No park vehicle found");
        }else{
            ParkVehicles parkedVehicles = parkVehicles.get("PR1234_2_5");
            parkedVehicles.removeVehicle("PR1234_2_5");
        }
        createFloor.getNoOfFreeSlotsByType("CAR");
        createFloor.getNoOfFreeSlotsByType("BIKE");
        createFloor.getNoOfFreeSlotsByType("TRUCK");

        createFloor.getOccupiedSlotsByType("CAR");

        createFloor.getNoOfFreeSlotsByType("CAR");

        createFloor.getOccupiedSlotsByType("BIKE");
        createFloor.getNoOfFreeSlotsByType("TRUCK");

        ParkVehicles parkVehicles8= new ParkVehicles("BIKE","KA-01-DB-1541","BLACK",createFloor);
        key=parkVehicles8.parkVehicle();
        if(key!=null){
            parkVehicles.put(key,parkVehicles8);
        }
        ParkVehicles parkVehicles9 = new ParkVehicles("TRUCK","KA-32-SJ-5389","ORANGE",createFloor);
        key=parkVehicles9.parkVehicle();
        if(key!=null){
            parkVehicles.put(key,parkVehicles9);
        }
        ParkVehicles parkVehicles10 = new ParkVehicles("TRUCK","KL-54-DN-4582","GREEN",createFloor);
        key=parkVehicles10.parkVehicle();
        if(key!=null){
            parkVehicles.put(key,parkVehicles10);
        }

        ParkVehicles parkVehicles11 = new ParkVehicles("TRUCK","KL-12-HF-4542","GREEN",createFloor);
        key=parkVehicles11.parkVehicle();
        if(key!=null){
            parkVehicles.put(key,parkVehicles11);
        }

        createFloor.getNoOfFreeSlotsByType("CAR");
        createFloor.getNoOfFreeSlotsByType("BIKE");
        createFloor.getNoOfFreeSlotsByType("TRUCK");

        createFloor.getOccupiedSlotsByType("CAR");

        createFloor.getNoOfFreeSlotsByType("CAR");

        createFloor.getNoOfFreeSlotsByType("BIKE");

        createFloor.getNoOfFreeSlotsByType("TRUCK");

        createFloor.printFreeSlots("CAR");
        createFloor.printFreeSlots("BIKE");
        createFloor.printFreeSlots("TRUCK");



//        park_vehicle CAR KA-01-DB-1234 black
//        park_vehicle CAR KA-02-CB-1334 red
//        park_vehicle CAR KA-01-DB-1133 black
//        park_vehicle CAR KA-05-HJ-8432 white
//        park_vehicle CAR WB-45-HO-9032 white
//        park_vehicle CAR KA-01-DF-8230 black
//        park_vehicle CAR KA-21-HS-2347 red
    }
}