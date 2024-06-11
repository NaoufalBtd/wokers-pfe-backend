package com.borisns.securitydemo.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class ProjectFiles {
    @Id
    private Long id;
    private String name;
    private String path;
    private String type;

    @ManyToOne
    private Freelancer freelancer;
}
