package com.allo.chat.model;

import com.allo.chat.model.enums.StatusEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
    private String senderName;
    private String receverName;
    private String message;
    private String date;
    private StatusEnum status;
}
