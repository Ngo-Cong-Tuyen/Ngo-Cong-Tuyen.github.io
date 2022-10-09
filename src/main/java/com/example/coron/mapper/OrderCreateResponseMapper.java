package com.example.coron.mapper;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderCreateResponseMapper {
    private Integer code;
    private String code_message_value;
    private OrderData data;
    private String message;
    private String message_display;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class OrderData implements Serializable {
        private String order_code;
        private String sort_code;
        private String trans_type;
        private String ward_encode;
        private String district_encode;
        private Fee fee;
        private Integer total_fee;
        private String expected_delivery_time;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Fee implements Serializable {
        private Integer main_service;
        private Integer insurance;
        private Integer station_do;
        private Integer station_pu;
        private Integer returnv;
        private Integer r2s;
        private Integer coupon;
    }
}
