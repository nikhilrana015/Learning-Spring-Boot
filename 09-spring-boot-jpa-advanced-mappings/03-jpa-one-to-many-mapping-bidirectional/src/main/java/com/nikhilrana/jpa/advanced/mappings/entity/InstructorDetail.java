package com.nikhilrana.jpa.advanced.mappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "instructor_detail")
@Setter
@Getter
@ToString
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    /*
        It tells hibernate to look at the attribute instructorDetail in
        instructor class.
        It fetches the information from @Join annotation to the required mapping
        This will not show as a separate column in database.

        When we add everything in cascade apart from CascadeType.REMOVE then we
        able to delete the instructorDetail but not the instructor.

        But we also have to set instructorDetail in the instructor object as null.
        Implementation done at appDaoImpl inside deleteInstructorDetailById function.

     */
    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "instructorDetail")
    private Instructor instructor;

    public InstructorDetail() {

    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
}
