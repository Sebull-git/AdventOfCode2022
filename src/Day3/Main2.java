package Day3;

import Helper.Helper;

import java.io.IOException;
import java.util.*;

public class Main {

    public int countChars(String str, char c)
    {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            count++;
        }

        return count;
    }
    public void run() throws IOException {
        char[] lowChars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] upChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String[] lines = Helper.readFile("src/Day3/input.txt");
        int score = 0;
        for (String line : lines)
        {
            //Splitting String
            int half = line.length() / 2;
            String[] parts = {line.substring(0,half),line.substring(half)};
            Map<Character, Integer> occurencesPart1 = new HashMap<Character, Integer>();
            Map<Character, Integer> occurencesPart2 = new HashMap<Character, Integer>();

            for (char alpChar : lowChars) {
                    occurencesPart1.put(alpChar,countChars(parts[0],alpChar));
            }
            for (char alpChar : upChars){
                occurencesPart1.put(alpChar,countChars(parts[0],alpChar));
            }
            for (char alpChar : lowChars) {
                occurencesPart2.put(alpChar,countChars(parts[1],alpChar));
            }
            for (char alpChar : upChars){
                occurencesPart2.put(alpChar,countChars(parts[1],alpChar));
            }
            for (char alpchar: occurencesPart1.keySet()) {
                if(occurencesPart1.get(alpchar) >= 1 && occurencesPart2.get(alpchar) >= 1){
                    System.out.print("in " + parts[0] + " | "+ parts[1] +  " kommt " + alpchar + " mehrmals vor -> ");
                    if(getNumber(lowChars,alpchar) != -1){
                        score += (getNumber(lowChars,alpchar) + 1);
                        System.out.println(alpchar + " has the score " + (getNumber(lowChars,alpchar) + 1));
                    } else if (getNumber(upChars, alpchar) != -1) {
                        score += (getNumber(upChars, alpchar)+27);
                        System.out.println(alpchar + " has the score " + (getNumber(upChars,alpchar) + 27) );
                    }else{
                        System.err.println("Irgendwas ist weniger schiefgelaufen");
                    }
                }else{
                    //System.err.println(occurencesPart1.get(alpchar) + " und " + occurencesPart2.get(alpchar) + " kommen nicht vor");
                }
            }
        }
        System.out.println(score);
    }
    public int getNumber(char[] aray, char searched){
        int found = -1;
        for (int i = 0; i < aray.length; i++) {
            if(Objects.equals(aray[i],searched)){
                found = i;
            }
        }
        return found;
    }
    public boolean containedInArray(char[] array, char searched){
        boolean found = false;
        for (char inti : array) {
            if (Objects.equals(inti, searched)) {
                found = true;
            }
        }
        return  found;
    }
    public static void main(String[] args) throws IOException
    {
        Main main = new Main();
        main.run();
    }
}

