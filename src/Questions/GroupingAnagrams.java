package Questions;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingAnagrams {
    public static void main(String[] args){
        String str[]={"act","ogd","cat","god","tac","dog"};
        HashMap<String, List<String>> hm=new HashMap<String, List<String>>();

        for(int i=0; i<str.length;i++){
           String s= Arrays.stream(str[i].split("")).sorted().collect(Collectors.joining());
           if(hm.containsKey(s)){
               hm.get(s).add(str[i]);
           }else{
               List<String> list=new ArrayList<>();
               list.add(str[i]);
               hm.put(s,list);
           }
        }
        for(List<String> ls:hm.values()){
            Collections.sort(ls);
            ls.forEach(word->System.out.println(word));
        }
    }
}
