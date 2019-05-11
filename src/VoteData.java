
public class VoteData {


    private final String _name;
    private final int _state;
    private final int _vote;

    public VoteData(String name, int state, int vote){
        _name=name;
        _state=state;
        _vote=vote;

    }

    public static VoteData[] loadFile(String fileContents){
        String[] lines = fileContents.split(System.getProperty("line.separator"));

        for (String line: lines){

        }
        return ;
    }

}
