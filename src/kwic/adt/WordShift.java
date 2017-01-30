package kwic.adt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordShift implements CircularShift {
    private List<String> ignoreWords = new ArrayList<String>();
    private ArrayList<int[]> circularIndex = new ArrayList<int[]>();
    
    public WordShift(List<String> ignoreWords) {
        setIgnoreWords(ignoreWords);
    }

    @Override
    public void generateShift(ArrayList<String> sentences) {
        for (int i=0;i<sentences.size();i++) {
            String[] sentence = sentences.get(i).split(" ");
            
            for (int j=0;j<sentence.length;j++) {
                if (!ignoreWords.contains(sentence[j].toLowerCase())) {
                    int[] indexToAdd = {i, j};
                    circularIndex.add(indexToAdd);
                }
            }
        }
    }

    @Override
    public void setIgnoreWords(List<String> words) {
        ignoreWords = words;
    }

    @Override
    public ArrayList<int[]> getShiftedIndex() {
        return circularIndex;
    }
    
//    public static void main(String[] args) {
//        List<String> t1 = new ArrayList<String>();
//        t1.add("the");
//        WordShift shifter = new WordShift(t1);
//        ArrayList<String> test = new ArrayList<String>();
//        test.add("he test");
//        shifter.generateShift(test);
//        
//        for (int[] i: shifter.getShiftedIndex()) {
//            System.out.println(Arrays.toString(i));
//        }
//    }

}
