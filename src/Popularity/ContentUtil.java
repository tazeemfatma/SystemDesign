package Popularity;

import java.util.HashMap;
import java.util.Map;

public class ContentUtil {

    static Map<Integer,Integer> content;
    static{
        content=new HashMap<>();
        content.put(1,5);
        content.put(2,3);
        content.put(3,8);
        content.put(4,2);
        content.put(5,7);
    }
    public static Integer getPopularityScore(int contentId){
        return content.getOrDefault(contentId,0);
    }
    public static boolean isValid(int contentId){
        if(contentId==0 || !content.containsKey(contentId))
            return false;
        return true;
    }
}
