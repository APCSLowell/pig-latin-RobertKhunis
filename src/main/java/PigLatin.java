import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String sWord) {
  int a = sWord.indexOf("a"); 
  int e = sWord.indexOf("e"); 
  int i = sWord.indexOf("i"); 
  int o = sWord.indexOf("o"); 
  int u = sWord.indexOf("u"); 
  
 /* System.out.println(a);
  System.out.println(e);
  System.out.println(i);
  System.out.println(o);
  System.out.println(u);
  System.out.println("");*/
  
  ArrayList <Integer> theList = new ArrayList <Integer>();
  theList.add(a);
  theList.add(e);
  theList.add(i);
  theList.add(o);
  theList.add(u);
  int min = 4;
  for(int bob = 0; bob<theList.size(); bob++){
    if(theList.get(bob) >= 0 && theList.get(bob) < min){
      //System.out.println(theList.get(bob) > -1);
      min = theList.get(bob);
    }
  }
  
  if(min >= 0 && min < 4){
    return min;
  }
  
  
      return -1;
        //precondition: sWord is a valid String of length greater than 0.
        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
      // your code goes here
        
    }

    public String pigLatin(String sWord) {
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
        // more code should go here
        //System.out.println(findFirstVowel(sWord));
        if(sWord.length()>=2 && sWord.substring(0, 2).equals("qu")){
        return sWord.substring(2, sWord.length()) + "quay";
        } else if(findFirstVowel(sWord) == -1) {
        return sWord + "ay";
      } else if (findFirstVowel(sWord) == 0){
          return sWord + "way";
      } else if (findFirstVowel(sWord) == 1){
    return sWord.substring(1, sWord.length()) + sWord.substring(0, 1) + "ay";
      } else if (findFirstVowel(sWord) == 2){
    return sWord.substring(2, sWord.length()) + sWord.substring(0, 2) + "ay";
      } else if (findFirstVowel(sWord) == 3){
    return sWord.substring(3, sWord.length()) + sWord.substring(0, 3) + "ay";
      } else {      
    return "ERROR!";
      }
    }
    }
//end PigLatin class
