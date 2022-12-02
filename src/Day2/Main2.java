package Day2;
import Helper.Helper;

import java.io.IOException;

public class Main2 {
    int score = 0;

    public void run() throws IOException {
        String[] lines = Helper.readFile("src/Day2/input.txt");
        for (String line : lines) {
            System.out.println(line + " -> " + findShape(line.split(" ")[0],line.split(" ")[1]));
            int temp = 0;
            switch (line.split(" ")[1]) {
                case "X": temp += 0; break;
                case "Y": temp += 3; break;
                case "Z": temp += 6; break;
            }
            switch(findShape(line.split(" ")[0],line.split(" ")[1])){
                case "X": temp += 1; break;
                case "Y": temp += 2; break;
                case "Z": temp += 3; break;
            }

            score += temp;


        }
        System.out.println(score);
    }
    // rock = a,x
    // paper = b,y
    // scissor = c,z
    public String findShape(String enemy, String outcome){
        //X loose
        // Y Draw
        // Z win

        if(outcome.equals("X")){
            switch(enemy){
                case "A": return "Z";
                case "B": return "X";
                case "C": return "Y";
            }
        }else if(outcome.equals("Z")){
            switch(enemy){
                case "A": return "Y";
                case "B": return "Z";
                case "C": return "X";
            }
        }else{
            switch (enemy){
                case "A": return "X";
                case "B": return "Y";
                case "C": return "Z";
                default: return "Error";
            }

        }
        return "Error";
    }


    public static void main(String[] args) throws IOException {
        Main2 main = new Main2();
        main.run();
    }
}
