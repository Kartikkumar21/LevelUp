// leetcode 875
class Solution {
public:
    bool isPossibleToEat(vector<int>&piles,int eatingSpeed,int H){
    int hours = 0;
    for(int i = piles.size()-1;i>=0;i--){
        hours += ceil(piles[i] / (eatingSpeed * 1.0));
        if(hours > H) return false;
    }
    
    return true;
}

int minEatingSpeed(vector<int>& piles, int H) {    
    // sort(piles.begin(),piles.end());
    int n = piles.size();
    int minSpeed = 1, maxSpeed = (int)1e9;
    
    while(minSpeed < maxSpeed){
        int eatingSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
        
        if(isPossibleToEat(piles,eatingSpeed,H)) maxSpeed = eatingSpeed;
        else minSpeed = eatingSpeed + 1;
    }
    
    return maxSpeed;
}
};