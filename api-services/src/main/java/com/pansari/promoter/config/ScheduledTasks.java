package com.pansari.promoter.config;

import com.pansari.promoter.controller.RealtimeController;
import com.pansari.promoter.converter.SalesToAttendanceDtoConverter;
import com.pansari.promoter.dto.AttendanceDto;
import com.pansari.promoter.entity.Sales;
import com.pansari.promoter.service.SalesService;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.logging.Logger;

@Component
public class ScheduledTasks {


    private static final Logger logger = Logger.getLogger(RealtimeController.class.getName());

    private static final SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");


    @Autowired
    SalesService salesService;

    @Autowired
    PDFCreator pdfCreator;

    @Autowired
    SalesToAttendanceDtoConverter salesToAttendanceDtoConverter;

    @Autowired
    EmailSender emailSender;



//    @Scheduled(fixedRate = 600000)
    public void reportCurrentTime() throws MessagingException {
        Set<String> dates = new HashSet<>();
        Date date = new Date();

        for(int i = 1; i<=7; i++)
        {
            dates.add(formatter.format(date));
            System.out.println(formatter.format(date));
            date = DateUtils.addDays(new Date(),-i);
        }


        List<Object[]> rows = salesService.getSalesByDatesNatively(dates);
//        List<Sales> sales = salesService.getSalesByDates();
        Set<AttendanceDto> attendanceDtos = salesToAttendanceDtoConverter.convertToAttendanceDtoForRows(rows);
        byte[] report = pdfCreator.createAttendancePdf("Attendance on " + formatter.format(new Date()), attendanceDtos);
        String fileName = formatter.format(new Date())+".xlsx";
        writeByte(report, fileName);
        emailSender.sendEmail(fileName);
    }

    // Method which write the bytes into a file
    static void writeByte(byte[] bytes, String fileName) {
        File file = new File(fileName);
        try {

            // Initialize a pointer
            // in file using OutputStream
            OutputStream
                    os
                    = new FileOutputStream(file);

            // Starts writing the bytes in it
            os.write(bytes);
            System.out.println("Successfully"
                    + " report created");

            // Close the file
            os.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }


    public static void main(String[] args) {

        Set<String> dates = new HashSet<>();
        Date date = new Date();

        for(int i = 1; i<=7; i++)
        {
            dates.add(formatter.format(date));
            System.out.println(formatter.format(date));
            date = DateUtils.addDays(new Date(),-i);
        }

        System.exit(0);

        byte[] report = new XLSXBuilder().
                startSheet("Dream cars").                            // start with sheet
                startRow().                                          // then go row by row
                setRowTitleHeight().                                 // set row style, add borders and so on
                addTitleTextColumn("Dream cars").                    // add columns
                startRow().                                          // another row
                setRowTitleHeight().                                 // row styling
                setRowThinBottomBorder().
                addBoldTextLeftAlignedColumn("Dreamed By:").
                addTextLeftAlignedColumn("John Seaman").
                startRow().                                          // empty row
                startRow().                                          // header row
                setRowTitleHeight().
                setRowThickTopBorder().
                setRowThickBottomBorder().
                addBoldTextCenterAlignedColumn("Type").
                addBoldTextCenterAlignedColumn("Color").
                addBoldTextCenterAlignedColumn("Reason").
                startRow().                                          // rows with records (usually within a loop)
                addTextLeftAlignedColumn("Ferrari").
                addTextLeftAlignedColumn("Green").
                addTextLeftAlignedColumn("It looks nice").
                startRow().
                addTextLeftAlignedColumn("Lamborgini").
                addTextLeftAlignedColumn("Yellow").
                addTextLeftAlignedColumn("It's fast enough").
                startRow().
                addTextLeftAlignedColumn("Bugatti").
                addTextLeftAlignedColumn("Blue").
                addTextLeftAlignedColumn("Price is awesome").
                startRow().
                setRowThinTopBorder().
                startRow().
                startRow().                                          // footer row
                addTextLeftAlignedColumn("This is just a footer and I use it instead of 'Lorem ipsum dolor...'").
                setColumnSize(0, "XXXXXXXXXXXXX".length()).          // setting up column sizes at the end of the sheet
                setAutoSizeColumn(1).
                setAutoSizeColumn(2).
                build();
//        writeByte(report);
        System.exit(0);


        Workbook workbook = createAttendanceReport();

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            EmailSender.sendEmail(fileLocation);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static Workbook createAttendanceReport() {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Persons");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Age");
        headerCell.setCellStyle(headerStyle);

        return workbook;
    }
}
