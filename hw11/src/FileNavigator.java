
import java.io.File;
import java.util.*;

public class FileNavigator {

    private Map<String, List<FileData>> listsOfFilesByPaths = new HashMap<String, List<FileData>>();

    public void add(String path) {
        List<FileData> listOfFiles = new ArrayList<>();
        File directory = new File(path);
        if(directory.isDirectory()) {
            File[] listOfFilesInDirectory = directory.listFiles();
            for(File file : listOfFilesInDirectory) {
                listOfFiles.add(new FileData(file.getName(), file.length(), path));
            }
        }
        listsOfFilesByPaths.put(path, listOfFiles);
    }

    public List<FileData> find(String path) {
        List<FileData> resultList = new ArrayList<>();
        if(listsOfFilesByPaths.containsKey(path)) {
            List<FileData> listOfFiles = listsOfFilesByPaths.get(path);
            for(FileData file : listOfFiles) {
                if(Objects.equals(file.getPath(), path)) resultList.add(file);
            }
        }
        return resultList;
    }

    public List<FileData> filterByByteSize(long byteSize) {
        List<FileData> listOfFiles = new ArrayList<>();
        List<FileData> listOfFilesFilteredByByteSize = new ArrayList<>();
        String[] arrayOfPaths = listsOfFilesByPaths.keySet().toArray(new String[0]);
        for(String path : arrayOfPaths) {
            listOfFiles.addAll(listsOfFilesByPaths.get(path));
        }
        for(FileData file : listOfFiles) {
            if(file.getByteSize() <= byteSize) listOfFilesFilteredByByteSize.add(file);
        }
        return listOfFilesFilteredByByteSize;
    }

    public void remove(String path) {
        listsOfFilesByPaths.remove(path);
    }

    public List<FileData> sortByByteSize() {
        List<FileData> listOfFiles = new ArrayList<>();
        String[] arrayOfPaths = listsOfFilesByPaths.keySet().toArray(new String[0]);
        for(String path : arrayOfPaths) {
            listOfFiles.addAll(listsOfFilesByPaths.get(path));
        }
        List<FileData> sortedListOfFiles = new ArrayList<>(listOfFiles);
        Comparator<FileData> fileDataComparator = Comparator.comparingLong(FileData::getByteSize);
        sortedListOfFiles.sort(fileDataComparator);
        return sortedListOfFiles;
    }
}
