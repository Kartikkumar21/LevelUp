#include<iostream>
#include<vector>
using namespace std;
vector<vector<int>> board;
void print2D(){
    for(vector<int> & a: board){
        for(int ele: a){
            cout<<ele<<" ";
        }
        cout<<endl;
    }
}
bool isSafeToPlaceNumber(int r,int c,int num){
    //Row
    for(int i=0;i<9;i++){
        if(board[i][c]==num) return false;
    }
    //Col
    for(int i=0;i<9;i++){
        if(board[r][i]==num) return false;
    }
    //Mat
    r = (r/3)*3;
    c = (c/3)*3;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(board[r + i][c + j] == num) return false;
        }
    }
    return true;
}
int sudokuSolver(int vidx,vector<int>& loc){
    if(vidx == loc.size()){
        print2D();
        return 1;   
    }
    int idx = loc[vidx];
    int r = idx / 9;
    int c = idx % 9;
    int count=0;
    for(int num = 1; num<=9;num++){
        if(isSafeToPlaceNumber(r,c,num)){
            board[r][c] = num;
            count+=sudokuSolver(vidx+1,loc);
            board[r][c] = 0;
        }
    }
    return false;
}
void sudoku(){
    vector<int> loc;
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            if(board[i][j] == 0){
                loc.push_back(i*9+j);
            }
        }
    }   
    sudokuSolver(0,loc);
}