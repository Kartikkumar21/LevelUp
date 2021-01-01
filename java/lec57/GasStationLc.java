// leetcode 134
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    int extraGas = 0;
    int sp = 0;
    int dificit =0;
    
    for(int i=0;i<gas.length;i++){
        extraGas += gas[i] - cost[i];
        if(extraGas < 0){
            dificit += extraGas;
            extraGas = 0;
            sp = i + 1;
        }    
    }

    return (sp == gas.length || extraGas + dificit < 0) ? -1 : sp;
}

}