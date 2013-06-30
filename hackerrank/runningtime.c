#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int count = 0;

void place_sorted(int ar_size, int * ar) {
    int tmp = ar[ar_size-1];
    int i;
    for(i=ar_size - 2;ar[i] > tmp;i--) {
        ar[i+1] = ar[i];
        count ++;
    }
    ar[i+1] = tmp;
}

/* Head ends here */
void insertionSort(int ar_size, int *  ar) {
    int i;
    for (i = 2; i <= ar_size; i++) {
        place_sorted(i,ar);
        
    }

}

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
       int _ar_size;count=0;
    scanf("%d", &_ar_size);
    int _ar[_ar_size], _ar_i;
    for(_ar_i = 0; _ar_i < _ar_size; _ar_i++) { 
       scanf("%d", &_ar[_ar_i]); 
    }

    insertionSort(_ar_size, _ar);
    printf ("%d\n",count);
    return 0;
}
