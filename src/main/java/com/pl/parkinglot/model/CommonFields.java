package com.pl.parkinglot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class CommonFields {

    @Column(name = "guid", unique =  true)
    private String guid;

    @Column(name = "isactive")
    private short isActive;

    @JsonIgnore
    @Column(name = "isdelete")
    private short isDelete;

    @Column(name = "createdby")
    private Integer createdBy;

    @Column(name = "modifiedby")
    private Integer modifiedBy;

    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "modifieddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

}
