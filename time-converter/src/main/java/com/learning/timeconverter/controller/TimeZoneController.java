package com.learning.timeconverter.controller;

import com.learning.timeconverter.utils.DateConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/timezone")
public class TimeZoneController {


    @Autowired
    DateConversionUtil dateConversionUtil;

    @GetMapping("")
    public String getCurrentTime(){
        return dateConversionUtil.getHumanReadableDateTime(new Date().getTime());
    }

    @GetMapping("/from/{from}/to/{to}")
    public String getTimeInAnotherTimezone(@PathVariable(name="from") String fromTime, @PathVariable(name="to") String toTime){
        return dateConversionUtil.getHumanReadableDateTimeInDifferentTZ(fromTime,new Date().getTime(),toTime);
    }


}
