package org.example.memoization.runtime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class RuntimeSingleton {

    private static final RuntimeSingleton INSTANCE = new RuntimeSingleton();

    private RuntimeSingleton() {}

    public static RuntimeSingleton getInstance() {
        return INSTANCE;
    }

    public void displayRuntime(Instant start, Instant end) {

        Duration dur = Duration.between(start, end);

        System.out.println("UTC time(Run) :: " + dur);
        System.out.println("Minutes    : " + dur.toMinutes());
        System.out.println("Millis     : " + dur.toMillis());
    }

    public void displayRuntime(LocalDateTime start, LocalDateTime end) {

        Duration dur = Duration.between(start, end);

        System.out.println("UTC time(Run) :: " + dur);
        System.out.println("Minutes    : " + dur.toMinutes());
        System.out.println("Millis     : " + dur.toMillis());
    }
}
