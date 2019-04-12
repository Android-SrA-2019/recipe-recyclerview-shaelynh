package school.nbcc.reciperecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;

/**
 * Shaelyn Hooley
 * 04/12/19
 * Detail Activity
 * This assignment represents my own
 * work and is in accordance with the College
 * Academic Policy.
 */
public class DetailActivity extends AppCompatActivity {

    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Link textviews and imageviews to recipe details
        TextView name = (TextView) findViewById(R.id.txtName);
        name.setText(recipe.name);

        TextView description = (TextView) findViewById(R.id.txtDescription);
        description.setText(recipe.description);

        TextView directions = (TextView) findViewById(R.id.txtDescription);
        description.setText(recipe.directions);

        //get image
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.get()
                .load(recipe.image)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}
