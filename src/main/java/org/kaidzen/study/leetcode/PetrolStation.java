package org.kaidzen.study.leetcode;

import java.util.Objects;

public class PetrolStation {

    private int[] petrol;
    private int[] distance;

    public PetrolStation() {
    }

    public static void main(String[] args) {
//        int[] gas  = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
        int[] gas  = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};
        PetrolStation station = new PetrolStation();
        System.out.println(station.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        if (Objects.isNull(gas) || Objects.isNull(cost)) return result;
        if (gas.length != cost.length) return result;
        int tank = 0;
        for (int i=0; i<gas.length; i++){
            if (gas[i] + tank < cost[i]) continue;
            if (calculateCircle(i, gas, cost)) {
                return i;
            }
        }
        return result;
    }

    private boolean calculateCircle(int ind, int[] gas, int[] cost) {
        int tank = 0;
        int[] intGas = createLoop(ind, gas);
        int[] intCost = createLoop(ind, cost);
        for (int i = 0; i < intGas.length; i++) {
            if ((intGas[i] + tank -intCost[i] > 0) && intGas[i] >= intCost[i]) {
                tank += intGas[i] - intCost[i];
            }
        }
        return tank > 0;
    }

    private int[] createLoop(int ind, int[] anArray) {
        int[] array =  new int[anArray.length];
        System.arraycopy(anArray, 0, array, 0, ind);
        System.arraycopy(anArray, ind, array, ind, anArray.length - ind);
        return array;
    }
}
