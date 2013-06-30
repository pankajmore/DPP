#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>

void print_array(int ar_size, int * ar) {
    int j;
    for (j=0;j < ar_size;j++) {
            printf("%d ", ar[j]);
        }
        printf("\n");
}

/* Head ends here */
void partition(int ar_size, int *  ar) {
    int br[ar_size],i,j=0;
    for (i=1;i < ar_size;i++) {
        if (ar[i] < ar[0]) {
            br[j] = ar[i];
            j++;
        }
    }
    br[j] = ar[0];j++;
    for (i=1;i < ar_size;i++) {
        if (ar[i] > ar[0]) {
            br[j] = ar[i];
            j++;
        }
    }
    print_array(ar_size,br);
}

/* Tail starts here */
int main(void) {
   
   int _ar_size;
scanf("%d", &_ar_size);
int _ar[_ar_size], _ar_i;
for(_ar_i = 0; _ar_i < _ar_size; _ar_i++) { 
   scanf("%d", &_ar[_ar_i]); 
}

partition(_ar_size, _ar);
   
   return 0;
}