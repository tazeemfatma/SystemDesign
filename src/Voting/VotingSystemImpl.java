package Voting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VotingSystemImpl implements VotingSystem{

    @Override
    public List<String> getResult(List<Ballet> balletList){
      Map<String,Integer> candidateList=new HashMap<>();
       balletList.forEach(ballet-> {
            ballet.getVote().stream()
                    .collect(Collectors.groupingBy(Vote::getCandidateId,
                            Collectors.summingInt(Vote::getNumberOfVotes)))
                    .entrySet()
                    .forEach(entry-> candidateList.put(entry.getKey(),
                            candidateList.getOrDefault(entry.getKey(),0)+entry.getValue()));
        });
        candidateList.entrySet().forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
        return candidateList.entrySet().stream()
               .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
               .map(entry->entry.getKey())
               .collect(Collectors.toList());
    }
}
