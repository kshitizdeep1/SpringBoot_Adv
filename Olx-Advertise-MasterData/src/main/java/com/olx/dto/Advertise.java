package com.olx.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Advertise {

    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String username;
    private Date createdDate;
    private String modifiedDate;
    private String status;
}
