package Popularity;

import java.util.HashMap;
import java.util.Map;

public class ContentUtil {

    static Map<Integer,Integer> content;
    static{
        content=new HashMap<>();
        content.put(1,1);
        content.put(2,2);
        content.put(3,3);
        content.put(4,3);
        content.put(5,4);
    }
    public static Integer getPopularityScore(int contentId){
        return content.getOrDefault(contentId,0);
    }
    public static boolean isValid(int contentId){
        if(contentId==0)
            return false;
        return true;
    }
}
