package com.noklin.network.packets.clientpackets;

import com.noklin.network.packets.Packet;

/**
 *
 * @author noklin
 */

public class RemoveFriendPacket extends Packet{ 
    
    public RemoveFriendPacket(String friend) {
        super(Type.REMOVE_FRIEND, new byte[][]{friend.getBytes()});
    }
    public RemoveFriendPacket(Packet p) {
        super(Type.REMOVE_FRIEND, p.getBox());
    }
    
    public String getTarget(){
        return new String(box[0]);
    }
}