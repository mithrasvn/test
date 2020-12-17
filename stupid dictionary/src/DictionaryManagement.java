import javax.swing.JOptionPane;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class DictionaryManagement extends Dictionary {
    Scanner scanner = new Scanner(System.in);
   private final File fileDictionary = new File("dictionary.txt");
    public int size = 0;

    DictionaryManagement() {
    	List <Word> words = new ArrayList <Word> ();
        insertFromFile();
    }
    // use commnadline to make arrayWord
     public void  insertFromCommandline () {
         System.out.println("Nhập chữ mà bạn muốn thêm vào: ");
         int numberOfWord = scanner.nextInt();
         scanner.nextLine();
         System.out.println(" English-TIếng Việt");

         for (int i = 0; i < numberOfWord; i++) {
             String word_target = scanner.nextLine();
             String word_explain = scanner.nextLine();
             words.add(new Word(word_target, word_explain)) ;
         }
     }

     public void insertFromFile()  throws  ArrayIndexOutOfBoundsException{
    	
         try {
        	 FileReader fileReader = new FileReader(fileDictionary, StandardCharsets.UTF_8);
             Scanner data = new Scanner(fileReader);

             while (data.hasNextLine()) {
                 String[] lineData = data.nextLine().split("\t");

                 words.add(new Word(lineData[0], lineData[1]));
                 size++;
             }
             data.close();
         }
         catch (IOException e) {
             System.out.println("False");
         }
     }
    // Look up follow string
     public  String dictionaryLookup( String s) {
   
    	s = s.toLowerCase();
    	int first = 1;
    	int last = words.size() - 1;
    	int mid = (first + last) / 2;
    	while ( first <= last ) {
    		
    		  if (words.get(mid ).getWord_target().compareTo(s) < 0) {
    			first = mid + 1;
    		} else  {
    			last = mid - 1;
    		}
    		  mid = (first + last) / 2;	
    		  if (words.get(mid).getWord_target().equals(s)) {
    	    		return words.get(mid).getWord_explain();
    		  }
    	}
    	return " ";
        
    }
    //Add a new word to array
     public boolean addtoList(String word_target, String word_explain ) {
        for (Word w : words) {
            if (w.getWord_target().equals(word_target)) {
                return false;
            }
        }
        words.add(new Word(word_target, word_explain));
        //sort the array
        Collections.sort(words, new Comparator<Word>(){
            public int compare(Word s1, Word s2) {
                return s1.getWord_target().compareToIgnoreCase(s2.getWord_target());
            }
        });
        	return true;
     }
     //Remove a word from array
     public boolean delete(String s) {
     
    	 int count = 0;
        for (Word w : words) {
            if ( w.getWord_target().equals(s)) {
                words.remove(w);
                count++;
                return true;
            }
        }
        if (count == 0) {
        	return false;
        }
    
        return false;
     }

     // replace a word from arrayWord
     public  boolean edit(String word_target, String word_explain ) {
         for (Word w : words) {
             if (w.getWord_target().trim().equals(word_target)) {
                 words.remove(w);
                 words.add(new Word(word_target, word_explain));
                return true;
             }
         }
         return false;
     }
     
      //search follow text
      public ArrayList dictionarySearcher(String s) {
    	  ArrayList<Word> temp = new ArrayList<Word>();
        for (Word w : words) {
            if ( w.getWord_target().contains(s)) {
                temp.add(w);
            }
        }
        return temp;
      }

      // Save
      public void save() {
    	  try(PrintWriter priwt=new PrintWriter(fileDictionary)){
    		  for (Word i : words) {
                  priwt.println(i.getWord_target() + "\t" + i.getWord_explain());
                  
              };
          } catch (Exception e) {
          	}
  }
   
    // Export data from array to new file
    public void dictionaryExportToFile() {
        FileOutputStream fop = null;
        try {
            File file = new File("newfile.txt");
              fop = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            byte []  b ;
            String content;
            for (Word w : words) {
                content = w.getWord_target() + "\t" +w.getWord_explain() + "\n";
                b = content.getBytes();
                fop.write(b);
                fop.flush();
            }
            fop.close();

        } catch (IOException e) {
            System.out.println("False");
        }

    }

}
