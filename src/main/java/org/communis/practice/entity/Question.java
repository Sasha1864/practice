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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_country")
    private Country country;

    public  Long getId(){
        return id;
    }

    public  String getQuestion(){
        return question;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setQuestion(String question){
        this.question = question;
    }
}




