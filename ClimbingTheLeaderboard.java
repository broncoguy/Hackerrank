import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int rankN = 1;
        int k = 0;
        int k2;
        int n = scores.length;
        int m = alice.length;
        int [] rank = new int[n];
        int [] rankM = new int[m];
        int store = 0;

        for(int j = 0; j < n; j++){
            if(k < (n-1)){
                if(scores[j] > scores[k+1]){
                    rank[j] = rankN;
                    rankN++;
                    k++;
                }
                else if(scores[j] == scores[k+1]){
                    rank[j] = rankN;
                    rank[j+1] = rankN;
                    k++;
                }
                else{
                    rankN++;
                    k++;
                }
        }
            else{
                rank[j] = rankN;
            }
        }
        
        for(int i = 0; i < m; i++){
            
            for(int j2 = (n-1) - store; j2 >= 0; j2--){
                if(alice[i] > scores[j2]){
                    rankM[i] = rank[j2];
                    store = (n-1) - j2;
                    
                }
                else if(alice[i] == scores[j2]){
                    rankM[i] = rank[j2];
                    store = (n-1) - j2;
                    break;
                }
                else if(alice[i] < scores[j2]){
                    rankM[i] = rank[j2] + 1;
                    store = (n-1) - j2;
                    break;
                }
                
            }
        }
        
        return rankM;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
