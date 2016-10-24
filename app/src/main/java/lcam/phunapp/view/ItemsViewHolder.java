package lcam.phunapp.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import lcam.phunapp.R;

public class ItemsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView imageThumbnail;
    public TextView eventTitle;
    public TextView eventLocation;
    public TextView eventDescription;

    public IMyViewHolderClicks mListener;

    public ItemsViewHolder(View itemView) {
        super(itemView);
        imageThumbnail = (ImageView) itemView.findViewById(R.id.image_thumbnail);
        eventTitle = (TextView) itemView.findViewById(R.id.event_name);
        eventLocation = (TextView) itemView.findViewById(R.id.event_location);
        eventDescription = (TextView) itemView.findViewById(R.id.event_description);

        itemView.setOnClickListener(this); //open detail view for chosen task
    }

    @Override
    public void onClick(View view) {
        mListener.onEventCard(view);
    }

    public static interface IMyViewHolderClicks {
        public void onEventCard(View callerCard);
    }
}
