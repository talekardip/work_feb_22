package day4practice2;

import java.util.Scanner;
import java.util.concurrent.*;

public class NumbersCallable {
    public static void main(String... args) throws ExecutionException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no..");
        int n = sc.nextInt();


        ExecutorService executor = Executors.newSingleThreadExecutor();
        CallableNumbers worker = new CallableNumbers(n);
        Future status = executor.submit(worker);
        if(!status.isDone()){
            System.out.println("worker done");
            Thread.sleep(5000);
        }
        System.out.println(status.get());

        executor.shutdown();
    }
}
