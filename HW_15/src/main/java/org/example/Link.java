package org.example;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Link {

    int id;
    String title;

    @SerializedName("is_new")
    boolean isNew;

    String preview;
    int count;

    @SerializedName("price_min")
    PriceMin priceMin;

    String type;
    String url;

    @SerializedName("source_urls")
    SourceUrls sourceUrls;

}
