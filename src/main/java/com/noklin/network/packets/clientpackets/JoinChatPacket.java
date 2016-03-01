package com.noklin.network.packets.clientpackets;

import com.noklin.network.packets.Packet;

/**
 *
 * @author noklin
 */

public class JoinChatPacket extends Packet{
    
    
    public JoinChatPacket(String chat) {
        super(Type.JOIN_CHAT, new byte[][]{chat.getBytes()});
    }
    public JoinChatPacket(Packet p) {
        super(Type.JOIN_CHAT, p.getBox()); 
    }
    
    public String getChat(){
        return new String(box[0]);
    }
        
}