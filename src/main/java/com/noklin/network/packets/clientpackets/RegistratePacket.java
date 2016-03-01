/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noklin.network.packets.clientpackets;

import com.noklin.network.packets.Packet;

/**
 *
 * @author noklin
 */
public class RegistratePacket extends Packet{
    
    public RegistratePacket(Packet p){
        super(Type.REGISTRATE , p.getBox());
    }
    
    public RegistratePacket(String login , String password) {
        super(Type.REGISTRATE, new byte[][]{login.getBytes() , password.getBytes()}); 
    } 
    
    public String getLogin(){
        return new String(box[0]);
    }
    public String getPassword(){
        return new String(box[1]);
    } 
}
