package Popularity;

import java.util.*;
import java.util.stream.Collectors;

import static Popularity.ContentUtil.content;
import static Popularity.ContentUtil.isValid;


public class MostPopularImpl implements MostPopular{
    Map<Integer,Integer> contentMap;
    int mostPupularContent;
    MostPopularImpl(){
        contentMap=new HashMap<>();
        mostPupularContent=mostPopular();
    }

    @Override
    public void increasePopularity(int contentId) {
        if(!isValid(contentId) || !content.containsKey(contentId)){
            System.out.println("Enter Valid contentId");
            return;
        }
       content.put(contentId,content.getOrDefault(contentId,0)+1);

        //most recent updated having more popularity
        if(content.getOrDefault(mostPupularContent,0) <= content.getOrDefault(contentId,0)){
            mostPupularContent=contentId;
        }
    }

    @Override
    public int mostPopular() {
        int popular = content.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(1)
                .findFirst().orElse(0);

        //most recent updated having more popularity
        if(popular!=mostPupularContent &&
                content.getOrDefault(popular,0)==content.getOrDefault(mostPupularContent,0) ){
            return mostPupularContent;
        }
    return popular;
    }

    @Override
    public void decreasePopularity(int contentId) {
        if(!isValid(contentId) || !content.containsKey(contentId)){
            System.out.println("Enter Valid contentId");
            return;
        }
        if(content.getOrDefault(contentId,0)>1)
            content.put(contentId,content.getOrDefault(contentId,0)-1);
        else
            content.put(contentId,0);

        //most recent updated having more popularity
        int newMostPopular = mostPopular();

        if(mostPupularContent==contentId &&
                content.getOrDefault(mostPupularContent,0) < content.getOrDefault(newMostPopular,0)){
            mostPupularContent=newMostPopular;
        }

    }
}
