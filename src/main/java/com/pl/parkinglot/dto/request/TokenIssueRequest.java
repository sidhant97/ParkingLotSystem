package com.pl.parkinglot.dto.request;

import com.pl.parkinglot.constant.SlotAllocation;
import lombok.Data;

@Data
public class TokenIssueRequest {

    private Integer parkingLotId;

    private String vehicleNumber;

    private String OwnerName;

    private String vehicleAllowed;

    private SlotAllocation slotAllocation;

}
