package org.service;

import org.entity.Floor;

import java.util.HashMap;
import java.util.Map;

public class SearchForSlot {

    private CreateFloor createFloor;
    private  String type;
    private int floorNo;
    public SearchForSlot(String type,CreateFloor createFloor){
        this.type = type;
        this.createFloor=createFloor;
    }
    public Map.Entry<Integer,Integer> getFloorAndSlot(){

        HashMap<Integer,Floor> capacity = createFloor.getCapacity();
        for (Map.Entry<Integer,Floor> entry : capacity.entrySet()) {
            HashMap<String,Integer> hmap = entry.getValue().getFreeSlots();
            for (Map.Entry<String,Integer> entry2 : hmap.entrySet()) {
                if(entry2.getKey().equals(type)){
                    if(entry2.getValue()<1){
                        continue;
                    }
                    createFloor.updateSlots(entry.getKey(), type,"sub");

                    return Map.entry(entry.getKey(),slotNo(entry.getKey()));
                }
            }
        }
        return null;
    }
    public int slotNo(int floorNo){
        int slotNo = createFloor.getSlotNoByType(floorNo,type);
        return slotNo;
    }
}
