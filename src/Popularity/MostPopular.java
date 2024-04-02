package Popularity;

public interface MostPopular {
    void increasePopularity(int contentId);
    int mostPopular();
    void decreasePopularity(int contentId);

}
