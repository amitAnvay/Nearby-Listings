package mytime.amit.com.mytimedemo.model;

/**
 * Created by Amit_Gupta on 3/22/16.
 */
public class Deal {

    public String photo_url;
    public String yelp_rating_image_url;
    public String name;
    public String service_name;
    public long min_price;
    public long  max_price;

//    @SerializedName("yelp_rating")
    public long mytime_rating;

    public boolean on_sale;
    public boolean instant_confirmation;
    public Location location;
   // Location location;


}




