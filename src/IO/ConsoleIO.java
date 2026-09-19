package IO;

import java.util.Scanner;

import Interfaces.IOInterface;

public class ConsoleIO implements IOInterface, AutoCloseable{

    // Private consts
    private final Scanner scanner;

    public ConsoleIO(){
        this.scanner = new Scanner(System.in);
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

    @Override
    public void close(){
        scanner.close();
    }
}
