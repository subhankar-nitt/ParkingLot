package org.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ticket {
    private  String parkingLotId;
    private int parkingFloor;
    private int  parkingSlotNo;

    public Ticket(String parkingLotId, int parkingFloor, int parkingSlotNo) {
        this.parkingLotId = parkingLotId;
        this.parkingFloor = parkingFloor;
        this.parkingSlotNo = parkingSlotNo;
    }

    @Override
    public String toString() {
        return parkingLotId+"_"+parkingFloor+"_"+parkingSlotNo;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(int parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public int getParkingSlotNo() {
        return parkingSlotNo;
    }

    public void setParkingSlotNo(int parkingSlotNo) {
        this.parkingSlotNo = parkingSlotNo;
    }
}
