package com.redis.rabbit_mq.model;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageQ {
    private String id;
    private String message;
    private Date messageDate;
}
