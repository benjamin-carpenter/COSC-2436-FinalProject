public class Candidate {

    private final String _name;
    private int[] stateVotes;
    public Candidate(String name, int numStates){
        _name=name;
        stateVotes = new int[numStates];
    }
    public void insertVotes(int state, int votes){
        stateVotes[state] = votes;
    }
    public void addVotes(int state, int votes){
        stateVotes[state] += votes;
    }
    public int nameCompareTo(Candidate cand){
        return _name.compareTo(cand.name());
    }
    public boolean nameEquals(Candidate cand){
        return _name.equals(cand.name());
    }
    public String name(){
        return _name;
    }
    public int totalVotes(){
        int sum=0;
        for (int vote: stateVotes){
            sum+=vote;
        }
        return sum;
    }
    public int[] stateVotes(){
        return stateVotes;
    }
}
