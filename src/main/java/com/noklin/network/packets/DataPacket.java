package com.noklin.network.packets;
 
import com.noklin.network.packets.Packet.Type;
import com.noklin.network.simplechat.Utils;
import java.util.Arrays;

public class DataPacket extends Packet { 
    
    public DataPacket(Packet p) {
        super(Type.DATA_PACKET, p.getBox());
    }
    public DataPacket(
            String contentType
            , String sender
            , String receiver
            , long date
            , byte[] data
            , boolean chat) {
        
        super(
                Type.DATA_PACKET
                , new byte[][]{
                     contentType.getBytes()
                    , sender.getBytes() 
                    , receiver.getBytes() 
                    , Utils.longToBytes(date)
                    , data
                    , Utils.booleanToBytes(chat)
                });
    }


    public String getContentType() {
        return new String(this.box[0]);
    }
    
    public String getSender() {
        return new String(this.box[1]);
    }
    
    public String getReceiver() {
        return new String(this.box[2]);
    }
 
    public long getDate() {
        return Utils.bytesToLong(this.box[3]);
    }

    public byte[] getData() {
        return this.box[4];
    }

    public boolean isChatable() {
        return Utils.bytesToBoolean(this.box[5]);
    } 

    public void setDate(long date) {
        this.box[3] = Utils.longToBytes(date);
    }
       
}