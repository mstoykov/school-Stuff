#include"lib.h"
#include <stdlib.h>
int intToChar(int i, char** p){
	int l = 0;
	*p = malloc(sizeof (*p) *8);
	while(i/10*l !=0 && l<8){
		*(*p+7-l)=i/10*l%10;
		l++;
	}
	return l;
}

void swap(int* p, int* k){
	int t= *p;
	*p=*k;
 	*k=t;
}
int main (){
	return 0;
}
