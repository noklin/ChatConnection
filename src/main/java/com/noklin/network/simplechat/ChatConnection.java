package com.noklin.network.simplechat;

  
import com.noklin.network.packets.Packet; 
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException; 
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;   
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author noklin
 */

public class ChatConnection implements Closeable{  
    private final Socket clientSocket; 
    
    public ChatConnection(Socket clientSocket){ 
        this.clientSocket = clientSocket; 
    } 
     
   
    public void sendPacket(Packet p) throws IOException{
        byte[] raw = p.asBytes();
        OutputStream out = clientSocket.getOutputStream();
        out.write(Utils.sizeToBytes(raw.length));
        out.write(raw);
        out.flush(); 
    }
        
        

     
    public Packet receivePacket() throws IOException {
        InputStream in = clientSocket.getInputStream(); 
        Packet p = null;  
        
        int data = in.read();
        if(data < 0) return p;
        int packetSize = data & 127;   
        while((byte)(data & 255) < 0){
            data = in.read();
            if(data < 0){ 
                return p;
            }
            packetSize = packetSize << 7;
            packetSize |= data  & 127;
        } 
        byte[] buff = new byte[packetSize];
        int readed =  0 ;
        while(readed != packetSize){
            readed += in.read(buff , readed , packetSize - readed);
        }
        return new Packet(buff);
    }  
            
 
    @Override
    public void close() throws IOException {
        clientSocket.close();
    } 
    
     
}