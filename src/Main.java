import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.WeakHashMap;
import java.util.concurrent.ThreadLocalRandom;
public class Main {


    public static void main(String[] args){
        int candidateMin=1,candidateMax=6, voteMin=0, voteMax=50, stateMin=1 , stateMax=4 , dataMin=10000, dataMax=1000000;
        int randomVote, randomState, randomData, randomNom ;
        int index=0;
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("voteData.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        randomData = ThreadLocalRandom.current().nextInt(dataMin,dataMax);
        while (index != randomData){
            randomNom = ThreadLocalRandom.current().nextInt(candidateMin,candidateMax);
            randomState = ThreadLocalRandom.current().nextInt(stateMin,stateMax);
            randomVote = ThreadLocalRandom.current().nextInt(voteMin,voteMax);



            case
            writer.println(randomNum);
            index++;
        }
        //System.out.println(randomNum);
        writer.close();









    }
}
