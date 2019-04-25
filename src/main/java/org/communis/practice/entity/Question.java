package org.communis.practice.entity;

import lombok.Data;

import javax.persistence.*;


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

}




