package com.noklin.network.packets.serverpackets;

import com.noklin.network.packets.Packet;

/**
 *
 * @author noklin
 */
public class ChatInfoPacket extends Packet{
     
    
    public ChatInfoPacket(String title){
        super(Type.CHAT_INFO_PACKET, new byte[][]{title.getBytes()});
    }
    
    public ChatInfoPacket(Packet p){
        super(Type.CHAT_INFO_PACKET, p.getBox());
    }
    
    public String getTitle(){
        return new String(box[0]);
    }
}
