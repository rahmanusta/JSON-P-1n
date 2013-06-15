package com.kodcu;

import java.math.BigInteger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;


public class App 
{
    public static void main(String[] args) {

JsonObject jsonObject1 =
        Json.createObjectBuilder()
                .add("name", "Fikret")
                .add("surname", "Savaş")
                .add("age", 25)
        .build();

    System.out.println("jsonObject1 -> "+jsonObject1+"\n\n");


JsonArray jsonArray1= Json.createArrayBuilder()
        .add("A") // String
        .add(5)   // int
        .add(6.3) // double
        .add(false)  // boolean
        .add(new BigInteger("30"))  // Big(Integer) | (Decimal)
        .add(jsonObject1)  // JsonValue
        .build();

    System.out.println("jsonArray1 -> "+jsonArray1+"\n\n");


JsonArray jsonArray2=Json.createArrayBuilder()
        .add("Emin").add("Şahin").build();

    System.out.println("jsonArray2 -> "+jsonArray2+"\n\n");

JsonObject jsonObject2 = Json.createObjectBuilder()
        .add("name", jsonArray2)
        .add("surname", "Demir")
        .build();

    System.out.println("jsonObject2 -> "+jsonObject2+"\n\n");

JsonObject jsonObject3 =
    Json.createObjectBuilder()
        .add("name", "Ersin")
        .add("surname", "Çetinkaya")
        .add("age", 25)
        .add("address",
              Json.createObjectBuilder()
                  .add("city", "Bursa")
                  .add("country", "Türkiye")
                  .add("zipCode", "33444"))
        .add("phones",
                      Json.createArrayBuilder()
                          .add("234234242")
                          .add("345345354"))
        .build();

    System.out.println("jsonObject3 -> "+jsonObject3+"\n\n");

}
}
