import java.io.IOException;
import java.util.*;
public class DictionaryCommandline  {
    DictionaryManagement dm = new DictionaryManagement();
    DictionaryCommandline(DictionaryManagement dm) {
        this.dm = dm;
    }

    public  void  showAllWords(ArrayList<Word> words){
        int i = 0;
        System.out.printf("%-5s%-20s%s \n", "No","|English","|Vietnamese");
        for ( Word w : words) {
            i++;
            System.out.printf("%-5s%-20s%s \n", i, w.getWord_target(),w.getWord_explain());
        }
    }
    public void dictionaryBasic() {
        dm.insertFromCommandline();
        showAllWords(dm.words);

    }
    public void dictionaryAdvance() {
        dm.insertFromFile();
        showAllWords(dm.words);

    }

   public static void main (String []args) {
	   DictionaryManagement dm = new DictionaryManagement();
	   DictionaryCommandline dc = new DictionaryCommandline(dm);
	   System.out.println(dm.dictionaryLookup("a few"));
   }
}
