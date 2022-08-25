package org.example.memoization.fibonacci;

import org.example.memoization.runtime.RuntimeSingleton;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/*
 * Reference:
 * https://www.interviewcake.com/concept/java/memoization
 */
public class Fibonacci {

    private Map<Long, Long> memo = new HashMap<>();

    // Fibonacci without Memoization
    public long fibo(long n){

        /*
         * Negative inputs are not allowed
         */
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Index was negative. No such thing as a negative index in a series.");

        /*
         * Stopping creation for recursive (Base case)
         */
        } else if (n == 0 || n == 1) {
            return n;
        }

        /*
         * Fibonacci numbers, form a sequence,
         * in which each number is the sum of the two preceding ones
         * (Recursive step)
         */
        return (fibo(n-1) + fibo(n-2));
    }

    // Fibonacci with Memoization
    public long fiboMemo(long n){

        /*
         * Negative inputs are not allowed
         */
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Index was negative. No such thing as a negative index in a series.");

            /*
             * Stopping creation for recursive (Base case)
             */
        } else if (n == 0 || n == 1) {
            return n;
        }

        /*
         * Checks if input is already computed,
         * and if it does get that value and return it
         */
        if( this.memo.containsKey(n) )
        {
            return this.memo.get(n);
        }

        /*
         * The value is saved to be put into the memoization table
         * "Fibonacci numbers, form a sequence,
         * in which each number is the sum of the two preceding ones
         * (Recursive step)"
         */
        Long result = fiboMemo(n-1)+ fiboMemo(n-2);

        this.memo.put(n, result);

        return result;

    }

    public void RunFibo(long n) {
        System.out.println("Running normal Fibonacci");
        LocalDateTime start = LocalDateTime.now();
        System.out.println("UTC time(Start) :: " + start);

        System.out.println("Fibonacci value for n="+n+":  "+this.fibo(n));

        LocalDateTime end = LocalDateTime.now();
        System.out.println("UTC time(End) :: " + end);

        RuntimeSingleton.getInstance().displayRuntime(start, end);
        System.out.println();
    }

    public void RunFiboNemo(long n) {
        System.out.println("Running Fibonacci with Memoization");
        LocalDateTime start = LocalDateTime.now();
        System.out.println("UTC time(Start) :: " + start);

        System.out.println("Fibonacci value for n="+n+":  "+this.fiboMemo(n));

        LocalDateTime end = LocalDateTime.now();
        System.out.println("UTC time(End) :: " + end);

        RuntimeSingleton.getInstance().displayRuntime(start, end);
        System.out.println();
    }

}
