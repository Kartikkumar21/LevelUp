class Solution {
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
    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.size()==0 || matrix[0].size()==0){
            return 0;
        }
        int n=matrix.size();
        int m=matrix[0].size();
        stack<int> st;
        vector<int> heights(m,0);
        int area=0;
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix[0].size();j++){
                heights[j]=matrix[i][j]=='1'? heights[j]+1:0;
            }
            area=max(area,largestRectangleArea(heights));
        
        }
        return area;
    }
};