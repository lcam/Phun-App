package lcam.phunapp.view;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lcam.phunapp.R;
import lcam.phunapp.model.Events;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsViewHolder> {

    private List<Events> mItems;
    private final Context mContext;

    public ItemsAdapter(Context context, List<Events> items) {
        mItems = items;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View itemView = inflater.inflate(R.layout.item_event, parent, false);

        // Return a new holder instance
        final ItemsViewHolder viewHolder = new ItemsViewHolder(itemView);
        viewHolder.mListener = new ItemsViewHolder.IMyViewHolderClicks() {
            @Override
            public void onEventCard(View callerCard) {
                final int position = viewHolder.getAdapterPosition();

                Intent intent = new Intent(callerCard.getContext(), EventDetailsActivity.class);
                intent.putExtra("image", mItems.get(position).getImage());
                intent.putExtra("date", mItems.get(position).getDate());
                intent.putExtra("title", mItems.get(position).getTitle());
                intent.putExtra("description", mItems.get(position).getDescription());
                callerCard.getContext().startActivity(intent);
            }
        };
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        Events event = mItems.get(position);

        TextView evTitle = holder.eventTitle;
        TextView evLocation = holder.eventLocation;
        TextView evDescription = holder.eventLocation;

        evTitle.setText(event.getTitle());
        evLocation.setText(event.getLocationline1());
        evDescription.setText(event.getDescription());

        String imageUrl = event.getImage();
        Picasso.with(holder.imageThumbnail.getContext())
                .load(imageUrl)
                .centerCrop()
                .fit()
                .into(holder.imageThumbnail);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
