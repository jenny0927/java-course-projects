#include <iostream>
#include<cstdlib>
#include <cmath>
using namespace std;
bool ok(int q[], int col);
void backtrack(int &col); /*backtrack section*/
void print(int q[]);
int main(){
int q[8]; q[0]=0; /*board setup section*/
int c=0;
bool from_backtrack=false;
while(true){
while(c<8){
if(!from_backtrack) { /*column section*/
c++;
if(c==8) break;
q[c]=-1;
}
from_backtrack=false;
while(q[c]<8){ /*row section*/
q[c]++;
if(q[c]==8){
backtrack(c);
from_backtrack=true;
}
if(ok(q,c)) break;
}
}
print(q) ; /*print section*/
backtrack(c);
from_backtrack=true;
}
}
bool ok(int q[], int col){
for(int i=0; i<col; i++)
if(q[col]==q[i] || (col-i)==abs(q[col]-q[i]))
return false;
return true;
}
void backtrack(int &col){
col--;
if(col==-1)
exit(1);
}
void print(int q[]){
static int count =0;
cout<< ++ count<<endl<<endl;
for(int i=0; i<8; i++)
cout<<q[i]<<" ";
cout<<endl<<endl;
} 
