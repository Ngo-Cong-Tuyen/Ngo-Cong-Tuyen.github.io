package com.example.coron.mapper;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderCreateRequestMapper implements Serializable {
    private int payment_type_id;
    private String note;
    private String required_note;
    private String return_phone;
    private String client_order_code;
    private String to_name;
    private String to_phone;
    private String to_address;
    private String to_ward_code;
    private Integer to_district_id;
    private String cod_amount;
    private String content;
    private Integer weight;
    private Integer length;
    private Integer width;
    private Integer height;
    private String pick_station_id;
    private String deliver_station_id;
    private String insurance_value;
    private Integer service_type_id;
    private String coupon;
    private int[] pick_shift;
    private List<Item> items;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Item implements Serializable {
        private String name;
        private String code;
        private Integer quantity;
    }

}





