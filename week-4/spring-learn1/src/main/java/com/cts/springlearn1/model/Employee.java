package com.cts.springlearn1.model;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Employee {
    private int id;
    private String name;
    private double salary;
    private boolean permanent;
    private Date dateOfBirth;
    private Department department;
    private List<Skill> skills;
}