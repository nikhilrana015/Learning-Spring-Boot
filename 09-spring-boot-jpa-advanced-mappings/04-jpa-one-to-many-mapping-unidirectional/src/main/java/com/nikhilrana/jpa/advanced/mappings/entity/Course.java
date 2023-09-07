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

    /*
        @JoinColumn tells the hibernate to look for course_id column inside the review table
        And using this information, help find to associate the reviews for given course
     */

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private List<Review>reviews;


    public Course() {

    }

    public Course(String title) {
        this.title = title;
    }

    public void addReview(Review review) {
        if(reviews == null) {
            reviews = new ArrayList<>();
        }

        reviews.add(review);
    }



}
