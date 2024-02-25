package com.training;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CompletionHandlerDemo {
    public static void main(String... args) throws IOException {
        String message = "Testing the completion handler";

        byte[] byteArray = message.getBytes();

        ByteBuffer buffer = ByteBuffer.wrap(byteArray);

        Path path = Paths.get("Output.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        CompletionHandler handler = new CompletionHandler() {
            @Override
            public void completed(Object result, Object attachment) {
                System.out.println(attachment + ":::" +result);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println(attachment);
                System.out.println("------------------");
                exc.printStackTrace();
            }
        };
        channel.write(buffer,0,"Demo",handler);
        channel.close();

    }
}