#include <stdio.h>
int main() {
	int i = 0; 
	while(i<20)
		printf("i=%2d %d\n",++i,i%4);
	return 0;
}
