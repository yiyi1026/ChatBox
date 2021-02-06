package com.huiyu.ChatBox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RequestMessage {
    private String channel;
    @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss")
    private Date from;
    @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss")
    private Date to;
}
