static int[] breakingRecords(int[] scores) {
        int maxcount = 0;
        int mincount = 0;
        int max = scores[0];
        int min = scores[0];
         
        for(int i = 0; i < scores.length; i++){
            if(scores[i] > max){
                max = scores[i];
                maxcount++;
            }
            if(scores[i] < min){
                min = scores[i];
                mincount++;
            }
            else{
                mincount = mincount;
                maxcount = maxcount;
            }
        }
        int [] result = {maxcount,mincount};
        return result;

    }
