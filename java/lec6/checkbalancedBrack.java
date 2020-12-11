import java.util.*;
class checkbalancedBrack{
    public static Scanner scn=new Scanner(System.in);
    public static boolean bb(String str){
         Stack<Character> st=new Stack<>();
        int i=0;
        while(i<str.length()){
            if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='['){
                st.push(str.charAt(i));
            }else if(str.charAt(i)==']'){
                if(st.size()>0 && st.peek()=='['){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else if(str.charAt(i)==')'){
                if(st.size()>0 && st.peek()=='('){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else if(str.charAt(i)=='}'){
                if(st.size()>0 && st.peek()=='{'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            i++;
        }if(st.size()>0){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        String str =scn.nextLine();
        System.out.println(bb(str));
    }
}
