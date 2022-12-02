package Helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static String[] readFile(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String str;

        List<String> list = new ArrayList<String>();
        while ((str = in.readLine()) != null) {
            list.add(str);
        }
        String[] stringArr = list.toArray(new String[0]);
        return stringArr;

    }
}
