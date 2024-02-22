package com.training;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class ExecutorDemo {
    public static final int noOfThreads = 30;
    public static void main(String... args) throws ExecutionException, InterruptedException {
//        Runnable runnableTask = ()->{
//            try {
//                TimeUnit.MILLISECONDS.sleep(1000);
//                System.out.println("Current time: "+ LocalDateTime.now());
//            }
//            catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
//        };
//        Runnable runnableTask = ()->{
//            out.println(Thread.currentThread());//gives current thread
//            out.println("Thread started......");
//            for(int i=0;i<10;i++){
//                out.println(i);
//            }
//            out.println("Thread ended......");
//        };
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        executor.execute(runnableTask);
//        executor.execute(runnableTask);
//        executor.execute(runnableTask);
//        for(int i=0;i<3;i++){
//            executor.execute(runnableTask);
//        }

//        ExecutorService executor = Executors.newFixedThreadPool(noOfThreads);
//
//        String[] domains={
//                "https://www.google.com",
//                "https://www.facebook.com",
//                "https://www.paypal.com",
//                "https://www.wordpress.in",
//                "https://www.ebay.com",
//                "https://www.yahoo.com"
//        };
//
//        for(int i=0;i<domains.length;i++){
//            String url = domains[i];
//            PingUrl worker = new PingUrl(url);
//            executor.execute(worker);
//        }
//
//        executor.shutdown();
//
//        if(executor.isTerminated()){
//            out.println("Finished Executing...");
//        }
        Runnable runnableTask = ()->{
            out.println("this is runnable task");
        };

//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Future status = executor.submit(runnableTask);

//        out.println(status.get());

        Callable callableTask = ()->{
            out.println("Callable task doing...");
            return "callable task done";
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future status = executor.submit(callableTask);

        out.println(status.get());

    }
}
