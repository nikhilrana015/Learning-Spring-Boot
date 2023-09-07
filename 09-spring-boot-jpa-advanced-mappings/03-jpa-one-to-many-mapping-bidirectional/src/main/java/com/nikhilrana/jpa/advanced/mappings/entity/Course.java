package com.nikhilrana.jpa.advanced.mappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    @ToString.Exclude
    private Instructor instructor;

    public Course() {

    }

    public Course(String title) {
        this.title = title;
    }

}
