package nyc.c4q.shannonalexander_navarro.mytaboo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class AddCardActivity extends AppCompatActivity {

    private static final String TAG = AddCardActivity.class.getSimpleName();

    private CardAdapter cardAdapter;
    private RecyclerView cardList;
    private EditText addGuessWordET;
    private EditText addTabooWord1ET;
    private EditText addTabooWord2ET;
    private EditText addTabooWord3ET;
    private EditText addTabooWord4ET;
    private EditText addTabooWord5ET;
    private Button saveBtn;
    public static SQLiteDatabase cardDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        TabooDatabaseHelper tabooDatabaseHelper = TabooDatabaseHelper.getInstance(this);
        cardDB = tabooDatabaseHelper.getWritableDatabase();

        addGuessWordET = (EditText) findViewById(R.id.add_word_edit);
        addTabooWord1ET = (EditText) findViewById(R.id.word_one_edit);
        addTabooWord2ET = (EditText) findViewById(R.id.word_two_edit);
        addTabooWord3ET = (EditText) findViewById(R.id.word_three_edit);
        addTabooWord4ET = (EditText) findViewById(R.id.word_four_edit);
        addTabooWord5ET = (EditText) findViewById(R.id.word_five_edit);

        saveBtn = (Button) findViewById(R.id.save_button);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addedGuessWord = addGuessWordET.getText().toString();
                String addedTaboo1 = addTabooWord1ET.getText().toString();
                String addedTaboo2 = addTabooWord2ET.getText().toString();
                String addedTaboo3 = addTabooWord3ET.getText().toString();
                String addedTaboo4 = addTabooWord4ET.getText().toString();
                String addedTaboo5 = addTabooWord5ET.getText().toString();

                if (!addedGuessWord.isEmpty() && !addedTaboo1.isEmpty() && !addedTaboo2.isEmpty()
                        && !addedTaboo3.isEmpty() && !addedTaboo4.isEmpty() && !addedTaboo5.isEmpty()) {
                    addGuessWordET.setText("");
                    addTabooWord1ET.setText("");
                    addTabooWord2ET.setText("");
                    addTabooWord3ET.setText("");
                    addTabooWord4ET.setText("");
                    addTabooWord5ET.setText("");
                    addCard(new TabooCard(addedGuessWord, addedTaboo1, addedTaboo2, addedTaboo3, addedTaboo4, addedTaboo5));

                    refreshCardList();

                } else {
                    Toast.makeText(AddCardActivity.this, "Don't forget to add a word!", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        cardAdapter = new CardAdapter(selectAllCards(), this);
//        cardList = (RecyclerView) findViewById(R.id.activity_manage);
//        cardList.setLayoutManager(new LinearLayoutManager(this));
//        cardList.setAdapter(cardAdapter);

    }

    private void addCard(TabooCard tabooCard) {
        cupboard().withDatabase(cardDB).put(tabooCard);
    }
    private void deleteCard(TabooCard tabooCard) {
        cupboard().withDatabase(cardDB).delete(tabooCard);
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
//        cardAdapter.setData(selectAllCards());
    }
}
