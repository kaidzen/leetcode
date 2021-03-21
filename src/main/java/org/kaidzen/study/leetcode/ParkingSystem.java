package org.kaidzen.study.leetcode;

import java.util.*;

public class ParkingSystem {

    private final Map<Integer, Integer> garage = new HashMap<>();

    public ParkingSystem(int big, int medium, int small) {
        this.garage.computeIfAbsent(1, val -> Objects.nonNull(big) ? big : 0);
        this.garage.computeIfAbsent(2, val -> Objects.nonNull(medium) ? medium : 0);
        this.garage.computeIfAbsent(3, val -> Objects.nonNull(small) ? small : 0);
    }

    public static void main(String[] args) {
//      Input
//      ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
//      [[1, 1, 0], [1], [2], [3], [1]]
//      Output
//      [null, true, true, false, false]

        List<Integer> cars = Arrays.asList(1, 2, 3, 1);
        ParkingSystem parking = new ParkingSystem(1, 1, 0);
        cars.forEach(
                carType -> System.out.println(parking.addCar(carType))
        );

    }

    public boolean addCar(int carType) {
        if (garage.get(carType) <= 0){
            return false;
        }
        final Integer counter = garage.merge(carType, 0, (old, nw) -> old - 1);
        return counter >= 0;
    }
}
