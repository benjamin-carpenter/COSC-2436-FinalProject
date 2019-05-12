public class ElectionResults {
    private Candidate[] candidates ;
    private int states;
    public ElectionResults(String[] names,int states){
        candidates = new Candidate[names.length];
        int index=0;
        for(String name: names){
            candidates[index] = new Candidate(name,states);
            index++;
        }
        this.states=states;
    }
    public void sort(boolean order){
        int ord=order?1:-1;
        int n = candidates.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (ord*candidates[j].totalVotes() > ord*candidates[j+1].totalVotes())
                {
                    // swap arr[j+1] and arr[i]
                    Candidate temp = candidates[j];
                    candidates[j] = candidates[j+1];
                    candidates[j+1] = temp;
                }
    }
    public int search(Candidate c) {
        for (int i =0; i< candidates.length;i++) {
            boolean t = candidates[i].nameEquals(c);
            if (t){
                return i;
            }

        }
    return -1;
    }
    public void addVotes(VoteData votes){
        for(Candidate candidate: candidates){
            if (votes.get_name().equals(candidate.name())){
                candidate.addVotes(votes.get_state(),votes.get_vote());

            }

        }
    }
    public String toString(){
        String result="";
        this.sort(true);
        for (int i = 0; i<candidates.length; i++) {
            int[] stateVotes = candidates[i].stateVotes();
            result += (i+1)+". "+candidates[i].name()+" "+candidates[i].totalVotes()+"\n";
            for (int j =0; j<states;i++){
                result += "\t"+j+". "+stateVotes[j]+"\n";
            }
        }
        return result;
    }

}

