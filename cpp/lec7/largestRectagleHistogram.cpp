#include<iostream>
#include<vector>
#include<stack>
using namespace std;
class  largestRectagleHistogram{
public:
    int largestRectangleArea(vector<int>& heights) {
        int n=heights.size();
        if(n==0){
            return 0;
        }
        stack<int> st;
        st.push(-1);
        int area=0;
        for(int i=0;i<heights.size();i++){
            while(st.top()!=-1 && heights[i]<=heights[st.top()]){
                int h=heights[st.top()];
                st.pop();
                int w=i-st.top()-1;
                area=max(area,w*h);
            }
            st.push(i);
        }
        while(st.top()!=-1){
            int h=heights[st.top()];
            st.pop();
            int w=n-st.top()-1;
            area=max(area,w*h);
        }
        return area;
    }
};