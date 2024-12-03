package org.example;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SourceUrls {

    @SerializedName("catalog.schema")
    String catalogSchema;

    @SerializedName("catalog.schema.products")
    String catalogSchemaProducts;

    @SerializedName("catalog.schema.facets")
    String catalogSchemaFacets;

    @SerializedName("catalog.schema.second.offers")
    String catalogSchemaSecondOffers;




}
