package Factory;

import Models.Dice;

public class DiceFactory{
    public Dice createNewDice(){
        return new Dice();
    }
}