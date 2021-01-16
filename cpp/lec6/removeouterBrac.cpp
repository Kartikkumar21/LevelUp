class Solution {
public:
    string removeOuterParentheses(string S) {
        string str="";
        int balencedBrac=0;
        for(int i=0;i<S.length();i++){
            if(S[i]=='(' && balencedBrac++>0){
                str+=S[i];
            }
            else if(S[i]==')' && balencedBrac-->1){
                str+=S[i];
            }
        }
        return str;
    }
};