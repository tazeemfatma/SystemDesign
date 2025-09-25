package Popularity;

import java.util.*;

import static Popularity.ContentUtil.content;
import static Popularity.ContentUtil.isValid;


public class MostPopularImpl implements MostPopular{
    Map<Integer,Integer> contentMap;
    int mostPopularContent;
    MostPopularImpl(){
        contentMap=new HashMap<>();
        mostPopularContent =mostPopular();
    }

    /**
     * Increases the popularity count of the specified content ID by 1.
     * If the content ID is invalid or does not exist, prints an error message and returns.
     * Updates the most popular content if the increased content becomes equally or more popular
     * than the current most popular content.
     *
     * @param contentId the ID of the content whose popularity is to be increased
     */
    @Override
    public void increasePopularity(int contentId) {
        if(!isValid(contentId) || !content.containsKey(contentId)){
            System.out.println("Enter Valid contentId");
            return;
        }
       content.put(contentId,content.getOrDefault(contentId,0)+1);

        //most recent updated having more popularity
        if(content.getOrDefault(mostPopularContent,0) <= content.getOrDefault(contentId,0)){
            mostPopularContent =contentId;
        }
    }

    /**
     * Returns the most popular content ID based on its popularity count.
     * If there is a tie for the highest popularity, the most recently updated content ID is returned.
     *
     * @return the content ID with the highest popularity, or the most recently updated one in case of a tie
     */
    @Override
    public int mostPopular() {
        int popular = content.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(1)
                .findFirst().orElse(0);


        if(popular!= mostPopularContent &&
                content.getOrDefault(popular,0)==content.getOrDefault(mostPopularContent,0) ){
            return mostPopularContent;
        }
    return popular;
    }

    /**
     * Decreases the popularity count of the specified content ID by 1.
     * If the content ID is invalid or does not exist, prints an error message and returns.
     * If the popularity becomes less than 1, it is set to 0.
     * If the decreased content was the most popular, recalculates the most popular content.
     *
     * @param contentId the ID of the content whose popularity is to be decreased
     */
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
        if(contentId== mostPopularContent){
            mostPopularContent =mostPopular();
        }

    }
}
