import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alenor on 20.09.2015.
 */
public class Threads {
    private static final String DIRECTORY = "E:\\threadtest";

    public static void main(String[] args) {
        int position = 1;
        FileFinder fileFinder = new FileFinder(DIRECTORY);
        ResultHolder resultHolder = new ResultHolder();
        File[] fileList = fileFinder.findFiles();
        List<Thread> threads = new ArrayList<Thread>();
        for (File file : fileList) {
            Thread thread = new Thread(new Job(position, resultHolder, file));
            threads.add(thread);
            thread.start();
            position++;
        }
        for (Thread thread : threads) {
            if (thread.isAlive()) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Result : " + resultHolder.getResult());
    }
}
