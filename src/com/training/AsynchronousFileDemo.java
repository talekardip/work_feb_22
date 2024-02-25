package com.training;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsynchronousFileDemo {
    public static void main(String... args) throws IOException, ExecutionException, InterruptedException {
        String pathFile = "testfilebufferchanneldemo.txt";
        Path path = Paths.get(pathFile);

        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(256);

        Future<Integer> result = channel.read(buffer,0);
        System.out.println("no of bytes in file "+result.get());

        //reading file
        buffer.flip();
        while(buffer.hasRemaining()){
            System.out.print((char)buffer.get());

        }

    }
}