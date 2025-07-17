package principles.delegation;

public class Main {
    public static void main(String[] args) {
        DataProcessor dataProcessor=new DataProcessor("C:\\some.txt");
        //client thinks that the data processor is processing the file
        dataProcessor.process();
    }
}
