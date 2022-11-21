package com.asimov.coursesservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Lob
    private  String description;

    private Boolean state;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "course_competences",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "competence_id")})
    @JsonManagedReference
    private List<Competence> competences;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Item> items;


    public Course(){
        items = new ArrayList<>();
    }

    public boolean isTaggedWith(Competence competence){
        return this.getCompetences().contains(competence);
    }

    public Course tagWith(Competence competence){
        if(!isTaggedWith(competence)){
            this.getCompetences().add(competence);
        }
        return this;
    }

    public Course unTagWith(Competence competence){
        if (this.isTaggedWith(competence)){
            this.getCompetences().remove(competence);
        }
        return this;
    }
}
