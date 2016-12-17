package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by GiulioRM on 12/13/2016.
 */
public class Race {
    List<RaceItem> items;
    int laps;
    double length;
    private int overlaps;

    public Race(int lapsCount, double raceLength, Car... items) {
        final double len = raceLength;
        this.items = new ArrayList<>();
        int i = 0;
        for(Car car : items) {
            this.items.add(new RaceItem(car, i, lapsCount, len));
            i++;
        }

        this.laps = lapsCount;
        this.length = raceLength;
    }

    public int getOverlaps (){
        return this.overlaps;
    }

    public void race() {
        int iteration = 0;


        while(!isEnd()){
            for(RaceItem item : items) {
                    item.move();
            }
            if (iteration == 5) {
                int vv = 0;
            }
          //  items.sort((item1, item2) -> item1.getPosition() > item2.getPosition() ? 1 : item1.getPosition() <
            //        item2. getPosition() ? -1 : 0);

            for(int i = 0; i < items.size(); i++) {
                RaceItem first = items.get(i);
              //  if (first.getLaps() < laps)
                if (!first.isStopped())
                for(int j = i + 1; j < items.size(); j++) {
                    RaceItem second = items.get(j);

                    //if (second.getLaps() < laps && first.overlaps(second))
                    if (!second.isStopped() && first.overlaps(second)) {
                        System.out.println("Overlap! " + String.valueOf(first.getNumber())
                                + " overlaps " + String.valueOf(second.getNumber()) + " on iteration " +
                                String.valueOf(iteration));
                        overlaps++;

                    }
                    //add "stopped" property
                }
            }
            iteration++;
            System.out.println("\n");
        }
    }

    private boolean isEnd() {
        int count = 0;
        for(RaceItem item : items) {
            if (item.getLaps() < laps)
                count++;
        }
        return count < 2;
    }
}
