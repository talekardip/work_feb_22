package com.training;

import java.nio.CharBuffer;

public class BufferDemo {
    public static void main(String... args){
        CharBuffer buffer = CharBuffer.allocate(16);
        String text = "example";
        System.out.println("Input text: "+text);

        //write in buffer
        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            buffer.put(c);
        }

        System.out.println("Position of buffer after writing: "+buffer.position());

        //change the buffer state
        buffer.flip();

        System.out.println("Position of buffer just after flip: "+buffer.position());

        //read from buffer
        System.out.println("Reading from buffer");

        while (buffer.hasRemaining()){
            System.out.print(buffer.get());
        }



    }
}
