package org.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
public class Floor {

    private int  floorNo;
    private  int truckSlot;
    private int  bikeSlot;

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getTruckSlot() {
        return truckSlot;
    }

    public void setTruckSlot(int truckSlot) {
        this.truckSlot = truckSlot;
    }

    public int getBikeSlot() {
        return bikeSlot;
    }

    public void setBikeSlot(int bikeSlot) {
        this.bikeSlot = bikeSlot;
    }

    public int getCarSlot() {
        return carSlot;
    }

    public void setCarSlot(int carSlot) {
        this.carSlot = carSlot;
    }

    public int getTotalSlot() {
        return totalSlot;
    }

    public void setTotalSlot(int totalSlot) {
        this.totalSlot = totalSlot;
    }

    private int  carSlot;

    public boolean[] getCarArray() {
        return carArray;
    }

    public void setCarArray(boolean[] carArray) {
        this.carArray = carArray;
    }

    public boolean[] getBikArray() {
        return bikArray;
    }

    public void setBikArray(boolean[] bikArray) {
        this.bikArray = bikArray;
    }

    private boolean [] carArray;

    public Floor(int floorNo, int truckSlot, int bikeSlot, int carSlot, boolean[] carArray, boolean[] bikArray, int totalSlot,HashMap<String,Integer> freeSlots) {
        this.floorNo = floorNo;
        this.truckSlot = truckSlot;
        this.bikeSlot = bikeSlot;
        this.carSlot = carSlot;
        this.carArray = carArray;
        this.bikArray = bikArray;
        this.totalSlot = totalSlot;
        this.freeSlots=freeSlots;

    }

    private boolean [] bikArray;

    private int totalSlot;
    public HashMap<String, Integer> getFreeSlots() {
        return freeSlots;
    }

    private HashMap<String,Integer> freeSlots;


    public void setFreeSlots(){
        this.freeSlots=new HashMap<>();
        this.freeSlots.put("CAR",carSlot);
        this.freeSlots.put("TRUCK",truckSlot);
        this.freeSlots.put("BIKE",bikeSlot);
    }
}
