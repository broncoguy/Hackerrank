#include <iostream>
#include <cstdio>
using namespace std;

 
 int max_of_four(int a, int b, int c, int d){
    int max = 0;
    if(b > a && b > c && b > d){
        max = b;
    }
    else if(c > b && c > d && c > a){
        max = c;
    }
    else if(d > a && d > b && d > c){
        max = d;
    }
    else{
        max = a;
    }

    
    

     return max;
 }



int main() {
    int a, b, c, d;
    scanf("%d %d %d %d", &a, &b, &c, &d);
    int ans = max_of_four(a, b, c, d);
    printf("%d", ans);
    
    return 0;
}

