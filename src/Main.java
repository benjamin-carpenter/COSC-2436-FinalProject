import java.io.*;
import java.nio.file.*;
import java.util.concurrent.ThreadLocalRandom;
public class Main {


    public static void main(String[] args){
        int randomData,dataMin=10000, dataMax=1000000;
        int index=0;
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("voteData.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String fileContents = null;
        try {
            fileContents = new String(Files.readAllBytes(Paths.get("candData")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] candidateNames = fileContents.split(System.getProperty("line.separator"));
        randomData = ThreadLocalRandom.current().nextInt(dataMin,dataMax);
        while (index != randomData){

            writer.println(VoteData.generate(candidateNames));
            index++;
        }
        //System.out.println(randomNum);
        writer.close();

        PerfectHash<VoteData> hashData = VoteData.loadFile("voteData.txt");

        ElectionResults results = new ElectionResults(candidateNames,4);
        for (int i =0; i<randomData;i++){
            results.addVotes(hashData.fetch(i));
        }
        System.out.println(results);

















    }
}
