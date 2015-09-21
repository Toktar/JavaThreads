import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Alenor on 21.09.2015.
 */
public class FileReader {
    private Scanner scanner;
    private int operation;
    private double result;
    private File file;

    public FileReader(File file) {
        this.operation = 0;
        this.result = 0;
        this.file = file;
    }

    public double getResult() {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            this.operation = Integer.valueOf(line);
        }

        switch (this.operation) {
            case 1: while (scanner.hasNextDouble()) {
                result += (scanner.nextDouble());
            }; break;
            case 2: result = 1;
                while (scanner.hasNextDouble()) {
                result *= (scanner.nextDouble());
            }; break;
            case 3: while (scanner.hasNextDouble()) {
                double temp = scanner.nextDouble();
                result += temp*temp;
            }; break;
            default: System.out.println("Wrong operation in " + file.getName()); break;
        }

        return result;
    }
}
