package nyc.c4q.shannonalexander_navarro.mytaboo;

/**
 * Created by shannonalexander-navarro on 11/27/16.
 */

public class TabooCard {

    private Long _id;

    String wordToGuess;
    String tabooWord1;
    String tabooWord2;
    String tabooWord3;
    String tabooWord4;
    String tabooWord5;

    //need a default no argument constructor, required my cupboard to be able to instantiate the table
    public TabooCard() {
    }

    public TabooCard(String guessWord, String wordOne, String wordTwo, String wordThree, String wordFour, String wordFive){
        this.wordToGuess = guessWord;
        this.tabooWord1 = wordOne;
        this.tabooWord2 = wordTwo;
        this.tabooWord3 = wordThree;
        this.tabooWord4 = wordFour;
        this.tabooWord5 = wordFive;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public String getTabooWord1() {
        return tabooWord1;
    }

    public void setTabooWord1(String tabooWord1) {
        this.tabooWord1 = tabooWord1;
    }

    public String getTabooWord2() {
        return tabooWord2;
    }

    public void setTabooWord2(String tabooWord2) {
        this.tabooWord2 = tabooWord2;
    }

    public String getTabooWord3() {
        return tabooWord3;
    }

    public void setTabooWord3(String tabooWord3) {
        this.tabooWord3 = tabooWord3;
    }

    public String getTabooWord4() {
        return tabooWord4;
    }

    public void setTabooWord4(String tabooWord4) {
        this.tabooWord4 = tabooWord4;
    }

    public String getTabooWord5() {
        return tabooWord5;
    }

    public void setTabooWord5(String tabooWord5) {
        this.tabooWord5 = tabooWord5;
    }
}
