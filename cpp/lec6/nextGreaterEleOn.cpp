#include<iostream>
#include<vector>
public:
vector<int> ngor(vector<int>& arr){
    stack<int> st;
    st.push(-1);
    int n=arr.size();
    vector<int> ans(n,n);
    for(int i=0;i<n;i++){
        while(st.top()!=-1 && arr[st.top()]<arr[i]){
            ans[st.top()]=i;
            st.pop();
        }
        st.push(i);
    }
    return ans;
}
vector<int> ngol(vector<int>& arr){
    stack<int> st;
    st.push(-1);
    int n=arr.size();
    vector<int> ans(n,-1);
    for(int i=n;i>0;i--){
        while(st.top()!=-1 && arr[st.top()]<arr[i]){
            ans[st.top()]=i;
            st.pop();
        }
        st.push(i);
    }
    return ans;
}
vector<int> nsor(vector<int>& arr){
    stack<int> st;
    st.push(-1);
    int n=arr.size();
    vector<int> ans(n,n);
    for(int i=0;i<n;i++){
        while(st.top()!=-1 && arr[st.top()]>arr[i]){
            ans[st.top()]=i;
            st.pop();
        }
        st.push(i);
    }
    return ans;
}
vector<int> nsol(vector<int>& arr){
    stack<int> st;
    st.push(-1);
    int n=arr.size();
    vector<int> ans(n,-1);
    for(int i=n;i>0;i--){
        while(st.top()!=-1 && arr[st.top()]>arr[i]){
            ans[st.top()]=i;
            st.pop();
        }
        st.push(i);
    }
    return ans;
}