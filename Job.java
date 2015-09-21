import java.io.File;

/**
 * Created by Alenor on 20.09.2015.
 */
public class Job implements Runnable {
    private int position = 1;
    private ResultHolder resultHolder;
    private File inputFile;

    public Job(int position, ResultHolder resultHolder, File inputFile) {
        this.position = position;
        this.resultHolder = resultHolder;
        this.inputFile = inputFile;
    }

    @Override
    public void run() {
        System.out.println("Thread #" + position + " started");
        FileReader fileReader = new FileReader(inputFile);
        resultHolder.increaseResult(fileReader.getResult());
    }
}
