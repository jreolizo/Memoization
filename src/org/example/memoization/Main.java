package org.example.memoization;

import org.example.memoization.fibonacci.Fibonacci;
import org.example.memoization.gridTraveller.GridTraveller;

/*
 * Memoization ensures that a method doesn't run for
 * the same inputs more than once by keeping a record
 * of the results for the given inputs (usually in a hash map).
 * https://www.interviewcake.com/concept/java/memoization
 */
public class Main {

    public static void main(String[] args) {
        /*
         * Fibonacci Example
         */
        long n = 40;
        Fibonacci fibo = new Fibonacci();

        fibo.RunFiboNemo(n);
        fibo.RunFibo(n);

        /*
         * Grid Traveller Example
         */
        long row = 15, col = 15;
        GridTraveller grid = new GridTraveller();
        grid.RunGridTravelNemo(row,col );
        grid.RunGridTravel(row,col);
    }
}
