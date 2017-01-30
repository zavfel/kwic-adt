package kwic;

import java.util.Arrays;
import java.util.Optional;

import kwic.adt.ADTMaster;

public class Main {
    
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("enter with correct args\n"
                    + "Example: type inputFileName outFileName(Optional)\n"
                    + "types:\n"
                    + "1 - adt\n"
                    + "2 - pipes & filters");
            
            System.exit(1);
        }
        int architectureType = Integer.parseInt(args[0]);
        String inputFile = args[1];
        Optional<String> outputFile = Optional.empty();
        
        if (architectureType == 1) {
            if (args.length == 3) {
                outputFile = Optional.of(args[2]);
            }
            ADTMaster adt = new ADTMaster(inputFile, outputFile);
            adt.generateKWIC();
            
        } else if (architectureType == 2) {
            
        } else {
            System.out.println("indicate correct architecture type in args\n"
                    + "1 - adt\n"
                    + "2 - pipes & filters");
        }
    }

}
