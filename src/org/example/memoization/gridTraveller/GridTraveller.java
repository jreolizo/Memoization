package org.example.memoization.gridTraveller;

import org.example.memoization.runtime.RuntimeSingleton;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/*
 * Say that you are a traveller on a 2D Grid.
 *   You begin in the top-left corner and
 *   your goal is to travel to the bottom-right corner.
 *   You may only move down or right.
 * In how many ways can you travel to the goal on the grid
 * Reference:
 * https://www.youtube.com/watch?v=oBt53YbR9Kk
 */
public class GridTraveller {
    private Map<String, Long> memo = new HashMap<>();

    public long travel(long row, long col) {
        if (row == 1 && col == 1) return 1;
        if (row <= 0 || col <= 0) return 0;

        return travel(row-1, col) + travel(row, col-1);
    }

    public long travelMemo(long row, long col) {
        String key = row + "," + col;

        if (row == 1 && col == 1) return 1;
        if (row <= 0 || col <= 0) return 0;

        if( this.memo.containsKey(key) )
        {
            return this.memo.get(key);
        }

        long result = travelMemo(row-1, col) + travelMemo(row, col-1);

        this.memo.put(key, result);

        return result;
    }

    public void RunGridTravel(long row, long col) {
        System.out.println("Running Grid Traveller");
        LocalDateTime start = LocalDateTime.now();
        System.out.println("UTC time(Start) :: " + start);

        System.out.println("Grid[row="+row+":col="+col+"] :  "+this.travel(row,col));

        LocalDateTime end = LocalDateTime.now();
        System.out.println("UTC time(End) :: " + end);

        RuntimeSingleton.getInstance().displayRuntime(start, end);
        System.out.println();
    }

    public void RunGridTravelNemo(long row, long col) {
        System.out.println("Running Grid Traveller with Memoization");
        LocalDateTime start = LocalDateTime.now();
        System.out.println("UTC time(Start) :: " + start);

        System.out.println("Grid[row="+row+":col="+col+"] :  "+this.travelMemo(row,col));

        LocalDateTime end = LocalDateTime.now();
        System.out.println("UTC time(End) :: " + end);

        RuntimeSingleton.getInstance().displayRuntime(start, end);
        System.out.println();
    }
}
