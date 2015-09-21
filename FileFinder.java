import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Alenor on 20.09.2015.
 */
public class FileFinder {

    private String directory;
    private final String FILE_NAME_MASK = "in_";
    private final String EXTENSION_MASK = ".dat";

    public FileFinder(String directory) {
        this.directory = directory;
    }

    public File[] findFiles() {
        File directory = new File(this.directory);
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(FILE_NAME_MASK) && name.endsWith(EXTENSION_MASK);
            }
        });
        return files;
    }
}
