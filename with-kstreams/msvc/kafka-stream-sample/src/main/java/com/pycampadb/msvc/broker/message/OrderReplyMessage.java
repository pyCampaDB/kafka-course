package com.pycampadb.msvc.broker.message;

public class OrderReplyMessage {
    private String replyMessage;

    public OrderReplyMessage() {
    }

    public OrderReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }

    @Override
    public String toString() {
        return "OrderReplyMessage{" +
                "replyMessage='" + replyMessage + '\'' +
                '}';
    }
}
