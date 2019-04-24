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

    @Column(name = "id_sender")
    private Long id_sender;

    @Column(name = "id_receiver")
    private Long id_receiver;

    @Column(name = "message")
    private String message;

    public  Long getId(){
        return id;
    }
    public  Long getIdSender(){
        return id_sender;
    }
    public  Long getIdReceiver(){
        return id_receiver;
    }
    public  String getMessage(){
        return message;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setIdSender(Long id_sender){
        this.id_sender = id_sender;
    }

    public void setIdReceiver(Long id_receiver){
        this.id_receiver = id_receiver;
    }

    public void setMessage(String message){
        this.message = message;
    }
}




