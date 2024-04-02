package Questions;

import java.util.HashSet;

public class PairSum {
    public static void main(String[] args){
        int a[]={1,4,45,6,10,8};
       // int a[]={0,-1,2,-3,1};
       // int a[]={1,-2,1,0,5};
        int sum=16;
        //int sum=-2;
      //  int sum=0;
        int count=0;
        HashSet<Integer> s=new HashSet<>();
        for(int i=0;i<a.length;i++){
            int temp=sum-a[i];
            if(s.contains(temp)){
                System.out.println(a[i]+" "+temp);
                count++;
            }
            s.add(a[i]);
        }
        System.out.println(count);
    }
}
