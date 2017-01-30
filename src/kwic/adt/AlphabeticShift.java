package kwic.adt;

import java.util.ArrayList;

public interface AlphabeticShift {
    public ArrayList<String> getSortedList();
    public String getAt(int i);
    public int getLength();
}
