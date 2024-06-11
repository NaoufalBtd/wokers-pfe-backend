package com.borisns.securitydemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@Data
public class FreelancerPacks {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer duration;
    private String type;

    @ManyToOne
    private Freelancer freelancer;
}
