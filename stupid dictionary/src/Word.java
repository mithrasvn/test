
public class Word {
    private String word_target;
    private String word_explain;

    Word(String word_target, String word_explain) {
            this.word_target = word_target;
             this.word_explain = word_explain;
    }
    // getter, setter method
    public void setWordTarget(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWordExplain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_explain() {
        return word_explain;
    }


}