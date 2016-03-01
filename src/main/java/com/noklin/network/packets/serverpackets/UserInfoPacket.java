package com.noklin.network.packets.serverpackets;
import com.noklin.network.packets.Packet;  

/**
 *
 * @author noklin
 */
public class UserInfoPacket extends Packet{ 
 
   
    public UserInfoPacket(String login , String publickName, byte[] photo, String mode){
        super(Type.USER_INFO_PACKET , new byte[][]{login.getBytes()
                , publickName.getBytes(), photo, mode.getBytes()});
    }
    
    public UserInfoPacket(Packet p){
        super(Type.USER_INFO_PACKET , p.getBox());
    }
    
    public String getLogin(){
        return new String(box[0]);
    }
    
    public String getPublicName(){
        return new String(box[1]);
    }
    
    public byte[] getPhoto(){
        return box[2];
    } 
    
    public String getMode(){
        return new String(box[3]);
    }
}
