#include <stdio.h>

int main (int argc, char ** args){
	long long  b = 4;
	long long  *pb = &b;
	printf("%p\n", pb);
	printf("%p\n",pb+1);

	return 0; 
}
