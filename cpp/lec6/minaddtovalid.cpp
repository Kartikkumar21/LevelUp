class Solution {
public:
    int minAddToMakeValid(string S) {
        int n=S.length();
        stack<int> st;
        for(int i=0;i<n;i++){
            if(st.size()!=0 && S[st.top()]=='(' && S[i]==')'){
                st.pop();
            }
            else{
                st.push(i);
            }
        }
        return st.size();
    }
};