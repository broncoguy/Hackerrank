 static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int sumA = 0;
        int sumO = 0;
        int countA = 0;
        int countO = 0;

        for(int i = 0; i < apples.length; i++){
            sumA = apples[i] + a ;
            if(sumA >= s && sumA <= t){
                countA++;
            }
            sumA = 0;
            
        } 
        for(int i = 0; i < oranges.length; i++){
            sumO = oranges[i] +  b;
            if(sumO >= s && sumO <= t){
                countO++;
            }
            sumO = 0;
        }
        System.out.println(countA + "\n" + countO);

    }
