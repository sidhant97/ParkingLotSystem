package com.pl.parkinglot.model;

import java.util.Date;
import java.util.List;

public class Bill extends CommonFields{
    
    private Integer id;
    
    private Token token;

    private Gate gate;

    private Operator operator;

    private List<Payment> payment;

    private Date date;
    
    private String status;

    private Integer totalAmount;

}
