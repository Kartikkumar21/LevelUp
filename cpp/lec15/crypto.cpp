#include<iostream>
#include<vector>
using namespace std;
string s3="money";
string s2="more";
string s1="send";
vector<int> mapping(26,-1);
int numUsed=0;
int stringTONumber(string str){
    int res=0;
    for(int i=0;i<str.length();i++){
        res=res*10 + mapping[str[i]-'a'];
    }
    return res;
}
int cryptoSolver(string str,int idx){
    if(idx==str.length()){
        int x=stringTONumber(s1);
        int y=stringTONumber(s2);
        int z=stringTONumber(s3);
        if(x+y==z){
            cout<<" "<<x << "\n+" <<y <<"\n-----------" <<z<<endl;
            cout<<endl;
            return 1;
        }
        return 0;
    }
}
void crypto(){
    string str=s1+s2+s3;
    int freq=0;
    for(char ch:str){
        int mask=1<<(ch-'a');
        freq |= mask; 
    }
    str=" ";
    for(int i=0;i<26;i++){
        int mask=1<< i;
        if((freq & mask)!=0)
            str+=string (1,(char)(i+'a'));
    }
    cout<<str<<endl;
    // cout<<cryptoSolver(str,0);
}
int main(){
 crypto();
}