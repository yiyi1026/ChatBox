package com.huiyu.ChatBox.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Table(name = "message")
@Entity
public class Message  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channelid")
    private Channel channel;

    @Column
    private String message;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;

    public Message(User user, Channel channel, String message){
        this.user = user;
        this.channel = channel;
        this.message = message;
    }
}
