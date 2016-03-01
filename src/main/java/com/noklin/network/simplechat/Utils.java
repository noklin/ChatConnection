package com.noklin.network.simplechat;
 
import java.util.Arrays;

/**
 *
 * @author noklin
 */

public class Utils {
    
    
    
    public static byte[] longToBytes(long l){
        return new byte[]{(byte)(l>>56) , (byte)(l>>48), (byte)(l>>40)
        , (byte)(l>>32), (byte)(l>>24), (byte)(l>>16), (byte)(l>>8), (byte)l};
    }
    
    public static byte[] intToBytes(int i){
        return new byte[]{(byte)(i>>24) , (byte)(i>>16), (byte)(i>>8)
        , (byte)(i)}; 
    }
    
    public static int bytesToInt(byte[] b){
        int i = 0;
        i |= ((long)b[0] & 255) << 24;
        i |= ((long)b[1] & 255) << 16;
        i |= ((long)b[2] & 255) << 8;
        i |= ((long)b[3] & 255);
        return i;
    }
        
      
    public static long bytesToLong(byte[] b){
        long l = 0;
        l |= ((long)b[0] & 255) << 56;
        l |= ((long)b[1] & 255) << 48;
        l |= ((long)b[2] & 255) << 40;
        l |= ((long)b[3] & 255) << 32;
        l |= ((long)b[4] & 255) << 24;
        l |= ((long)b[5] & 255) << 16;
        l |= ((long)b[6] & 255) << 8;
        l |= ((long)b[7] & 255);
        return l;
    } 
    
    public static byte[] booleanToBytes(boolean b){
        return b ? new byte[]{1} : new byte[]{0};
    }
    
    public static boolean bytesToBoolean(byte[] raw){
        return raw[0] == 1;
    }
     
    
    public static byte[] sizeToBytes(int size){ 
        byte[] raw = new byte[]{0, 0, 0, 0, (byte)(size & 127)};  
        size = size >> 7; 
        int index =  3; 
        for(; size > 0 ; index--){
            raw[index] = (byte)(size & 127);
            raw[index] |= 128; 
            size = size >> 7; 
        } 
        return Arrays.copyOfRange(raw, index + 1, raw.length);
    }
    
    public static int bytesToSize(byte[] raw){
        int tmp = raw[0] & 127;
        for(int i = 1 ; i < raw.length ; i++){
            tmp = tmp << 7;
            tmp |= raw[i] & 127;
        }
        return tmp;
    }  
     
}