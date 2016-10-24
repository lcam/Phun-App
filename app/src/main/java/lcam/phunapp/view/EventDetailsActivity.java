package lcam.phunapp.view;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lcam.phunapp.R;

public class EventDetailsActivity extends AppCompatActivity{

    String image;
    String date;
    String title;
    String description;
    ImageView imageView;
    TextView dateView;
    TextView titleView;
    TextView descriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        date = getIntent().getStringExtra("date");
        dateView = (TextView) findViewById(R.id.date);
        dateView.setText(date);

        title = getIntent().getStringExtra("title");
        titleView = (TextView) findViewById(R.id.title);
        titleView.setText(title);

        description = getIntent().getStringExtra("description");
        descriptionView = (TextView) findViewById(R.id.description);
        descriptionView.setText(description);

        image = getIntent().getStringExtra("image");
        imageView = (ImageView) findViewById(R.id.image);

        // Load image from url using Picasso
        Picasso.with(this)
                .load(image)
                .centerCrop()
                .fit()
                .into(imageView);
    }
}
