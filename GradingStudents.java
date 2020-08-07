import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    ArrayList<Integer> finalgrades = new ArrayList<Integer>();

    for(int j = 0; j < grades.size(); j++){
            if(grades.get(j) < 40){
                if(round(grades.get(j)) == 40){
                    if((round(grades.get(j)) - grades.get(j)) < 3){
                        finalgrades.add(40);
                    }
                    else{
                        finalgrades.add(grades.get(j));  
                    }
                }
                else{
                    finalgrades.add(grades.get(j));  
                }  
            }
            else if((round(grades.get(j)) - grades.get(j)) < 3){
                finalgrades.add(round(grades.get(j)));
            }
            else{
                finalgrades.add(grades.get(j));
            }
        }
    return finalgrades;
    }

    public static int round(int x){
        int y;
        if(x%5 == 0){
        y = (int)(Math.ceil(x/5))*5;    
        }
        else{
        y = (int)(Math.ceil(x/5)*5) + 5;    
        }
        return y;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
