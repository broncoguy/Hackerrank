#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int N,n;
    cin >> N;
    int A[N];
    for(int i = 0; i < N; i++){
        cin >> n;
        A[i] = n;
    }  

    for(int i = N-1; i>=0; i--){
        cout << A[i] << " ";
    }
    return 0;
}
