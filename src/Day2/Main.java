package Day2;
import Helper.Helper;

import java.io.IOException;
import java.util.Objects;

public class Main {
    int score = 0;

    public void run() throws IOException {
        String[] lines = Helper.readFile("src/Day2/input.txt");
        for (String line : lines) {
            int temp = 0;
            switch (line.split(" ")[1]) {
                case "X": temp += 1; break;
                case "Y": temp += 2; break;
                case "Z": temp += 3; break;
            }
            switch(checkWinner(line)){
                case 0: temp += 3; break;
                case 1: temp += 6; break;
                case 2: temp += 0; break;
            }
            score += temp;


        }
        System.out.println(score);
    }
    // rock = a,x
    // paper = b,y
    // scissor = c,z

    public int checkWinner(String line){
        /*
        0 - draw
        1 - win
        2 - loos
         */
        String[] array = line.split(" ");

        //Draw
        if(array[0].equals("A") && array[1].equals("X") || array[0].equals("B") && array[1].equals("Y") || array[0].equals("C") && array[1].equals("Z")){
            return 0;
        }
        //Sieg
        if(array[0].equals("A") && array[1].equals("Y") || array[0].equals("B") && array[1].equals("Z") || array[0].equals("C") && array[1].equals("X")){
            return 1;
        }else{
            return 2;
        }
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }
}
