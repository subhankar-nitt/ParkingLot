package org.service;

import lombok.Data;
import org.entity.Floor;

import java.util.HashMap;

@Data
public class CreateFloor {


    public HashMap<Integer, Floor> getCapacity() {
        return capacity;
    }

    public void setCapacity(HashMap<Integer, Floor> capacity) {
        this.capacity = capacity;
    }

    private int floorNo;
    private HashMap<Integer,Floor> capacity;
    private int slotNo;

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public CreateFloor(int floorNo, int slot) {
        this.capacity=new HashMap<>();
        this.floorNo=floorNo;
        this.slotNo=slot;
        for(int i=1;i<=floorNo;i++) {

            slot=slotNo;
            int truckSlot=0;
            int bikeSlot=0;
            int carSlot=0;
            if(slot>=1){
                truckSlot=1;
                slot=slot-1;
            }
            if(slot>=2){
                bikeSlot=2;
                slot=slot-2;
            }
            carSlot=slot;

            HashMap<String,Integer> freeSlots;
            freeSlots=new HashMap<>();
            freeSlots.put("CAR",carSlot);
            freeSlots.put("TRUCK",truckSlot);
            freeSlots.put("BIKE",bikeSlot);

            Floor floor = new Floor(i,truckSlot,bikeSlot,carSlot,new boolean[carSlot],new boolean[bikeSlot],truckSlot+carSlot+bikeSlot,freeSlots);
//            this.floor = floor;
            capacity.put(i,floor);
        }
    }

    public void updateSlots(int floorNo,String type,String operation){
        Floor floor = capacity.get(floorNo);
        HashMap<String,Integer> freeSlots = floor.getFreeSlots();

        if(operation.equals("add")){
            freeSlots.put(type,freeSlots.get(type)+1);
        }else{

            freeSlots.put(type,freeSlots.get(type)-1);
        }
    }
    public int getSlotNoByType(int floorNo,String type){
        Floor floor = capacity.get(floorNo);
        HashMap<String,Integer> freeSlots = floor.getFreeSlots();

        int numberOfFreeSlots = freeSlots.get(type);
        int totalSlots = floor.getTotalSlot();

        if (type.equals("TRUCK")){
            return 1;
        }else if (type.equals("BIKE")){
            boolean [] bikeArray =floor.getBikArray();
            for(int i=1;i<=2;i++){
                if(!bikeArray[i-1]){
                    bikeArray[i-1]=true;
                    return 1+i;
                }
            }
            return 0;
        }else{
            boolean[] carArray =floor.getCarArray();
            for(int i=1;i<=carArray.length;i++){
                if(!carArray[i-1]){
                    carArray[i-1]=true;
                    return 3+i;
                }
            }
            return 0;
        }
    }
    public void getNoOfFreeSlotsByType(String type){

        for(int i=1;i<=floorNo;i++) {

            Floor floor = capacity.get(i);
            HashMap<String,Integer> freeSlots = floor.getFreeSlots();
            int numberOfFreeSlots = freeSlots.get(type);
            System.out.println("Free Slots for  "+type+" on floor "+i+" "+numberOfFreeSlots);
        }
    }

    public void  getNumberOfOccupiedSlotsByType(String type){

        for(int i=1;i<=floorNo;i++) {

            Floor floor = capacity.get(i);
            HashMap<String,Integer> freeSlots = floor.getFreeSlots();
            int numberOfFreeSlots = freeSlots.get(type);
            int totalSlots = floor.getTotalSlot();
            if (type.equals("TRUCK")){
                System.out.println("Occupied Slots for  "+type+" on floor "+i+" "+(1-numberOfFreeSlots));
            }else if (type.equals("BIKE")){
                System.out.println("Occupied Slots for  "+type+" on floor "+i+" "+(2-numberOfFreeSlots));
            }else{
                System.out.println("Occupied Slots for  "+type+" on floor "+i+" "+(totalSlots-3-numberOfFreeSlots));
            }
        }
    }
    public void getOccupiedSlotsByType(String type){
        for(int i=1;i<=floorNo;i++) {
            Floor floor = capacity.get(i);
            HashMap<String,Integer> freeSlots = floor.getFreeSlots();

            int numberOfFreeSlots = freeSlots.get(type);
            if(type.equals("TRUCK")){
                System.out.println("Occupied Slots for  "+type+" on floor "+i+" are "+(1-numberOfFreeSlots));
            }else if (type.equals("BIKE")){
                System.out.print("Occupied Slots for "+type+" on floor "+i+" are ");
                boolean [] bikeArray =floor.getBikArray();
                for (int j=0;j<2;j++){
                    if(bikeArray[j]){
                        System.out.print((j+2)+" ");
                    }
                }
                System.out.println();
            }else{
                System.out.print("Occupied Slots for "+type+" on floor "+i+" are ");
                boolean [] carArray =floor.getCarArray();
                for (int j=0;j< carArray.length;j++){
                    if(carArray[j]){
                        System.out.print((j+4)+" ");
                    }
                }
                System.out.println();
            }

        }
    }
    public void removeSlots(int floorNo,int slotNo,String type){
        Floor floor = capacity.get(floorNo);
        HashMap<String,Integer> freeSlots = floor.getFreeSlots();
        updateSlots(floorNo,type,"add");
        if (type.equals("BIKE")){
            boolean [] bikeArray =floor.getBikArray();
            bikeArray[slotNo-2]=false;
        }else if (type.equals("CAR")){
            boolean [] carArray =floor.getCarArray();
            carArray[slotNo-4]=false;
        }
    }

    public void printFreeSlots(String type){
        for(int i=1;i<=floorNo;i++) {
            Floor floor = capacity.get(i);
            HashMap<String, Integer> freeSlots = floor.getFreeSlots();

            int numberOfFreeSlots = freeSlots.get(type);
            if (type.equals("TRUCK")) {
                System.out.println("Free Slots for  " + type + " on floor " + i + " are " + (numberOfFreeSlots));
            } else if (type.equals("BIKE")) {
                System.out.print("Free Slots for " + type + " on floor " + i + " are ");
                boolean[] bikeArray = floor.getBikArray();
                for (int j = 0; j < 2; j++) {
                    if (!bikeArray[j]) {
                        System.out.print((j + 2) + " ");
                    }
                }
                System.out.println();
            } else {
                System.out.print("Free Slots for " + type + " on floor " + i + " are ");
                boolean[] carArray = floor.getCarArray();
                for (int j = 0; j < carArray.length; j++) {
                    if (!carArray[j]) {
                        System.out.print((j + 4) + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
