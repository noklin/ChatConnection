package com.noklin.network.packets.clientpackets;

import com.noklin.network.packets.Packet;

/**
 *
 * @author noklin
 */

public class LeaveChatPacket extends Packet{
    
    public LeaveChatPacket(String chat) {
        super(Type.LEAVE_CHAT, new byte[][]{chat.getBytes()});
    }
    public LeaveChatPacket(Packet p) {
        super(Type.LEAVE_CHAT, p.getBox());
    }
    
    public String getChat(){
        return new String(box[0]);
    }
}
