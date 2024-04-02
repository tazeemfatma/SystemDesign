package Questions;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NoOfOddAndEvenInRange {
    public static void main(String[] args){
        int l=3,n=6;
        float num=(n-l)/2;
        if(l%2==0 && n%2==0){
            System.out.println("odd="+num+"even="+(num+1));
        }
        else if(l%2!=0 && n%2!=0){
            System.out.println("odd="+(num+1)+"even="+num);
        }
        else{
            System.out.println("odd="+(num+1)+"even="+(num+1));
        }
        printMajorityElementInAnArray();

    }

    private static void printMajorityElementInAnArray() {
        Integer a[]={3,3,4,2,4,4,2,4,4};
        Arrays.stream(a).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()>a.length/2)
                .forEach(entry->System.out.println(entry.getKey()));

    }
}
