// https://www.geeksforgeeks.org/cake-distribution-problem/
public static void isPossibleToServe(double[] area,double area,int k){
    int count = 0;
    for(double ele : area){
        count += ele / area;
        if(count >= k) return true;
    }

    return false;
}


public static void servingAreaCake(int[] radii,int k){
    int n = radii.length;
    double[] area = new double[n];

    double lo = 0.0, hi = 0.0,mid = 0.0;
    for(int i = 0;i < n; i++){
        area[i] = radii[i] * radii[i] * Math.PI;
        hi = Math.max(hi,area[i]);
    }

    while(hi - lo > 1e-5){
        mid = lo + (hi - lo) / 2.0;
        if(isPossibleToServe(area,mid,k)) lo = mid;
        else hi = mid;
    }

    return mid;
}    