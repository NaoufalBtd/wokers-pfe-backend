package com.borisns.securitydemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Freelancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    private String location;

    private String level;

    private String skills;

    private String profilePicture;

    private String offerImage;

    private String offerTitle;

    private String Role;

    @OneToOne
    @JsonBackReference
    private User user;

    @OneToMany
    @JsonBackReference
    @Lazy()
    private List<FreelancerPacks> freelancerPacks;
    @OneToMany
    private List<ProjectFiles> projectFiles;

}
