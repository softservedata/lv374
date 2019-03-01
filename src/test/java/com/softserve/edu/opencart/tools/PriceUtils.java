package com.softserve.edu.opencart.tools;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PriceUtils {

    public static final Logger logger = LoggerFactory.getLogger(PriceUtils.class);

    private static final BigDecimal EURO_COURSE = new BigDecimal(0.78460002);
    private static final BigDecimal POUND_COURSE = new BigDecimal(0.61250001);
    private static final int SCALE = 2;
    private static final BigDecimal TAX = new BigDecimal(0.2);
    //

    private PriceUtils(){}

    /**
     * This method convert String which contains price in format (xxx.xx) into BigDecimal
     * Where x is some digit
     * @param price String which contains price in format (xxx.xx)
     * @return
     */
    @Step("Convert String to BigDecimal")
    public static BigDecimal getPrice(String price) {
        Matcher matcher = Pattern.compile("\\d+\\.\\d{1,2}").matcher(price.replaceAll(",",""));
        matcher.find();
        logger.debug("Found price = "+new BigDecimal(matcher.group(0)).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN));
        return new BigDecimal(matcher.group(0)).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN);
    }

    /**
     * Convert price from usd into euro
     * @param usd
     * @param withTax is price displayed with tax (true/false)?
     * @return price in euro
     */
    @Step("Convert USD to EURO")
    public static BigDecimal getExpectedEURO(BigDecimal usd, boolean withTax){
        logger.debug("Price usd = "+usd);
        if(withTax){
            BigDecimal usdTax=(usd.multiply(TAX)).add(new BigDecimal(SCALE).add(usd));
            logger.debug("Price with tax = "+usdTax);
            logger.debug("Price euro = "+usdTax.multiply(EURO_COURSE).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN));
            return usdTax.multiply(EURO_COURSE).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN);
        }else {
            logger.debug("Price euro = "+usd.multiply(EURO_COURSE).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN));
            return usd.multiply(EURO_COURSE).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN);
        }
    }

    /**
     * Convert price from usd into pound sterling
     * @param usd
     * @param withTax is price displayed with tax (true/false)?
     * @return price in pound sterling
     */
    @Step("Convert USD to Pound Sterling")
    public static BigDecimal getExpectedPOUND(BigDecimal usd, boolean withTax){
        logger.debug("Price usd = "+usd);
        if(withTax){
            BigDecimal usdTax=(usd.multiply(TAX)).add(new BigDecimal(SCALE).add(usd));
            logger.debug("Price with tax = "+usdTax);
            logger.debug("Price pound = "+usdTax.multiply(POUND_COURSE).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN));
            return usdTax.multiply(POUND_COURSE).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN);
        }else {
            logger.debug("Price pound = "+usd.multiply(POUND_COURSE).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN));
            return usd.multiply(POUND_COURSE).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN);
        }
    }

    /**
     * Get currency symbol from string
     * @param text String which contains currency symbol
     * @return currency symbol
     */
    public static String getCurrencySymbol(String text){
        Matcher matcher = Pattern.compile("[\\$£€]{1}").matcher(text);
        matcher.find();
        logger.info("Currency symbol is "+matcher.group(0));
        return matcher.group(0);
    }

}
