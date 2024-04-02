package Popularity;

public class Application {
    public static void main(String[] args){
        MostPopular mostPopularContent=new MostPopularImpl();
        int p = mostPopularContent.mostPopular();
        System.out.println(p);
        mostPopularContent.increasePopularity(3);
        p = mostPopularContent.mostPopular();
        System.out.println(p);
        mostPopularContent.increasePopularity(4);
        p = mostPopularContent.mostPopular();
        System.out.println(p);
        mostPopularContent.decreasePopularity(4);
        p = mostPopularContent.mostPopular();
        System.out.println(p);
        mostPopularContent.decreasePopularity(3);
        p = mostPopularContent.mostPopular();
        System.out.println(p);
        mostPopularContent.decreasePopularity(5);
        p = mostPopularContent.mostPopular();
        System.out.println(p);
        mostPopularContent.decreasePopularity(5);
        p = mostPopularContent.mostPopular();
        System.out.println(p);
    }
}
