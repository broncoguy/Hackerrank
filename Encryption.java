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

    textL = s.replaceAll("\\s+",""); //remove spaces in text
    L = textL.length(); //get the length of string text

    num = Math.sqrt(L); // compute the square root

    column = (int) Math.ceil(num); //get the higher end of square root number
    row = (int) Math.floor(num); //get the lower end of square root number

    total = row * column; //calculate nxn matrix

    if(total < L){ //if the nxn matrix is lower than total length we want to go with smallest possible nxn matrix
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

    arr = new String[row][column]; //create our final nxn matrix
    textarr = textL.split("");//split the text character by character

    for(int i = 0; i < row; i++){
    for(int j = 0; j < column; j++){
    if(k < textL.length()){
    arr[i][j] = textarr[k]; //store text in nxn matrix
    k++;
    }
    else{
    arr[i][j] = " "; //if no more characters, fill array with spaces
    k++;
    }
    }
    }

    for(int i1 = 0; i1 < column; i1++){
        for(int j1 = 0; j1 < row; j1++){
            sb.append(arr[j1][i1].trim()); //begin encryption by extract text row by row, also trim unecessary spacing
        }
        sb.append(" ");
    }
    result = sb.toString().trim(); //store string text in result using string builder, trim trailing spaces

    return result; //return result

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
