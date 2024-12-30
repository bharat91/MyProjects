package com.learning.timeconverter.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Component
public class DateConversionUtil {

    public String getHumanReadableDateTime(Long timeMs){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM yyyy hh:mm:ss a z");
        return sdf.format(timeMs);
    }

    public String getHumanReadableDateTimeInDifferentTZ(String fromTZ,Long fromTimeMs, String toTZ){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM yyyy hh:mm:ss a z" );
        String currTime =  sdf.format(fromTimeMs);

        sdf.setTimeZone(TimeZone.getTimeZone(toTZ));
        String currDiffTime = sdf.format(fromTimeMs);

        return "Current time in "+currTime+" is this time in "+currDiffTime;
    }
}
