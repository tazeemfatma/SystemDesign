package Voting;

public class Vote {
    String candidateId;
    int numberOfVotes;

    public Vote(String candidateId, int numberOfVotes) {
        this.candidateId = candidateId;
        this.numberOfVotes = numberOfVotes;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }
}
