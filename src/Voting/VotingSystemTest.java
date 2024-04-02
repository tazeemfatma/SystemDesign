package Voting;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VotingSystemTest {
    private VotingSystemImpl votingSystem;

    @Before
    public void setUp() {
        votingSystem = new VotingSystemImpl();
    }

    @Test
    public void testGetResult_EmptyBalletList() {
        List<Ballet> emptyBalletList = new ArrayList<>();
        List<String> result = votingSystem.getResult(emptyBalletList);
        assertEquals("Empty ballet list should result in an empty candidate list", 0, result.size());
    }

    @Test
    public void testGetResult_SingleBalletSingleVote() {
        List<Ballet> balletList = Arrays.asList(
                new Ballet("Alice", Arrays.asList(new Vote("A", 1)))
        );
        List<String> result = votingSystem.getResult(balletList);
        assertEquals("Single ballet with single vote should have one candidate", 1, result.size());
        assertEquals("Candidate ID should match", "A", result.get(0));
    }

    @Test
    public void testGetResult_MultipleBalletsMultipleVotes() {
        List<Ballet> balletList = Arrays.asList(
                new Ballet("Ballet 1", Arrays.asList(new Vote("A", 2), new Vote("B", 3))),
                new Ballet("Ballet 1", Arrays.asList(new Vote("A", 1), new Vote("C", 4)))
        );
        List<String> result = votingSystem.getResult(balletList);
        System.out.println(result);
        assertEquals("Total candidates should be 3", 3, result.size());
        assertEquals("Candidates should be ordered by total votes", "C", result.get(0));
    }

    // Add more test cases as needed for edge cases and additional scenarios

    // You can also test removing votes and other behaviors of the VotingSystemImpl class
}
