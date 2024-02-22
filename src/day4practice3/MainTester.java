package day4practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MainTester {
    public static void main(String... args) throws FileNotFoundException {
        String sourceFile = "testfilebufferchanneldemo.txt";
        String destinationFile = "destinationfile.txt";
        Path sourcePath = Paths.get(sourceFile);
        Path destinationPath = Paths.get(destinationFile);

        //by using path
        copyChannelData(sourcePath,destinationPath);

//        //using channels as arguments
//        FileInputStream sourceStream = new FileInputStream("testfilebufferchanneldemo.txt");
//        FileChannel sourceChannel = sourceStream.getChannel();
//
//        FileOutputStream destinationStream = new FileOutputStream("destinationfile.txt");
//        FileChannel destinationChannel = destinationStream.getChannel();

    }

    public static void copyChannelData(Path sourcePath,Path destinationPath){
        FileChannel readChannel = null;
        ByteBuffer buffer = null;
        byte[] bytes;

        try {
            readChannel = FileChannel.open(sourcePath);
            //ByteBuffer readBuffer = ByteBuffer.allocate(Math.toIntExact(readChannel.size()));
            //readChannel.read(readBuffer);   //read from channel to buffer

            //bytes = readBuffer.array();

            buffer = ByteBuffer.allocate(Math.toIntExact(readChannel.size()));
            readChannel.read(buffer);


            //String output = new String(bytes);

            //System.out.println("Text from the file: "+sourcePath.getFileName()+"::"+output);


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
        //ByteBuffer writer = ByteBuffer.wrap(bytes);
        buffer.flip();

        //Creating channel
        FileChannel writeChannel = null;
        try{
            writeChannel = FileChannel.open(destinationPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            //int noOfBytesWritten = writeChannel.write(writer);
            buffer.clear();
            writeChannel.write(buffer);
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


    public static void  copyChannelDataUsingChannelsAsArguments(FileChannel source,FileChannel destination){

    }
}
