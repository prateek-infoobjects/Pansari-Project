package com.pansari.promoter.config;

import com.pansari.promoter.dto.AttendanceDto;
import com.pansari.promoter.entity.Sales;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

@Component
public class PDFCreator {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public byte[] createAttendancePdf(String sheetName, List<AttendanceDto> attendance) {
        XLSXBuilder xLSXBuilder = new XLSXBuilder().
                startSheet(sheetName);
        //create header
        xLSXBuilder = xLSXBuilder.                                        // then go row by row
                // empty row
                startRow().                                          // header row
                setRowTitleHeight().
                setRowThickTopBorder().
                setRowThickBottomBorder().
                addBoldTextCenterAlignedColumn("Name").
                addBoldTextCenterAlignedColumn("Date").
                addBoldTextCenterAlignedColumn("Attendance");

        //add rows
        for (AttendanceDto attendanceDto : attendance) {
            xLSXBuilder = xLSXBuilder.startRow().                                          // rows with records (usually within a loop)
                    addTextLeftAlignedColumn(attendanceDto.getName()).
                    addTextLeftAlignedColumn(formatter.format(attendanceDto.getDate())).
                    addTextLeftAlignedColumn(attendanceDto.getAttendance());
        }
        xLSXBuilder=xLSXBuilder.setAutoSizeColumn(1).
                setAutoSizeColumn(2).
                setAutoSizeColumn(3);

        byte[] report = xLSXBuilder.build();

        return report;
    }
    
    
    public byte[] createShortStockPdf(String sheetName, List<Sales> sales) {
        XLSXBuilder xLSXBuilder = new XLSXBuilder().
                startSheet(sheetName);
        //create header
        xLSXBuilder = xLSXBuilder.                                        // then go row by row
                // empty row
                startRow().                                          // header row
                setRowTitleHeight().
                setRowThickTopBorder().
                setRowThickBottomBorder().
                addBoldTextCenterAlignedColumn("Date").
                addBoldTextCenterAlignedColumn("Promoter ID").
                addBoldTextCenterAlignedColumn("Promoter Name").
                addBoldTextCenterAlignedColumn("Zone").
                addBoldTextCenterAlignedColumn("Store name").
                addBoldTextCenterAlignedColumn("Stock Not Available").
                addBoldTextCenterAlignedColumn("Stock Short");

        //add rows
        for (Sales sale : sales) {
            xLSXBuilder = xLSXBuilder.startRow().                                          // rows with records (usually within a loop)
                    addTextLeftAlignedColumn(sale.getSelectedDate()).
                    addTextLeftAlignedColumn(Integer.toString(sale.getUser().getUserid())).
                    addTextLeftAlignedColumn(sale.getUser().getName()).
                    addTextLeftAlignedColumn(sale.getStore().getZone()).
                    addTextLeftAlignedColumn(sale.getStore().getStoreName()).
                    addTextLeftAlignedColumn(sale.getStockNotAvailable()).
                    addTextLeftAlignedColumn(sale.getStockShort())
                   ;
        }
        
//        xLSXBuilder=xLSXBuilder.setAutoSizeColumn(1).
//                setAutoSizeColumn(2).
//                setAutoSizeColumn(3).
//                setAutoSizeColumn(4).
//                setAutoSizeColumn(5).
//                setAutoSizeColumn(6).
//                setAutoSizeColumn(7);

        byte[] report = xLSXBuilder.build();

        return report;
    }
}
