package com.pansari.promoter.salesmodule;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.pansari.promoter.R;
import com.pansari.promoter.data.PrefManager;
import com.pansari.promoter.models.SalesPostRequestObj;
import com.pansari.promoter.utils.AppConstants;
import com.pansari.promoter.utils.AppUtils;
import com.pansari.promoter.utils.BaseActivity;
import com.pansari.promoter.utils.CustomEdittext;

import java.util.ArrayList;
import java.util.Calendar;

import androidx.annotation.Nullable;

public class SalesPageOne extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, PageOneView {

    private Spinner spinner;
    private ImageView dateBtn, timeBtn;
    private EditText date_edt;
    private EditText time_edt;
    private EditText stock_not_avail_edt;
    private EditText stock_short_edt;
    private ProgressDialog progressDialog;
    private ZonesController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sales_screen_one);
        controller = new ZonesController(this);
        getApplicationContext().registerComponentCallbacks(this);
        initViews();
        controller.getZones();
//        setZones();
    }

    private void setZones() {
        ArrayList<String> zoneList = new ArrayList<>();
        zoneList.add("Select zone");
        zoneList.add("NORTH-DELHI");
        zoneList.add("EAST-DELHI");
        zoneList.add("WEST-DELHI");
        zoneList.add("SOUTH-DELHI");

        ZoneAdapter adapter = new ZoneAdapter(zoneList, this);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void initViews() {
        spinner = findViewById(R.id.zone_spinner);
        dateBtn = findViewById(R.id.date_click);
        timeBtn = findViewById(R.id.time_picker);

        CustomEdittext stock_not_avail = (CustomEdittext) findViewById(R.id.stock_not_available);
        stock_not_avail_edt = stock_not_avail.getEditText();

        CustomEdittext stock_short = findViewById(R.id.stock_short);
        stock_short_edt = stock_short.getEditText();

        CustomEdittext dateArea = findViewById(R.id.date_created);
        date_edt = dateArea.getEditText();
        date_edt.setFocusable(false);
        date_edt.setFocusableInTouchMode(false);
        date_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDatePicker();
            }
        });

        CustomEdittext timeArea = findViewById(R.id.time);
        time_edt = timeArea.getEditText();
        time_edt.setFocusable(false);
        time_edt.setFocusableInTouchMode(false);
        time_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTimePicer();
            }
        });

        dateBtn.setOnClickListener(this);
        timeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.date_click:
                setDatePicker();
                break;
            case R.id.date_created:
                setDatePicker();
                break;
            case R.id.time_picker:
                setTimePicer();
                break;
        }
    }

    String selectedDate, selectedTime;

    private void setTimePicer() {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                time_edt.setText(selectedHour + ":" + selectedMinute);
                selectedTime = selectedHour + ":" + selectedMinute;
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();

    }

    private void setDatePicker() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        int monthDisplay = month + 1;
                        String date = year + "-";
                        if (monthDisplay <= 9) {
                            date = date + "0" + monthDisplay + "-";
                        } else {
                            date = date + monthDisplay + "-";
                        }
                        if (dayOfMonth <= 9) {
                            date = date + "0" + dayOfMonth;
                        } else {
                            date = date + dayOfMonth;
                        }
                        date_edt.setText(date);
                        selectedDate = date;
                    }
                }, mYear, mMonth, mDay);
//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    String zoneSelected;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                zoneSelected = null;
                break;
            default:
                zoneSelected = (String) parent.getAdapter().getItem(position);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onNextClick(View v) {
        if (AppUtils.isEmptyString(selectedDate)) {
            AppUtils.showToast(this, "Please select date");
            return;
        }
        if (AppUtils.isEmptyString(selectedTime)) {
            AppUtils.showToast(this, "Please select completion time");
            return;
        }

        if (zoneSelected == null) {
            AlertDialog dialog = AppUtils.showDialog(this, "Alert", "Please select one zone", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        } else {

            //create object for post data
            SalesPostRequestObj postRequestObj = new SalesPostRequestObj();
            postRequestObj.setUserId(Integer.parseInt(new PrefManager(this).getUserId()));
            postRequestObj.setStockShort(!AppUtils.isEmptyString(
                    stock_short_edt.getText().toString()) ? stock_short_edt.getText().toString() : "");
            postRequestObj.setStockNotAvailable(!AppUtils.isEmptyString(
                    stock_not_avail_edt.getText().toString()) ? stock_not_avail_edt.getText().toString() : "");
//            postRequestObj.setCreated(System.currentTimeMillis());
            postRequestObj.setSelectedDate(selectedDate);
            postRequestObj.setZone(zoneSelected);

            Intent salesTeo = new Intent(this, SalesPageTwo.class);
            salesTeo.putExtra(AppConstants.ZONE_SELECTED, zoneSelected);
            salesTeo.putExtra(AppConstants.SALES_DATA, postRequestObj);
            startActivityForResult(salesTeo, 222);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 222 && resultCode == 222) {
            this.finish();
        }
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public void zonesRecieved(ArrayList<String> zoneList) {
        if (zoneList.size() > 0) {

            String def_zone = "--- select zone ---";
            zoneList.add(0, def_zone);

            ZoneAdapter adapter = new ZoneAdapter(zoneList, this);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }

    }

    @Override
    public void onFailure() {
        AppUtils.showToast(this, "no data found");
    }

    @Override
    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = AppUtils.createProgressMultipleCalls(this);
        }
    }

    @Override
    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
