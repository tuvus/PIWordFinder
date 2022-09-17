package PICompression;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class PICompressor {
    public static void CompressToBinary(String pIFile, String outFile) throws IOException {
        File file = new File(outFile + ".pi");
        if (file.exists())
            file.delete();
        file.createNewFile();
        Scanner scanner = null;
        DataOutputStream writer = null;
        try {
            scanner = new Scanner(new File(pIFile));
            scanner.useDelimiter("");
            scanner.next();
            scanner.next();
            writer = new DataOutputStream(new FileOutputStream(file));
            int count = 0;
            while (scanner.hasNextLong()) {
                long addNumber = 0;
                for (int i = 18; i >= 0; i--) {
                    if (scanner.hasNextLong()) {
                        addNumber += (long) (scanner.nextLong() * Math.pow( 10, i));
                    } else {
                        break;
                    }
                }
                count++;
                writer.writeLong(addNumber);
                if (count > 1000000)
                    break;
            }
        } finally {
            if (scanner != null)
                scanner.close();
            if (writer != null)
                writer.close();
        }
    }

    public static void DecompressFromBinary(String binaryPIFile, String outPIFile) throws IOException {
        File file = new File(outPIFile);
        if (file.exists())
            file.delete();
        file.createNewFile();
        try (InputStream reader = new FileInputStream(binaryPIFile + ".pi"); FileWriter writer = new FileWriter(file)) {
            writer.write("3.");
            while (true) {
                try {
                    String toWrite = new BigInteger(reader.readNBytes(8)).toString();
                    writer.write(toWrite);
                } catch (NumberFormatException e) {
                    break;
                }
            }
        }
    }
}
