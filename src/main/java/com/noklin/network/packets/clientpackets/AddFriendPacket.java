package com.noklin.network.packets.clientpackets;

import com.noklin.network.packets.Packet;

/**
 *
 * @author noklin
 */

public class AddFriendPacket extends Packet{
    
    public AddFriendPacket(String user) {
        super(Type.ADD_FRIEND, new byte[][]{user.getBytes()});
    }
    public AddFriendPacket(Packet p) {
        super(Type.ADD_FRIEND, p.getBox());
    }
    
    public String getTarget(){
        return new String(box[0]);
    }
    
}