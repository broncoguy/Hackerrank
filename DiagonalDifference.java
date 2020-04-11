 public static int diagonalDifference(List<List<Integer>> arr) {
    int sumA = 0;
    int sumB = 0;
    int result = 0;
    for(int i = 0; i < arr.size(); i++){
        for(int j = 0; j < arr.size(); j++){
            if(i == j){
         sumA += arr.get(i).get(j);   
            }
            if (i == arr.size() - j - 1) {
            sumB += arr.get(i).get(j);
            }
        }
        }
    
    
    result = Math.abs(sumA - sumB);

    return result;

    }

}
