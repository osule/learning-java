import java.util.Random;
import java.util.ArrayList;

public class MarkovModel {
    private String myText;
    private Random myRandom;
    private int linkLength;
    
    public MarkovModel(int n) {
        myRandom = new Random();
        linkLength = n;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-linkLength);
        String key = myText.substring(index, index+linkLength);
        sb.append(key);
        
        for(int k=linkLength; k < numChars; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0) break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            
            key = key.substring(1) + next;
            
        }
        
        return sb.toString();
    }
    
    
    public ArrayList<String> getFollows(String key) {
       int pos = 0;
       int index = myText.indexOf(key);
       ArrayList<String> result = new ArrayList<String>();
       while (index != -1) {
           pos = index+key.length();
           
           if(pos+1 > myText.length()) break;
           result.add(myText.substring(pos, pos+1));
           index = myText.indexOf(key, pos);
       }
       return result;
    }
}