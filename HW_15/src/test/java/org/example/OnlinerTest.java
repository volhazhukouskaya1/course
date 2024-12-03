package org.example;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class OnlinerTest {

    // Проверка того, что все значения amount больше 0
    @Test
    public void onlinerCatalogTestMinPrice() {
        String body =
                given()
                        .when()
                        .log().all()
                        .get("https://catalog.onliner.by/sdapi/catalog.api/navigation/elements/9/groups")
                        .then()
                        //.log().all()
                        .statusCode(200)
                        .extract().body().asString();

        Gson gson = new Gson();
        Type list = new TypeToken<List<Group>>() {
        }.getType();
        List<Group> catalogItems = gson.fromJson(body, list);

        for (Group group : catalogItems) {
            assertNotNull(group);
            for (Link link : group.getLinks()) {
                  try {
                    double value = Double.parseDouble(link.getPriceMin().amount);
                    System.out.println(value);
                    assertTrue( value >= 0, "Значение price_min:amount больше 0");
                  }
                  catch (NullPointerException e) {
                      e.getMessage();
                  }
            }

        }
    }




}
