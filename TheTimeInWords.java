import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static String[] numbers = {
            "zero", 
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty",
            "twenty one",
            "twenty two",
            "twenty three",
            "twenty four",
            "twenty five",
            "twenty six",
            "twenty seven",
            "twenty eight",
            "twenty nine"
        };
    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String Time = null;
        if(m == 0){
            Time = hours(h) + " o' clock";
        }
        else{
            if(m > 30){
                h = h + 1;
                Time = minutes(m) + hours(h);    
            }
            else{
                Time = minutes(m) + hours(h);  
            }
            
        }
    return Time;
    }
    public static String hours(int n){
        int Fhalf = n;
        String FThalf = null;
        for(int i = 0; i <= 12; i++){
            if(Fhalf == i){
                FThalf = numbers[i];
                break;
            }
            else{
                continue;
            }
        }
        return FThalf;
    }
    public static String minutes(int n){
        int Shalf = n;
        String STHalf = null;
        int t = 0;
        if(Shalf > 30){
            if(Shalf > 45){
                for(int i = 46; i <= 59; i++){
                    if(Shalf == i){
                        t = 60 - i;
                        STHalf = numbers[t] + " minutes to ";
                        break;
                    }
                }
            }
                else if(Shalf < 45){
                    for(int i = 31; i <= 44; i++){
                        if(Shalf == i){
                            t = 60 - i;
                            STHalf = numbers[t] + " minutes to ";
                            break;
                        }
                    }
                }
                else{
                    STHalf = "quarter to ";
            }
        }
        else if(Shalf < 30){
            if(Shalf == 1){
                STHalf = numbers[1] + " minute past ";
            }
            else if(Shalf > 15){
                for(int i = 16; i <= 29; i++){
                    if(Shalf == i){
                        STHalf = numbers[i] + " minutes past ";
                        break;
                    }
                }
            }
            else if(Shalf < 15 && Shalf != 1){
                for(int i = 2; i <= 14; i++){
                    if(Shalf == i){
                        STHalf = numbers[i] + " minutes past ";
                        break;
                    }    
                }
            }
            else{
                STHalf = "quarter past ";
            
            }
        }
        else{
            STHalf = "half past ";
        }
        return STHalf;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
