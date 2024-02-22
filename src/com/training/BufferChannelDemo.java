package com.training;

import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferChannelDemo {
    public static void main(String... args){
        String fileName = "testfilebufferchanneldemo.txt";
        Path filePath = Paths.get(fileName);

        writeFile(filePath);
        readFile(filePath);
    }

    private static void writeFile(Path filePath){
        String input = "This is buffer channel demo";
        System.out.println("Writing Text: "+filePath.getFileName()+" :: "+input);
        byte[] inputBytes = input.getBytes();

        //creating a buffer
        ByteBuffer writer = ByteBuffer.wrap(inputBytes);

        //Creating channel
        FileChannel writeChannel = null;
        try{
            writeChannel = FileChannel.open(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            int noOfBytesWritten = writeChannel.write(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            //always close channel
            try {
                writeChannel.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    private static void readFile(Path filePath)  {
        FileChannel readChannel = null;
        try {
            readChannel = FileChannel.open(filePath);
            ByteBuffer readBuffer = ByteBuffer.allocate(Math.toIntExact(readChannel.size()));
            readChannel.read(readBuffer);   //read from channel to buffer

            byte[] bytes = readBuffer.array();  //store to byte array

            String output = new String(bytes);

            System.out.println("Text from the file: "+filePath.getFileName()+"::"+output);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            //always clean a channel
            try {
                readChannel.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
