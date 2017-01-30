package kwic.adt;

import java.util.Arrays;
import java.util.Optional;

public class ADTMaster {
    private String inputFile;
    private String outputFile;
    
    public ADTMaster(String inputFile, Optional<String> outputFile) {
        this.inputFile = inputFile;
        
        if (outputFile.isPresent()) {
            this.outputFile = outputFile.get();
        } else {
            this.outputFile = inputFile + ".out";
        }
    }
    
    public void generateKWIC() {
        Input fileInput = new FileInput(inputFile);
        Titles titles = new Titles();
        
        fileInput.readAndStoreInput(titles);
        CircularShift wordShift = new WordShift(titles.getIgnoreChars());
        wordShift.generateShift(titles.getChars());
        AlphabeticShift alphaShifter = new AlphaShifter(titles.getChars(), wordShift.getShiftedIndex());
        
        FileOutput fileOutput = new FileOutput(outputFile);
        fileOutput.writeOutput(alphaShifter);
                
    }

}
