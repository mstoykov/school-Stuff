#include <stdio.h>
int main(int argc, char ** argv){
	printf ("char : %d\n", sizeof (char));
	printf ("int : %d\n", sizeof (int));
	printf ("short int : %d\n", sizeof (short int));
	printf ("short : %d\n", sizeof (short));
	printf ("long int : %d\n", sizeof (long int));
	printf ("long : %d\n", sizeof (long));
	printf ("long long : %d\n", sizeof (long long));
	printf ("float : %d\n", sizeof (float));
	printf ("double : %d\n", sizeof (double));
	printf ("long double: %d\n", sizeof (long double));
	printf ("double* : %d\n", sizeof (double*));
	printf ("int* : %d\n", sizeof (int*));
	printf ("void : %d\n", sizeof (void));
	printf ("void* : %d\n", sizeof (void*));

	return 0;
}
