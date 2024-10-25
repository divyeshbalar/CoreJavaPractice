package org.balar.coreJavaBasics.dataStructurePractice.heaps;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Main class should be named 'Solution' and should not be public.

// Given the login events for users, implement MFA Brute Force Detection where a user is said to be under MFA Brute force if at least 10 number of login attempts
// atempted for the user with failure rate greater than 90% in the last 5 minutes

class Solution {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        
        // Test Case 1: Negative Scenario - Less than 10 attempts (No MFA attack)
        System.out.println("=== Test Case 1: Less than 10 attempts ===");
        String[] case1 = {
                "2023-01-01T08:38:20", "2023-01-01T08:38:40", "2023-01-01T08:38:59",
                "2023-01-01T08:39:05", "2023-01-01T08:39:06", "2023-01-01T08:39:08",
                "2023-01-01T08:39:10", "2023-01-01T08:40:00", "2023-01-01T08:41:00"
        };
        EventLogger el1 = new EventLogger(10, 90, 5);
        for (String dateTime : case1) {
            LocalDateTime dt = LocalDateTime.parse(dateTime, formatter);
            el1.add(1, false, dt); // All attempts are failures
        }
        
        // Test Case 2: Negative Scenario - 10 attempts but failure rate < 90%
        System.out.println("\n=== Test Case 2: 10 attempts but less than 90% failure ===");
        String[] case2 = {
                "2023-01-01T08:38:20", "2023-01-01T08:38:40", "2023-01-01T08:38:59",
                "2023-01-01T08:39:05", "2023-01-01T08:39:06", "2023-01-01T08:39:08",
                "2023-01-01T08:39:10", "2023-01-01T08:40:00", "2023-01-01T08:41:00",
                "2023-01-01T08:42:00"
        };
        EventLogger el2 = new EventLogger(10, 90, 5);
        for (int i = 0; i < case2.length; i++) {
            LocalDateTime dt = LocalDateTime.parse(case2[i], formatter);
            el2.add(1, i > 5, dt); // First 5 are failures, last five are success
        }
        
        // Test Case 3: Positive Scenario - MFA attack detected (10 attempts, 100% failure)
        System.out.println("\n=== Test Case 3: 10 attempts with 100% failure ===");
        String[] case3 = {
                "2023-01-01T08:38:20", "2023-01-01T08:38:39", "2023-01-01T08:38:40",
                "2023-01-01T08:38:54", "2023-01-01T08:38:59", "2023-01-01T08:39:03",
                "2023-01-01T08:39:05", "2023-01-01T08:39:06", "2023-01-01T08:39:08",
                "2023-01-01T08:39:10"
        };
        EventLogger el3 = new EventLogger(10, 90, 5);
        for (String dateTime : case3) {
            LocalDateTime dt = LocalDateTime.parse(dateTime, formatter);
            el3.add(1, false, dt); // All attempts are failures
        }
        
        
        // Test Case 4: Negative Scenario - 10 or more faulures but more than 5 minutes apart (No MFA attack)
        System.out.println("\n=== Test Case 1: Less than 10 attempts ===");
        String[] case4 = {
                "2023-01-01T08:31:20", "2023-01-01T08:32:39", "2023-01-01T08:33:40",
                "2023-01-01T08:34:54", "2023-01-01T08:35:59", "2023-01-01T08:36:03",
                "2023-01-01T08:37:05", "2023-01-01T08:39:06", "2023-01-01T08:39:08",
                "2023-01-01T08:39:10"
        };
        EventLogger el4 = new EventLogger(10, 90, 5);
        for (String dateTime : case4) {
            LocalDateTime dt = LocalDateTime.parse(dateTime, formatter);
            el4.add(1, false, dt); // All attempts are failures
        }
        
    }
}


class EventLogger {
    
    //I can move this logic to its own saperate class to follow single reponsibility but for this problem I am keeping it here
    
    Map<Integer, List<Log>> logEvents;
    int attempsThreshold;
    int percentThreshold;
    int minuteThreshold;
    
    public EventLogger(int attempsThreshold, int percentThreshold, int minuteThreshold) {
        this.attempsThreshold = attempsThreshold;
        this.percentThreshold = percentThreshold;
        this.minuteThreshold = minuteThreshold;
        this.logEvents = new HashMap<>();
    }
    
    private static long getTime(LocalDateTime current, LocalDateTime now) {
        Duration duration = Duration.between(current, now);
        return duration.toMinutes();
    }
    
    public void add(int id, boolean status, LocalDateTime time) {
        Log temp = new Log(time, status);
        if (this.logEvents.get(id) != null) {
            this.logEvents.get(id).add(temp);
        } else {
            List<Log> initialList = new ArrayList<>();
            initialList.add(temp);
            this.logEvents.put(id, initialList);
        }
        
        if (this.logEvents.get(id).size() >= attempsThreshold) {
            if (isMFAattckInProgress(this.logEvents.get(id), minuteThreshold, percentThreshold, attempsThreshold)) {
                System.out.println("MFA in progress! uid: " + id);
            } else {
                System.out.println("MFA is not in attempted");
            }
        }
        
    }
    
    private boolean isMFAattckInProgress(List<Log> listOfEvents, int minutesThreshold, int percentThreshold, int attempsThreshold) {
        int numberOfEntries = listOfEvents.size();
        LocalDateTime intiTime = listOfEvents.get(numberOfEntries - 1).timeStamp;
        int thresholdCountDown = attempsThreshold;
        int failureCount = 0;
        int totalValidAttempts = 0;
        
        for (int i = numberOfEntries - 2; i >= 0; i--) {
            Log temp = listOfEvents.get(i);
            long minutes = Math.abs(getTime(intiTime, temp.timeStamp));
            if (minutes <= minutesThreshold && thresholdCountDown > 0) {
                totalValidAttempts++;
                if (!temp.status) {
                    failureCount++;  // Counting login failures
                }
            } else {
                break;  // Stop processing as we are out of the time window
            }
            thresholdCountDown--;
        }
        
        if (totalValidAttempts == 0) {
            return false;  // No valid attempts to analyze
        }
        
        // Calculate the failure rate percentage
        double failureRate = ((double) failureCount / totalValidAttempts) * 100;
        
        // Check if the failure rate exceeds the percentage threshold
        return failureRate >= percentThreshold;
    }
}

class Log {
    boolean status;
    LocalDateTime timeStamp;
    
    public Log(LocalDateTime timeStamp, boolean status) {
        this.timeStamp = timeStamp;
        this.status = status;
    }
}
