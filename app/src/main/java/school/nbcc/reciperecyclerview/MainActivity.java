package school.nbcc.reciperecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

import static school.nbcc.reciperecyclerview.DataProvider.recipes;

/**
 * Shaelyn Hooley
 * 04/12/19
 * Main Activity
 * This assignment represents my own
 * work and is in accordance with the College
 * Academic Policy.
 */
public class MainActivity extends AppCompatActivity {

    //get linked list from data provider
    private LinkedList<String> recipe = new LinkedList<String>();

    public LinkedList<String> GetList() {
        return recipe;
    }

    //member variables
    private RecyclerView recyclerView;
    private RecipeAdapter recipeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //create adapter, give it the data
        recipeAdapter = new RecipeAdapter(this, recipe);
        //connect recycler view and adapter
        recyclerView.setAdapter(recipeAdapter);

        //assign default layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

    }
}
