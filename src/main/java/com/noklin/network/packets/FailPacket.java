package com.noklin.network.packets;

/**
 *
 * @author noklin
 */
public class FailPacket extends Packet{ 
    public FailPacket(String msg) {
        super(Type.FAIL , new byte[][]{msg.getBytes()});
    } 
    public FailPacket(Packet p){
        super(Type.FAIL , p.box); 
    }
    
    public String getMessage(){
        return new String(box[0]);
    }
  
}