package Solution;



import java.util.*;
import java.util.stream.Collectors;

/*
*
*
//implement class to return most popular content ID in java
class MostPopular {
    void increasePopularity(int contentId);
    int mostPopular();
    void decreasePopularity(int contentId);
}
*
* */
public class PopularityImpl implements Popularity{

    Map<String,Integer> contentVsPopularityMap;

    Map<String,Deque<String>> popVsContentMap;
    //PriorityQueue<Map.Entry<String,Integer>> maxHeap;

    PopularityImpl(){
        this.contentVsPopularityMap = new HashMap<>();
        this.popVsContentMap = new TreeMap<>(Collections.reverseOrder());
    }

    @Override
    public void increasePopularity(int contentId) {

        this.contentVsPopularityMap.put(String.valueOf(contentId), contentVsPopularityMap.getOrDefault(String.valueOf(contentId),0)+1);

        Integer count = this.contentVsPopularityMap.get(String.valueOf(contentId));


        if(this.popVsContentMap.containsKey(String.valueOf(count))){

            Deque<String> val =this.popVsContentMap.get(String.valueOf(count));
            val.remove(String.valueOf(contentId));
            val.addFirst(String.valueOf(contentId));
            this.popVsContentMap.put(String.valueOf(count),val);
        }else{

            Deque<String> popDeq =new LinkedList<>();
            popDeq.addFirst(String.valueOf(contentId));
            this.popVsContentMap.put(String.valueOf(count),popDeq);
        }
        if(this.popVsContentMap.containsKey(String.valueOf(count-1))) {
            this.popVsContentMap.get(String.valueOf(count - 1)).remove(String.valueOf(contentId));
        }
    }

    @Override
    public String mostPopular() {

        String mostPopular = this.contentVsPopularityMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(1)
                .map(Map.Entry::getKey)
                .findFirst().orElse("none");
        // System.out.println(this.contentVsPopularityMap.entrySet());

     /*   this.maxHeap = new PriorityQueue<>((n1,n2) -> n2.getValue() - n1.getValue());
        maxHeap.addAll(this.contentVsPopularityMap.entrySet());

        return maxHeap.isEmpty()?"none":maxHeap.peek().getKey();*/

        Deque<String> res =this.popVsContentMap.entrySet().stream().findFirst().get().getValue();

        return (res==null || res.isEmpty())?"none":res.getFirst();
    }

    @Override
    public void decreasePopularity(int contentId) {
        if(this.contentVsPopularityMap.containsKey(String.valueOf(contentId))){

            int popularityCount = this.contentVsPopularityMap.get(String.valueOf(contentId));
            if(popularityCount<=1)
            {
                this.contentVsPopularityMap.remove(String.valueOf(contentId));
                this.popVsContentMap.get(String.valueOf(popularityCount)).remove(String.valueOf(contentId));
            }else{

                this.contentVsPopularityMap.put(String.valueOf(contentId),this.contentVsPopularityMap.get(String.valueOf(contentId))-1);
                Integer count = this.contentVsPopularityMap.get(String.valueOf(contentId));
                // add to count after doing count -1
                Deque<String> deq= this.popVsContentMap.get(String.valueOf(count));
                deq.addFirst(String.valueOf(contentId));
                this.popVsContentMap.put(String.valueOf(count),deq);
                // remove from count +1
                this.popVsContentMap.get(String.valueOf(count+1)).remove(String.valueOf(contentId));
                if(this.popVsContentMap.get(String.valueOf(count+1)).isEmpty()){
                    this.popVsContentMap.remove(String.valueOf(count+1));
                }

            }

        }else{
            System.out.println("Invalid content Id: "+String.valueOf(contentId));
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PopularityImpl that = (PopularityImpl) o;
        return Objects.equals(contentVsPopularityMap, that.contentVsPopularityMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentVsPopularityMap);
    }

    public static void main(String[] args) {
        PopularityImpl popularityTracker =new PopularityImpl();
        popularityTracker.increasePopularity(7);

        popularityTracker.increasePopularity(7);

        popularityTracker.increasePopularity(8);

        System.out.println(popularityTracker.mostPopular());        // returns 7

        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 8 most recently used as 7->2,8->2 but 8 was recently updated

        popularityTracker.increasePopularity(8);            // 8-> 3,7->2

        System.out.println(popularityTracker.mostPopular());       // returns 8

        popularityTracker.decreasePopularity(8);

        popularityTracker.decreasePopularity(8);

        System.out.println(popularityTracker.mostPopular());        // returns 7

        popularityTracker.decreasePopularity(7);

        popularityTracker.decreasePopularity(7);

        popularityTracker.decreasePopularity(8);
        System.out.println(popularityTracker.mostPopular());
    }
}
