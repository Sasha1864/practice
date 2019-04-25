package org.communis.practice.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sender")
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receiver")
    private User receiver;

    @Column(name = "message")
    private String message;

    public  Long getId(){
        return id;
    }
    public  User getSender(){
        return sender;
    }

    public  User getReceiver(){
        return receiver;
    }

    public  String getMessage(){
        return message;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setSender(User sender){
        this.sender = sender;
    }

    public void setReceiver(User receiver){
        this.receiver = receiver;
    }

    public void setMessage(String message){
        this.message = message;
    }
}




