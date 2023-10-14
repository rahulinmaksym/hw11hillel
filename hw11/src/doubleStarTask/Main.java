package doubleStarTask;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("hw11/src");
        fileNavigator.add(".idea");
        List<FileData> listOfFiles = fileNavigator.find("hw11/src");
        System.out.println(listOfFiles);
        listOfFiles = fileNavigator.find(".idea");
        System.out.println(listOfFiles);
        listOfFiles = fileNavigator.filterByByteSize(1500);
        System.out.println(listOfFiles);
        fileNavigator.remove("hw11/src");
        listOfFiles = fileNavigator.find("hw11/src");
        System.out.println(listOfFiles);
        fileNavigator.add(".idea");
        listOfFiles = fileNavigator.sortByByteSize();
        System.out.println(listOfFiles);
    }
}
