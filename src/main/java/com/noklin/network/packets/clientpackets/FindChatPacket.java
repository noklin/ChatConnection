package com.noklin.network.packets.clientpackets;

import com.noklin.network.packets.Packet;

/**
 *
 * @author noklin
 */

public class FindChatPacket extends Packet{
    
    public FindChatPacket(String chat) {
        super(Type.FIND_CHAT, new byte[][]{chat.getBytes()});
    }
    public FindChatPacket(Packet p) {
        super(Type.FIND_CHAT, p.getBox());
    }
    
    public String getChat(){
        return new String(box[0]);
    }
}