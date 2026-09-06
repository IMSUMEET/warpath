package IO;

import java.util.Scanner;

import Interfaces.IOInterface;

public class ConsoleIO implements IOInterface{

    // Private consts
    private final Scanner scanner;

    public ConsoleIO(Scanner scanner){
        this.scanner = scanner;
    }

    @Override 
    public String read(){
        String input = scanner.nextLine();
        return input;
    }

    @Override
    public void write(Object message){
        System.out.println(message);
    }
}
