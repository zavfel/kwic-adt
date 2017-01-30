package kwic.adt;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileOutput implements Output {
    private String fileName;
    
    public FileOutput(String file) {
        setOutput(file);
    }

    @Override
    public void setOutput(String output) {
        this.fileName = output;
    }

    @Override
    public void writeOutput(AlphabeticShift shifter) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {

            for (int i=0;i<shifter.getLength();i++) {
                writer.write(shifter.getAt(i) + "\n");
            }
            System.out.println("KWIC index generated");
        } catch (IOException e) {
            System.out.println("unable to write into file");
            System.exit(1);
        }
    }

}
