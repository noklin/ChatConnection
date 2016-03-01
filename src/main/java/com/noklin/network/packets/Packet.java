 
package com.noklin.network.packets;

import com.noklin.network.simplechat.Utils;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Packet {
    protected byte[][] box;
    private final Packet.Type type; 

    public Packet(byte[] raw) {
        this.type = Packet.Type.asType(raw[0]);
        parseBytes(raw, 1);
    }

    public byte[][] getBox() {
        return this.box;
    }

    protected Packet(Packet.Type type, byte[][] box) {
        this.type = type;
        this.box = box;
    }
 

    private void parseBytes(byte[] raw, int offset) { 
        int sizeCount = 0;
        int itemIndex = 0;
        do{
            sizeCount |= raw[offset] & 127;
            if(raw[offset++] < 0){
                sizeCount = sizeCount << 7; 
            }
        }while(raw[offset] < 0); 
        box = new byte[sizeCount][]; 
        sizeCount = 0;
        do{
            sizeCount |= raw[offset] & 127;
            if(raw[offset++] < 0){
                sizeCount = sizeCount << 7; 
                continue;
            }
            box[itemIndex++] = Arrays.copyOfRange(raw, offset, offset + sizeCount);
            offset += sizeCount;
            sizeCount = 0;
        }while(offset < raw.length); 
    }

    public Packet.Type getType() {
        return this.type;
    }

    public byte[] asBytes() {
        int size = Utils.sizeToBytes(box.length).length + 1;   
        for (byte[] bytes : box) {
            size += bytes.length + (Utils.sizeToBytes(bytes.length).length);
        } 
        ByteBuffer bb = ByteBuffer.allocate(size);
        bb.put((byte)type.asId());
        bb.put(Utils.sizeToBytes(box.length));  
        for (byte[] item : box) {
            bb.put(Utils.sizeToBytes(item.length));
            bb.put(item);
        } 
        return bb.array();
    }
 
    @Override
    public String toString() {
        return this.type.toString();
    }

    public static enum Type {
        AUTHORIZE(1),
        JOIN_CHAT(2),
        LEAVE_CHAT(3),
        FAIL(5),
        UNKNOWN(6),
        FIND_CHAT(7),
        ADD_FRIEND(9),
        REMOVE_FRIEND(10),
        FIND_USER(11), 
        USER_INFO_PACKET(24), 
        CHAT_INFO_PACKET(25), 
        FOUND_CHAT_INFO_PACKET(27),
        FOUND_USER_INFO_PACKET(28), 
        DATA_PACKET(30), 
        REGISTRATE(31),
        LETTER_STATE_PACKET(32);

        private final int id;

        private Type(int id) {
            this.id = id;
        }

        public int asId() {
            return this.id;
        }

        public static Type asType(int id){ 
            for(Type val : values()) {
                if(val.id == id){
                    return val;
                }  
            }
            return UNKNOWN;
        } 
    }
}
