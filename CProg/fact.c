#include <stdio.h>
#include "lib.h"
void fact (int fact, int*  in){	
	*in=1;
	while(fact>0)
		*in*=fact--;
	
}

int main(){
	int p;
	fact(5,&p);
	char* k;
	write(1,k, intToChar(p,&k));
	return 0;
}
