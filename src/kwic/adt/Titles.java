package kwic.adt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Titles implements Characters {
    private ArrayList<String> titles;
    private List<String> ignoreWords;
    
    public Titles() {
        titles = new ArrayList<String>();
        ignoreWords = new ArrayList<String>();
    }

    @Override
    public void setChar(ArrayList<String> characters) {
        List<String> ignoreChars = Arrays.asList(characters.get(0).split(", "));
        for (String word: ignoreChars) {
            ignoreWords.add(word.toLowerCase());
        }
        
        characters.remove(0);
        titles = characters;
    }

    @Override
    public ArrayList<String> getChars() {
        return titles;
    }
    
    public List<String> getIgnoreChars() {
        return ignoreWords;
    }
    
//    public static void main(String[] args) {
//        Titles title = new Titles();
//        ArrayList<String> test = new ArrayList<String>();
//        test.add("The, Day");
//        test.add("The day after");
//        title.setChar(test);
//        System.out.println(title.getIgnoreChars());
//    }
}
