//package dev.yasint;
//
//// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
//// then press Enter. You can now see whitespace characters in your code.
//public class Application {
//
//    public static void main(String[] args) {
//        final int numberOfThreads = 5;
//        final int logsPerThread = 10;
//        final long duration = 2; // Duration in minutes
//        String endpointUrl = "http://localhost:4000/logs";
//
//        LogWriter logWriter = new LogWriter(endpointUrl);
//        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
//
//        for (int i = 0; i < numberOfThreads; i++) {
//            executor.execute(new LogGenerator(logWriter, logsPerThread));
//        }
//
//        executor.shutdown();
//
//        try {
//            if (!executor.awaitTermination(duration, TimeUnit.MINUTES)) {
//                executor.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            executor.shutdownNow();
//            Thread.currentThread().interrupt();
//        }
//
//        System.out.println("Log generation completed.");
//    }
//
//}