package mytime.amit.com.mytimedemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import mytime.amit.com.mytimedemo.R;
import mytime.amit.com.mytimedemo.model.Deal;
import mytime.amit.com.mytimedemo.util.Util;

/**
 * Created by Amit_Gupta on 3/22/16.
 */
public class DealListAdapter extends RecyclerView.Adapter<DealListAdapter.ViewHolder> {

    Context mContext;
    ArrayList<Deal> deals;

    public DealListAdapter(Context context, ArrayList<Deal> deals){
        mContext = context;
        this.deals = deals;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.deal_photo)
        ImageView photo;

        @Bind(R.id.deal_name)
        TextView name;

        @Bind(R.id.service_name)
        TextView serviceName;

        @Bind(R.id.distance)
        TextView distance;

        @Bind(R.id.lightning_bolt)
        ImageView lightningBolt;

        @Bind(R.id.next_apointment)
        TextView nextAppointment;

        @Bind(R.id.yelp_star_rating)
        ImageView yelpRating;

        @Bind(R.id.yelp_logo)
        ImageView yelpLogo;

        @Bind(R.id.sale_icon)
        ImageView saleButton;

        @Bind(R.id.price)
        TextView price;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    @Override
    public DealListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.deal_list_card_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DealListAdapter.ViewHolder holder, int position) {
        Deal deal = deals.get(position);
        Picasso.with(mContext)
                .load(deal.photo_url)
                .placeholder(R.drawable.placeholder)   // optional
                .into(holder.photo);

        Picasso.with(mContext)
                .load(deal.yelp_rating_image_url)
                .into(holder.yelpRating);

        holder.name.setText(deal.name);
        holder.serviceName.setText(deal.service_name);
        holder.price.setText("$"+deal.min_price +" - $"+deal.max_price);
        String miles = Util.distance(deal.location.getLat(), deal.location.getLat(), 31.069028, -116.252016, "M");
        holder.distance.setText(miles+ " mi away");
        holder.nextAppointment.setText("Next appt");
//        if(deal.instant_confirmation == false)
//        holder.lightningBolt.setVisibility(View.INVISIBLE);
//        if(deal.on_sale == false)
//            holder.saleButton.setVisibility(View.INVISIBLE);

    }

    @Override
    public int getItemCount() {
        return deals.size();
    }

}
