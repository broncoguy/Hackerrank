  
#include <stdio.h>
#include <cstdlib>
void update(int *a,int *b) {
    int sumA;
    int sumB;

    sumA = *a + *b;
    sumB = *a - *b;

    *a = sumA;
    *b = abs(sumB);

}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;
    
    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}
