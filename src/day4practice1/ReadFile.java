package day4practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.List;


public class ReadFile implements Runnable  {
    private String fileName;

    public ReadFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread()+" started..."+fileName);
//        InputStream input = null;
//        try {
//            input = new FileInputStream(fileName);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        int i= 0;
//        try {
//            i = input.read();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        String stored = "";
//        while (i!=-1){
//            stored+=((char)i);
//            try {
//                i = input.read();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println(fileName+"  "+stored+"  "+Thread.currentThread());
        Path path = Paths.get(fileName);

        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


//    @Override
//    public String call() throws Exception {
//        System.out.println(Thread.currentThread()+" started..."+fileName);
//        InputStream input = new FileInputStream(fileName);
//        int i=input.read();
//        String stored = "";
//        while (i!=-1){
//            stored+=((char)i);
//            i = input.read();
//        }
//        return stored;
//    }
}
