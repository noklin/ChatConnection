package com.noklin.network.packets.clientpackets;

import com.noklin.network.packets.Packet;

/**
 *
 * @author noklin
 */
public class FindUserPacket extends Packet{
    
    public FindUserPacket(String user) {
        super(Type.FIND_USER, new byte[][]{user.getBytes()});
    }
    
    public FindUserPacket(Packet p) {
        super(Type.FIND_USER, p.getBox());
    }
    
    public String getUser(){
        return new String(box[0]);
    }
}