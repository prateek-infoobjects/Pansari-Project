package com.pansari.promoter.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.TimeZone;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testing {

    private static final Logger logger = Logger.getLogger(Testing.class.getName());
    //private static final Logger logger = LoggerFactory.getLogger(Testing.class);

    public static void x()
    {
        logger.info("1");
    }

    public static void main(String[] args) {


//        String mydata = "OAOBIDATAEXTRACT840A_20190301_200008.xml";
//        Pattern pattern = Pattern.compile("OAOBIDATAEXTRACT[0-9A-Za-z]+_([0-9A-Za-z]+).*");
//        Matcher matcher = pattern.matcher(mydata);
//        if (matcher.find())
//        {
//            System.out.println(matcher.group(1));
//        }
//        System.setProperty("java.util.logging.SimpleFormatter.format",
//                "%1$tc %2$s%n%4$s: %5$s%6$s%n");
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1tc %4$s %2$s: %5$s %n");
        logger.info("Hello");
        x();

        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));

    }
}
