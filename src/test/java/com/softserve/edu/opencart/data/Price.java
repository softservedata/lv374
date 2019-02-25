package com.softserve.edu.opencart.data;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Price {

    private final static BigDecimal EURO_COURSE = new BigDecimal(0.78460002);
    private final static BigDecimal POUND_COURSE = new BigDecimal(0.61250001);
    private static DecimalFormat format = new DecimalFormat();

    public static BigDecimal getPrice(String price) {
        Matcher matcher = Pattern.compile("\\d+\\.\\d{1,2}").matcher(price);
        matcher.find();
        return new BigDecimal(matcher.group(0)).setScale(2, BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal getExpectedEURO(BigDecimal usd){
        return usd.multiply(EURO_COURSE).setScale(2, BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal getExpectedPOUND(BigDecimal usd){
        return usd.multiply(POUND_COURSE).setScale(2, BigDecimal.ROUND_DOWN);
    }

}
