package com.pansari.promoter.controller;

import com.pansari.promoter.dto.AttendanceApiDto;
import com.pansari.promoter.entity.Attendance;
import com.pansari.promoter.entity.Item;
import com.pansari.promoter.exceptions.CustomException;
import com.pansari.promoter.model.ItemCreateDto;
import com.pansari.promoter.service.AttendanceService;
import com.pansari.promoter.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    private static final Logger logger = Logger.getLogger(AttendanceController.class.getName());


    @Autowired
    AttendanceService attendanceService;


    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity createItems(@RequestBody AttendanceApiDto attendanceApiDto) throws CustomException {
        if (attendanceApiDto.getAttendancevalue().isEmpty() || attendanceApiDto.getDatestamp().isEmpty()) {
            logger.severe("Attendance parameters are invalid");
            return new ResponseEntity<CustomException>(new CustomException("Attendance parameters are invalid"), HttpStatus.BAD_REQUEST);
        }
        Attendance attendance = null;
        try {
            attendance = attendanceService.createAttendance(attendanceApiDto.getDatestamp(), attendanceApiDto.getAttendancevalue(), attendanceApiDto.getUserid());
            logger.info("attendance with name - " + attendance.getUser().getName() + " created with id - " + attendance.getAttendanceId());
        } catch (CustomException e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(e, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<CustomException>(new CustomException(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Attendance>(attendance, HttpStatus.OK);
    }
}
