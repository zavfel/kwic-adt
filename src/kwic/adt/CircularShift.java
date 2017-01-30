package kwic.adt;

import java.util.ArrayList;
import java.util.List;

public interface CircularShift {
    void setIgnoreWords(List<String> words);
    void generateShift(ArrayList<String> lines);
    ArrayList<int[]> getShiftedIndex();
    
}
