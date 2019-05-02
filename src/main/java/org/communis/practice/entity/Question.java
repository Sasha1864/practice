package org.communis.practice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question")
    private String question;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create")
    private Date dateCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_close")
    private Date dateClose;

}




