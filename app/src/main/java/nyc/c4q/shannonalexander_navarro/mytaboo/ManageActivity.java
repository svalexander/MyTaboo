package nyc.c4q.shannonalexander_navarro.mytaboo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;
import static nyc.c4q.shannonalexander_navarro.mytaboo.AddCardActivity.cardDB;

public class ManageActivity extends AppCompatActivity {

    //should this be ManageActivity?
    private static final String TAG = AddCardActivity.class.getSimpleName();

    private CardAdapter cardAdapter;
    private RecyclerView cardList;
    //this class starts the activity where you can delete cards, can navigate to add card here
    //recyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        cardAdapter = new CardAdapter(selectAllCards(), this);
        cardList = (RecyclerView) findViewById(R.id.manageRV);
        cardList.setLayoutManager(new LinearLayoutManager(this));
        cardList.setAdapter(cardAdapter);

    }

    private List<TabooCard> selectAllCards(){
        List<TabooCard> tabooCards = new ArrayList<>();

        try {
            // Iterate tabooCards
            QueryResultIterable<TabooCard> itr = cupboard().withDatabase(cardDB).query(TabooCard.class).query();
            for (TabooCard tabooCard : itr) {
                tabooCards.add(tabooCard);
            }
            itr.close();
        } catch (Exception e) {
            Log.e(TAG, "showAllCards: ", e);
        }

        // Log.d(TAG, tabooCards.toString());
        return tabooCards;
    }

    private void refreshCardList(){
        cardAdapter.setData(selectAllCards());
    }
}
