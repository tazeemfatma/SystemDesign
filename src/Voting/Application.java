package Voting;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args){
        VotingSystem votingSystem=new VotingSystemImpl();
        List<Vote> voteList1= Arrays.asList(new Vote("candidate 1",100),
                new Vote("candidate 2",50),
                new Vote("candidate 1",50),
                new Vote("candidate 2",40));
        List<Vote> voteList2= Arrays.asList(new Vote("candidate 1",100),
                new Vote("candidate 2",100),
                new Vote("candidate 1",200),
                new Vote("candidate 2",400));
        List<Ballet> balletList= Arrays.asList(new Ballet("Ballet1",voteList1),
                new Ballet("Ballet2",voteList2));
        List<String> votingResults = votingSystem.getResult(balletList);
        System.out.println(votingResults);
    }
}
