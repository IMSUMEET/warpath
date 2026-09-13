package Models;

public class Dice {
    private int[] possibleValues;

    public Dice() {
        this.possibleValues = new int[]{1, 2, 3, 4, 8};
    }

    public int rollDice(){
        int value = (int) (Math.random() * possibleValues.length);
        return possibleValues[value];
    }
}
