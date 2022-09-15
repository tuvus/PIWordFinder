package PIWordFinder;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class WordGeneratorTester {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Running WordPIRandomizer...");
        System.out.println("Input 0 for random Setup, Input 1 for default setup, Input 2 for custom setup.");
        int scannerInt = scanner.nextInt();

        if (scannerInt == 0) {
            Random random = new Random();
            WordGenerator.Generate("src/PIWordFinder/PI.txt",
                    "src/PIWordFinder/PIOUTPUT.txt",
                    random.nextInt(100000),random.nextInt(100000),random.nextInt(10) + 3);
        } else if (scannerInt == 1) {
            WordGenerator.Generate("src/PIWordFinder/PI.txt",
                    "src/PIWordFinder/PIOUTPUT.txt",
                    0,10000,3);
        } else if (scannerInt == 2) {
            System.out.println("Please enter PI.txt file path, Output file path, Start index, number output characters wanted, characters per number to be converted to a word");
            WordGenerator.Generate(scanner.next(),scanner.next(),scanner.nextLong(),scanner.nextLong(),scanner.nextLong());
        } else {
            System.out.println("Wrong number input. Please run again with a correct input.");
        }
    }
}
