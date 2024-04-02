package Questions;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args){
        int n[]={35,41,56,36,44,33,34,92,43,32,42};
        longestSubSequence(n);
        longestSubSequenceHashing(n);
    }

    private static void longestSubSequenceHashing(int[] n) {
        HashSet<Integer> hs=new HashSet<>();
        int ans=0;
        for(int i=0;i<n.length;i++){
            hs.add(n[i]);
        }
        for(int i=0;i<n.length;i++){
            if(!hs.contains(n[i]-1)){
                int j=n[i];
                while(hs.contains(j))
                    j++;
                if(ans<j-n[i])
                    ans=j-n[i];
            }
        }
       System.out.println("ans= "+ans);
    }

    private static void longestSubSequence(int[] n) {
        Arrays.sort(n);
        int max=1,count=1;
        for(int i=1;i<n.length;i++){
            if(n[i]-n[i-1]>1){
                if(count>max){
                    max=count;
                    count=0;
                }
            }else{
                count++;
            }
        }
        System.out.println("count="+max);//nlogn
    }
}
