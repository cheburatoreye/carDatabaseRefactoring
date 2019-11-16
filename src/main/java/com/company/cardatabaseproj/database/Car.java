package com.company.cardatabaseproj.database;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import java.io.Serializable;

@Builder
@Data
@JsonSerialize
@JsonDeserialize
public class Car implements Serializable {

     private String vin;
     private String number;
     private String mark;
     private String model;
     private String mileage;
     private String year;
     private String color;
     private String body;
     private String price;

     public Car(@JsonProperty("vin") String vin,@JsonProperty("number") String number,
                @JsonProperty("mark") String mark,@JsonProperty("model") String model,
                @JsonProperty("mileage") String mileage,@JsonProperty("year") String year,
                @JsonProperty("color") String color,@JsonProperty("body") String body,
                @JsonProperty("price") String price) {
          this.vin = vin;
          this.number = number;
          this.mark = mark;
          this.model = model;
          this.mileage = mileage;
          this.year = year;
          this.color = color;
          this.body = body;
          this.price = price;
     }
}
