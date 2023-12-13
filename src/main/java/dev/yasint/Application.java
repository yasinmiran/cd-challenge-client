package dev.yasint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) {

        final int numberOfThreads = 5;
        final long duration = 2 * 60 * 1000; // 2 minutes in milliseconds
        String endpointUrl = "http://localhost:4000/logs";

        LogWriter logWriter = new LogWriter(endpointUrl);
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executor.execute(new LogGenerator(logWriter, duration));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(duration + 1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Log generation completed.");
    }
}
