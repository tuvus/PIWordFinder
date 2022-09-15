package PIWordFinder;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class WordGenerator {

    public static void Generate(String pIFilePath, String outputFilePath, long start, long characterCount, long numbersToParse) {
        start += 2;
        IntToCharacter intToCharacter = new IntToCharacter("abcdefghijklmnopqrstuvwxyz    ");
        try {
            File pIFile = new File(pIFilePath);
            if (!pIFile.exists()) {
                System.out.println("No PI file found");
                return;
            }
            File outputFile = new File(outputFilePath);
            if (!outputFile.createNewFile()) {
                outputFile.delete();
                outputFile.createNewFile();
            }
            Scanner scan = new Scanner(pIFile);
            scan.useDelimiter("");
            for (long s = 0; s < start; s++) {
                scan.next();
            }
            FileWriter writer = new FileWriter(outputFile);
            for (long i = 0; i < characterCount; i++) {
                int number = 0;
                for (long f = 1; f <= numbersToParse; f++) {
                    number += (int) (scan.nextLong() * Math.pow( 10, numbersToParse - f));
                }
                writer.write(intToCharacter.getCharFromInt(number));
            }
            writer.close();
            scan.close();
        } catch (SecurityException e) {
            System.out.println("File Creation/Deletion failed. There was a security problem.");
        } catch (Exception e) {
            System.out.println("Problem loading PI.txt File");
        }
    }
}
