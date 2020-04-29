import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
    String textL;
    String result = "";
    int L,row,column,total;
    double num;
    String [][] arr;
    String [] textarr;
    int k = 0;
    StringBuilder sb = new StringBuilder();

    textL = s.replaceAll("\\s+","");
    L = textL.length();

    num = Math.sqrt(L);

    column = (int) Math.ceil(num);
    row = (int) Math.floor(num);

    total = row * column;

    if(total < L){
    row = column;
    if((column*row) < L){
    row = (int) Math.floor(num);
    column = row;
    }
    else{
    row = column;
    }
    }
    else{
    row = row;
    column = column;
    }

    arr = new String[row][column];
    textarr = textL.split("");

    for(int i = 0; i < row; i++){
    for(int j = 0; j < column; j++){
    if(k < textL.length()){
    arr[i][j] = textarr[k];
    k++;
    }
    else{
    arr[i][j] = " ";
    k++;
    }
    }
    }

    for(int i1 = 0; i1 < column; i1++){
        for(int j1 = 0; j1 < row; j1++){
            sb.append(arr[j1][i1].trim());
        }
        sb.append(" ");
    }
    result = sb.toString().trim();

    return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
