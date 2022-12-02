package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    int temp = 0;
    ArrayList<Integer> elves = new ArrayList<>();
    public void readElf(String line){
        if(line.equals("\n") || line.equals("")){
            elves.add(temp);
            temp = 0;
        }else{
            temp += Integer.parseInt(line);
        }
    }
    public void run() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/Day1/input.txt"));
        String str;

        List<String> list = new ArrayList<String>();
        while ((str = in.readLine()) != null) {
            list.add(str);
        }

        String[] stringArr = list.toArray(new String[0]);

        for (String line : stringArr) {
            readElf(line);
        }
        System.out.println(getLargest(elves));
        int total = 0;
        for (int element :
                getThreeLargest(elves)) {
            total += element;
        }
        System.out.println(total);
    }
    public int getLargest(ArrayList<Integer> list){
        int largest = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > largest){
                largest = list.get(i);
            }
        }
        return largest;
    }
    public int[] getThreeLargest(ArrayList<Integer> list){
        int largest = 0;
        int secLargest = 0;
        int thiLargest = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)>largest){
                largest = list.get(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > secLargest&& list.get(i) < largest){
                secLargest = list.get(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > thiLargest && list.get(i) < secLargest && list.get(i) < largest){
                thiLargest = list.get(i);
            }
        }
        return new int[]{largest,secLargest,thiLargest};
    }
    public static void main(String[] args) throws IOException {
       Main main = new Main();
       main.run();
    }
}
