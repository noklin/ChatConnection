package com.noklin.network.packets.clientpackets; 

import com.noklin.network.packets.Packet;

/**
 *
 * @author noklin
 */

public class AuthorizePacket extends Packet{ 

    public AuthorizePacket(Packet p){
        super(Type.AUTHORIZE , p.getBox());
    }
    
    public AuthorizePacket(String login , String password) {
        super(Type.AUTHORIZE, new byte[][]{login.getBytes() , password.getBytes()}); 
    } 
    
    public String getLogin(){
        return new String(box[0]);
    }
    public String getPassword(){
        return new String(box[1]);
    } 
}