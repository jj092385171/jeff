package com.campingmapping.team4.spring.utils.config;

public class MyConstants {

    public final static String JWT_COOKIE_NAME = "R9SBUCVDWF";
    public final static String JWT_REFRESH_COOKIE_NAME = "4M5N6Q8R9S";
    public final static Long ACCESS_TOKEN_VALIDATION_SECOND = 60L * 60 * 24 * 1000; // 1 Day
    public final static Long REFRESH_TOKEN_VALIDATION_SECOND = 60L * 60 * 24 * 1 * 1000; // 1 Day
    public final static Long REMEMBER_REFRESH_TOKEN_VALIDATION_SECOND = 60L * 60 * 24 * 30 * 1000; // 30 Day
}