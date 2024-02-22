package day4practice1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileReadingThread {
    public static void main(String... args){
        String[] filepaths={
                "SampleFiles/1.txt",
                "SampleFiles/2.txt",
                "SampleFiles/3.txt"
        };
        ExecutorService executor = Executors.newFixedThreadPool(30);
        for(int i=0;i<filepaths.length;i++){
            String url = filepaths[i];
            ReadFile worker = new ReadFile(url);
//            String status = executor.execute(worker);
//            System.out.println(status);
            executor.execute(worker);

        }
        executor.shutdown();

        if(executor.isTerminated()){
            System.out.println("finished...");
        }

    }
}
