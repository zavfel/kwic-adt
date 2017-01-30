package kwic.adt;

import java.util.ArrayList;
import java.util.Collections;

public class AlphaShifter implements AlphabeticShift {
    private ArrayList<String> sortedLst;

    AlphaShifter(ArrayList<String> lst, ArrayList<int[]> indexes) {
        sortedLst = new ArrayList<String>();
        for (int[] index: indexes) {
            int lineNum = index[0];
            String[] lineArr = lst.get(lineNum).split(" ");
            int firstIndex = index[1];
            boolean toAppend = true;
            StringBuilder strToAppend = new StringBuilder();
            StringBuilder currLine = new StringBuilder();
            
            for (int i=0;i<lineArr.length;i++) {
                if (toAppend) {
                    String toAdd = lineArr[i];
                    if (i==firstIndex) {
                        toAppend = false;
                        currLine.append(upperCaseFirstChar(toAdd))
                            .append(" ");
                    } else {                    
                        strToAppend.append(toAdd)
                        .append(" ");
                    }
                } else {
                    currLine.append(lineArr[i])
                                .append(" ");
                }
            }
            
            currLine.append(strToAppend.toString());
            sortedLst.add(currLine.toString().trim());
        }
        
        Collections.sort(sortedLst);
    }
    
    private String upperCaseFirstChar(String string) {
        if (string.length() <= 1) {
            return string.toUpperCase();
        }
        
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }
    
    @Override
    public ArrayList<String> getSortedList() {
        return sortedLst;
    }

    @Override
    public String getAt(int i) {
        return sortedLst.get(i);
    }
    
    @Override
    public int getLength() {
        return sortedLst.size();
    }

    
}
