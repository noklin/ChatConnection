package com.noklin.network.packets;

import com.noklin.network.simplechat.Utils;

/**
 *
 * @author noklin
 */

public class LetterStatePacket extends Packet{
     public LetterStatePacket(String letterReceiver , String state, long letterId){
        super(Packet.Type.LETTER_STATE_PACKET ,new byte[][]{letterReceiver.getBytes(), state.getBytes()
                , Utils.longToBytes(letterId)});
    }
    
    public LetterStatePacket(Packet p) {
        super(Packet.Type.LETTER_STATE_PACKET , p.getBox());
    }
     
    public String getLetterReceiver(){
        return new String(box[0]);
    }
    
    public String getStatus(){
        return new String(box[1]);
    }
    
    public long getLetterId(){
        return Utils.bytesToLong(box[2]);
    } 
}
