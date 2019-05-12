import java.io.*;
import java.nio.file.*;
import java.util.concurrent.ThreadLocalRandom;
public class VoteData {


    private final String _name;
    private final int _state;
    private final int _vote;

    public VoteData(String name, int state, int vote){
        _name=name;
        _state=state;
        _vote=vote;

    }

    public static PerfectHash<VoteData> loadFile(String fileName){
        String fileContents = null;
        try {
            fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lines = fileContents.split(System.getProperty("line.separator"));
        VoteData[] data = new VoteData[990000];
        PerfectHash<VoteData> hashData = new PerfectHash<VoteData>(data,0);


        for (String line: lines){
            int i=0;
            String[] values = line.split(" ");
            VoteData tempDat = new VoteData(values[0],Integer.valueOf(values[1]),Integer.valueOf(values[2]));
            hashData.insert(i,tempDat);
            i++;
        }
        return hashData;
    }
    public static VoteData generate(String[] names){
        int candidateMin=0,candidateMax=6, voteMin=0, voteMax=51, stateMin=1 , stateMax=5 ;
        int randomVote, randomState, randomNom ;

        randomNom = ThreadLocalRandom.current().nextInt(candidateMin,candidateMax);
        randomState = ThreadLocalRandom.current().nextInt(stateMin,stateMax);
        randomVote = ThreadLocalRandom.current().nextInt(voteMin,voteMax);
        return new VoteData(names[randomNom] ,randomState,randomVote);
    }
    public String toString(){
        return _name+" "+_state+" "+_vote;

    }
    public String get_name(){
        return  _name;
    }
    public int get_state(){
        return _state;
    }
    public int get_vote(){
        return _vote;
    }

}
