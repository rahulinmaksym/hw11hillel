package doubleStarTask;

public record FileData(String name, long byteSize, String path) {

    public String getName() {
        return name;
    }

    public long getByteSize() {
        return byteSize;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "(File, name: \"" + name +
                "\", size in bytes: " + byteSize +
                ", path: \"" + path + "\")";
    }
}
