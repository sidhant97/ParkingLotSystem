package com.pl.parkinglot.model;

import java.util.Date;
import java.util.List;

public class BillModel {
    
    private Integer id;
    
    private TokenModel tokenModel;

    private GateModel gate;

    private OperatorModel operator;

    private List<PaymentModel> paymentModel;

    private Date date;
    
    private String status;

    private Integer totalAmount;

}
