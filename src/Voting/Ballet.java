package Voting;

import java.util.List;

public class Ballet {
    String balletId;
    List<Vote> vote;

    public Ballet(String balletId, List<Vote> vote) {
        this.balletId = balletId;
        this.vote = vote;
    }

    public String getBalletId() {
        return balletId;
    }

    public void setBalletId(String balletId) {
        this.balletId = balletId;
    }

    public List<Vote> getVote() {
        return vote;
    }

    public void setVote(List<Vote> vote) {
        this.vote = vote;
    }
}
