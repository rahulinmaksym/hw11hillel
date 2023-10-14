
import java.io.File;
import java.util.*;

public class FileNavigator {

    private List<FileData> listOfFiles = new ArrayList<>();

    public void add(String path) {
        File directory = new File(path);
        if(directory.isDirectory()) {
            File[] listOfFilesInDirectory = directory.listFiles();
            for(File file : listOfFilesInDirectory) {
                listOfFiles.add(new FileData(file.getName(), file.length(), path));
            }
        }
        else {
            System.out.println("Invalid directory");
        }
    }

    public List<FileData> find(String path) {
        List<FileData> listOfFilesByPath = new ArrayList<>();
        File directory = new File(path);
        if(directory.isDirectory()) {
            for(FileData file : listOfFiles) {
                if(Objects.equals(file.getPath(), path)) listOfFilesByPath.add(file);
            }
        }
        else {
            System.out.println("Invalid directory");
        }
        return listOfFilesByPath;
    }

    public List<FileData> filterByByteSize(long byteSize) {
        List<FileData> listOfFilesFilteredByByteSize = new ArrayList<>();
        for(FileData file : listOfFiles) {
            if(file.getByteSize() <= byteSize) listOfFilesFilteredByByteSize.add(file);
        }
        return listOfFilesFilteredByByteSize;
    }

    public void remove(String path) {
        File directory = new File(path);
        if(directory.isDirectory()) {
            listOfFiles.removeIf(file -> Objects.equals(file.getPath(), path));
        }
        else {
            System.out.println("Invalid directory");
        }
    }

    public List<FileData> sortByByteSize() {
        List<FileData> sortedListOfFiles = new ArrayList<>(listOfFiles);
        Comparator<FileData> fileDataComparator = Comparator.comparingLong(FileData::getByteSize);
        sortedListOfFiles.sort(fileDataComparator);
        return sortedListOfFiles;
    }
}
