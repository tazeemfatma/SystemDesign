package Popularity;

public class Application {
    public static void main(String[] args){
        MostPopular mostPopular=new MostPopularImpl();
       /* int p = mostPopularContent.mostPopular();
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
        System.out.println(p);*/
        System.out.println(mostPopular.mostPopular());//3
        mostPopular.decreasePopularity(3);
        System.out.println(mostPopular.mostPopular());//3
        mostPopular.decreasePopularity(3);
        mostPopular.decreasePopularity(5);
        System.out.println(mostPopular.mostPopular());//5
        mostPopular.increasePopularity(5);
        mostPopular.increasePopularity(3);
        System.out.println(ContentUtil.getPopularityScore(5)+" "+ContentUtil.getPopularityScore(3));
        System.out.println(mostPopular.mostPopular());//3
        mostPopular.decreasePopularity(3);
        System.out.println(mostPopular.mostPopular());//5
    }
}
