package com.training.selectorDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static void main(String... args){

        try  {
            SocketChannel clientChannel = SocketChannel.open();
            clientChannel.connect(new InetSocketAddress("localhost",5454));
            ByteBuffer buffer = ByteBuffer.allocate(256);
            String str = "Ping to NIO server...";

            buffer.clear();
            buffer.put(str.getBytes());
            buffer.flip();

            while(buffer.hasRemaining()){
                clientChannel.write(buffer);

            }

            buffer.clear();

            clientChannel.read(buffer);
            buffer.flip();

            //read
            String res = new String(buffer.array());

            System.out.println("Server Response "+res);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
