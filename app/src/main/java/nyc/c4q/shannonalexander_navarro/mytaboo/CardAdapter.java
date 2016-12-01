package nyc.c4q.shannonalexander_navarro.mytaboo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by shannonalexander-navarro on 11/30/16.
 */

public class CardAdapter  extends RecyclerView.Adapter< CardViewHolder>{
   private List<TabooCard> tabooCards;

   //android made me create this, why?
    public CardAdapter(List<TabooCard> tabooCards, ManageActivity addCardActivity) {
        this.tabooCards = tabooCards;

    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_manage, parent, false);
        CardViewHolder vh = new CardViewHolder(view);
        return vh;    }


    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {

        TabooCard tabooCard = tabooCards.get(position);
        holder.bind(tabooCard);


    }

    @Override
    public int getItemCount() {
        return tabooCards.size();
    }

    public void setData(List<TabooCard> tabooCards) {
        this.tabooCards = tabooCards;
        notifyDataSetChanged();
    }

}
