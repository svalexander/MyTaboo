package nyc.c4q.shannonalexander_navarro.mytaboo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by shannonalexander-navarro on 11/30/16.
 */
public class CardViewHolder extends RecyclerView.ViewHolder {

    LinearLayout layout;
    private TextView guessThisWord;
    private TextView taboo1TV;
    private TextView taboo2TV;
    private TextView taboo3TV;
    private TextView taboo4TV;
    private TextView taboo5TV;


    public CardViewHolder(View itemView) {
        super(itemView);

        layout = (LinearLayout) itemView.findViewById(R.id.layout);
        guessThisWord = (TextView) itemView.findViewById(R.id.guess_this_word);
        taboo1TV = (TextView) itemView.findViewById(R.id.taboo_one);
        taboo2TV = (TextView) itemView.findViewById(R.id.taboo_two);
        taboo3TV = (TextView) itemView.findViewById(R.id.taboo_three);
        taboo4TV = (TextView) itemView.findViewById(R.id.taboo_four);
        taboo5TV = (TextView) itemView.findViewById(R.id.taboo_five);
    }

    public void bind(TabooCard tabooCard) {

        guessThisWord.setText(tabooCard.getWordToGuess());
        taboo1TV.setText(tabooCard.getTabooWord1());
        taboo2TV.setText(tabooCard.getTabooWord2());
        taboo3TV.setText(tabooCard.getTabooWord3());
        taboo4TV.setText(tabooCard.getTabooWord4());
        taboo5TV.setText(tabooCard.getTabooWord5());
    }
}
