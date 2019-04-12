package school.nbcc.reciperecyclerview;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;


/**
 * Shaelyn Hooley
 * 04/12/19
 * Recipe Adapter
 *  This assignment represents my own
 *  work and is in accordance with the College
 *  Academic Policy.
 */
//Adapter - connect data with view items in a list
public class RecipeAdapter extends
        RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    //get linked list from data provider
    private LinkedList<String> recipe = new LinkedList<String>();

    public LinkedList<String> GetList() {
        return recipe;
    }

    private LayoutInflater mInflator;

    //create the view holder for the adapter
    //on click
    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtName;
        TextView txtDescription;
        TextView txtIngredients;
        ImageView imageView;
        TextView txtDirections;
        final RecipeAdapter recipeAdapter;
        Recipe recipe;

        //constructor to initialize view holder, set the adapter and the xml resources
        public RecipeViewHolder(View itemView, RecipeAdapter adapter) {
            super(itemView);


            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            Picasso.get()
                    .load(recipe.image)
                    .fit()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView);

            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            txtIngredients = (TextView) itemView.findViewById(R.id.txtIngredients);
            txtDirections = (TextView) itemView.findViewById(R.id.txtDirections);
            this.recipeAdapter = adapter;

        }

        @Override
        public void onClick(View v) {
            //get item that was clicked
            int item = getLayoutPosition();
            //open new activity
            Intent myIntent;
            myIntent = new Intent(v.getContext(),DetailActivity.class);
            v.getContext().startActivity(myIntent);
        }
    }

    //constructor for recipe adapter
    public RecipeAdapter(Context context, LinkedList<String> recipe) {
        mInflator = LayoutInflater.from(context);
        this.recipe = recipe;
    }

    //constructor that initializes the ViewHolder
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View recipeItemView = mInflator.inflate(R.layout.row_recipe, parent, false);

       return new RecipeViewHolder(recipeItemView, this);
    }

    //connect data to the view holder
    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int i) {
        String current = recipe.get(i);
    }

    //hold the data in the adapter
    public RecipeAdapter(List<Recipe> recipeList) {
        this.recipe = recipe;
    }
    //return the size of the recipe list
    @Override
    public int getItemCount() {
        return recipe.size();
    }


}
