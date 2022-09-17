package PIWordFinder;

import PICompression.PICompressor;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class WordGeneratorTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Running WordPIRandomizer...");
        System.out.println("Input 0 for random Setup, Input 1 for default setup, Input 2 for custom setup. Input 3 to change text file to compressed");
        int scannerInt = scanner.nextInt();

        if (scannerInt == 0) {
            Random random = new Random();
            WordGenerator.Generate("src/PIWordFinder/PI.txt",
                    "src/PIWordFinder/PIOutput.txt",
                    random.nextInt(100000),random.nextInt(100000),random.nextInt(10) + 3);
        } else if (scannerInt == 1) {
            WordGenerator.Generate("src/PIWordFinder/PI.txt",
                    "src/PIWordFinder/PIOutput.txt",
                    0,10000,3);
        } else if (scannerInt == 2) {
            System.out.println("Please enter PI.txt file path, Output file path, Start index, number output characters wanted, characters per number to be converted to a word");
            WordGenerator.Generate(scanner.next(),scanner.next(),scanner.nextLong(),scanner.nextLong(),scanner.nextLong());
        } else if (scannerInt == 3) {
            try {
                long time = System.currentTimeMillis();
                PICompressor.CompressToBinary("C:\\Users\\Oskar\\Documents\\PiDec.txt", "src/PICompression/PICompressed");
                System.out.println("Finished compressing file!");
                System.out.println(((double)System.currentTimeMillis() - time) / 1000 + " Secs");
                time = System.currentTimeMillis();
                PICompressor.DecompressFromBinary("src/PICompression/PICompressed","src/PIWordFinder/PI.txt");
                System.out.println("Finished decompressing file!");
                System.out.println(((double)System.currentTimeMillis() - time)/ 1000 + " Secs");
            } catch (IOException e) {
                System.out.println("Problem compressing to binary.");
            }
        } else {
            System.out.println("Wrong number input. Please run again with a correct input.");
        }
    }
}