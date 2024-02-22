package com.training.selectorDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String... args){

        //create a selector
        try {
            Selector selector = Selector.open();
            //create socket
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress("localhost",5454));

            //channel should not block anything so do below thing
            serverChannel.configureBlocking(false);

            //register the channel
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            //creating buffer
            ByteBuffer buffer = ByteBuffer.allocate(256);

            //keep server on..
            while(true){
                //see all selectors and if there then do the tasks
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while(iter.hasNext()){
                    SelectionKey key = iter.next();
                    if(key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        //create client socket
                        SocketChannel client = server.accept();

                    }
                }


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
