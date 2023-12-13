package dev.yasint;

import java.util.Date;
import java.util.Random;

public class LogGenerator implements Runnable {

    private LogWriter logWriter;
    private long durationMillis;

    public LogGenerator(LogWriter logWriter, long durationMillis) {
        this.logWriter = logWriter;
        this.durationMillis = durationMillis;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] endpoints = {"/home", "/login", "/register", "/about", "/contact"};
        long endTime = System.currentTimeMillis() + durationMillis;

        while (System.currentTimeMillis() < endTime) {
            String ipAddress = "192.168.1." + random.nextInt(255);
            String endpoint = endpoints[random.nextInt(endpoints.length)];
            Date timestamp = new Date();

            LogEntry entry = new LogEntry(ipAddress, endpoint, timestamp);
            logWriter.writeLog(entry);

            try {
                Thread.sleep(100); // Sleep to simulate time between log entries
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
