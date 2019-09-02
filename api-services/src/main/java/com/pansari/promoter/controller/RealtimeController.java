package com.pansari.promoter.controller;

import com.pansari.promoter.exceptions.UserNotFoundException;
import com.pansari.promoter.model.LocationReadingDto;
import com.pansari.promoter.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

@Controller
@RequestMapping("/realtime")
public class RealtimeController {

    private static final SimpleDateFormat formatHH = new SimpleDateFormat("HH");

    private static final Logger logger = Logger.getLogger(RealtimeController.class.getName());

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/location",
            method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity addReading(@RequestBody LocationReadingDto locationReadingDto) {
        formatHH.setTimeZone(TimeZone.getTimeZone("IST"));
        int HH = Integer.parseInt(formatHH.format(new Date()));
        //Only between 7:00 AM and 10:00 PM
        if (HH >= 7 && HH <= 22) {
            logger.info(locationReadingDto.getUserid() + "," + locationReadingDto.getLatitude() + "," +
                    locationReadingDto.getLongitude() + "," + locationReadingDto.getReceived());
            locationService.addReading(locationReadingDto.getUserid(), locationReadingDto.getLatitude(),
                    locationReadingDto.getLongitude(), locationReadingDto.getReceived());
        }
        else
        {
            logger.warning("Incorrect timing for a location reading");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getlocationreadings",
            method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity addReading(@RequestParam int userid, @RequestParam String datestamp) {
        datestamp=datestamp.replaceAll("^\"|\"$", "");
        return new ResponseEntity(locationService.getLocationReadingsByUserIdAndDate(userid, datestamp), HttpStatus.OK);
    }
}
