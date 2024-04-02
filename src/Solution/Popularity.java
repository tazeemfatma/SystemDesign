package Solution;

public interface Popularity {
    void increasePopularity(int contentId);
    String mostPopular();
    void decreasePopularity(int contentId);

}
