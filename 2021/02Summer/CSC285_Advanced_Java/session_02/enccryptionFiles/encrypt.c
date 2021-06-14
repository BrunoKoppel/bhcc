#include <stdlib.h>
#include <stdio.h>

void main(){

int c;

#ifdef _APPLE__
system("clear");
#elsedef
system("cls");
#endif


while ((c=getchar()) != EOF){
  putchar(++c);
  // printf("%d", c);
  }

}


