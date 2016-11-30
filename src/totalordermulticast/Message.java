/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totalordermulticast;

import java.io.Serializable;

/**
 *
 * @author Simone
 */
public class Message implements Serializable{
    private TimeStamp ts;
    private String Body;
    private int who;

    public Message(TimeStamp ts,String body, Integer who) {
        this.ts=ts;
        this.Body=body;
        this.who=who;
        
    }

    public TimeStamp getTS() {
        return ts;
    }

    public String getBody() {
        return Body;
    }

    public int getWho() {
        return who;
    }

    public void setTS(TimeStamp ts) {
        this.ts = ts;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }

    public void setWho(int who) {
        this.who = who;
    }
}
