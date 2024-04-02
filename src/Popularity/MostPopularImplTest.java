package Popularity;

import org.junit.Before;
import org.junit.Test;
import static Popularity.ContentUtil.content;
import static org.junit.Assert.assertEquals;

public class MostPopularImplTest {
    MostPopularImpl mostPopular;
   // Map<Integer,Integer> content;
    @Before
    public void setup(){
        mostPopular=new MostPopularImpl();
    }

    @Test
    public void increasePopularityTest(){
        mostPopular.increasePopularity(4);
        int val=content.get(4);
        assertEquals("Increased Popularity",11,val);
    }
    @Test
    public void invalidPopularityTest(){
        mostPopular.increasePopularity(0);
        assertEquals("Increased Popularity",0,(int)content.getOrDefault(0,0));
        mostPopular.decreasePopularity(0);
        assertEquals("Decreased Popularity",0,(int)content.getOrDefault(0,0));

        mostPopular.increasePopularity(6);
        assertEquals("Increased Popularity",0,(int)content.getOrDefault(6,0));
        mostPopular.decreasePopularity(5);
        assertEquals("Decreased Popularity",0,(int)content.getOrDefault(5,0));


    }
    @Test
    public void decreasePopularityTest(){
        mostPopular.decreasePopularity(1);
        int val=content.get(1);
        assertEquals("Increased Popularity",9,val);
    }
    @Test
    public void mostPopularTest(){
        int popular=mostPopular.mostPopular();
        assertEquals("Increased Popularity",2,popular);
    }

}
