package com.company.insuranceapp.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id",
            insertable = false
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_course"
    )
    @SequenceGenerator(
            name = "seq_course",
            sequenceName = "seq_course",
            allocationSize = 1
    )
    private Long id;

    private String name;

    private String description;

    @JoinColumn(referencedColumnName = "storage_id", name = "cover_id")
    @OneToOne
    private Storage cover;

    @JoinColumn(referencedColumnName = "storage_id", name = "video_id")
    @OneToOne
    private Storage video;
   

    @ManyToMany(mappedBy = "courses")
    Set<User> users;
}
