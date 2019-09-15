package com.pansari.promoter.converter;

import com.pansari.promoter.dto.AttendanceDto;
import com.pansari.promoter.entity.Sales;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SalesToAttendanceDtoConverter {

    private static final SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");

    public Set<AttendanceDto> convertToAttendanceDto(List<Sales> sales)
    {
        Set<AttendanceDto> attendances= new HashSet<AttendanceDto>();

        AttendanceDto attendance=null;
        for(Sales sale: sales)
        {
            attendance = new AttendanceDto();
            attendance.setName(sale.getUser().getName());
            Date selectedDate = null;
            try {
                selectedDate = formatter.parse(sale.getSelectedDate());
            } catch (ParseException e) {
                selectedDate = new Date();
            }
            attendance.setDate(selectedDate);
            String storeName=sale.getStore().getStoreName();
            if(storeName.equalsIgnoreCase("WEEKLY OFF"))
            {
                attendance.setAttendance(sale.getStore().getStoreName());
            }
            else{
                attendance.setAttendance("PRESENT");
            }
            attendances.add(attendance);
        }
        return attendances;
    }


    public Set<AttendanceDto> convertToAttendanceDtoForRows(List<Object[]> rows)
    {
        Set<AttendanceDto> attendances= new HashSet<AttendanceDto>();
        AttendanceDto attendance=null;

        for(Object[] row : rows){
            attendance = new AttendanceDto();
            attendance.setName(row[0].toString());
            Date selectedDate = null;
            try {
                selectedDate = formatter.parse(row[1].toString());
            } catch (ParseException e) {
                selectedDate = new Date();
            }
            attendance.setDate(selectedDate);
            String storeName=row[2].toString();
            if(storeName.equalsIgnoreCase("WEEKLY OFF"))
            {
                attendance.setAttendance(storeName);
            }
            else{
                attendance.setAttendance("PRESENT");
            }
            attendances.add(attendance);
        }
        return attendances;
    }
}
