package com.pansari.promoter.salesmodule;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.pansari.promoter.LoginActivity;
import com.pansari.promoter.R;
import com.pansari.promoter.SalesItemsAccessDataModule.DatabaseHolder;
import com.pansari.promoter.SalesItemsAccessDataModule.InsertItemsTask;
import com.pansari.promoter.SalesItemsAccessDataModule.ItemsNamesSpinnerAdapter;
import com.pansari.promoter.SalesItemsAccessDataModule.SalesItemsDao;
import com.pansari.promoter.data.PrefManager;
import com.pansari.promoter.models.SalesItemsRequest;
import com.pansari.promoter.models.SalesPostRequestObj;
import com.pansari.promoter.utils.AppConstants;
import com.pansari.promoter.utils.AppUtils;
import com.pansari.promoter.utils.BaseActivity;
import com.pansari.promoter.utils.CustomAlertDialog;
import com.pansari.promoter.utils.CustomEdittext;
import com.pansari.promoter.utils.PansariApplication;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.annotation.Nullable;

public class SalesPageTwo extends BaseActivity implements SalesViewModel {

    private String selected_zone;
    private SalesController controller;
    private ImageView timeBtn;
    private Spinner store_spinner;
    private TextView zone_title;
    private LinearLayout viewContainer;
    private ProgressDialog progressDialog;
    private SalesPostRequestObj salesDataObj;
    private EditText remarks_edt;
    private EditText other_sales_edt;
    private EditText time_edt;
    private String store_out_time;
    private int storeId = -1;
    private boolean itemsAvailable;
    private PrefManager prefManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sales_screen_two);
        prefManager = new PrefManager(this);
        initViews();
        selected_zone = getIntent().getStringExtra(AppConstants.ZONE_SELECTED);
        salesDataObj = (SalesPostRequestObj) getIntent().getSerializableExtra(AppConstants.SALES_DATA);
        controller = new SalesController(this);
        controller.getStoresList(selected_zone);
        controller.getSalesItmsList();

//        createSalesItemsStatic();

        zone_title.setText(selected_zone.replace("-", " "));
    }

    List<SalesItems> dummyList = new ArrayList<>();

    private void createSalesItemsStatic() {

        for (int i = 0; i < 10; i++) {
            SalesItems items = new SalesItems();
            items.setItemId(i);
            items.setItemName("iteration1 " + 1);
            items.setPrimaryCategory("one");
            if (i < 5)
                items.setSecondaryCategory("one_five");
            else
                items.setSecondaryCategory("two_five");
            dummyList.add(items);
        }
        for (int i = 10; i < 20; i++) {
            SalesItems items = new SalesItems();
            items.setItemId(i);
            items.setItemName("iteration2 " + 1);
            items.setPrimaryCategory("two");
            if (i < 16)
                items.setSecondaryCategory("one_five");
            else
                items.setSecondaryCategory("two_five");
            dummyList.add(items);
        }
        for (int i = 20; i < 30; i++) {
            SalesItems items = new SalesItems();
            items.setItemId(i);
            items.setItemName("iteration3 " + 1);
            items.setPrimaryCategory("three");
            if (i < 25)
                items.setSecondaryCategory("one_five");
            else
                items.setSecondaryCategory("two_five");
            dummyList.add(items);
        }
        InsertItemsTask task = new InsertItemsTask(this, dummyList);
        task.execute();
    }

    public void itemsInserted() {
//        AppUtils.showToast(this, "inserted .....");
        itemsAvailable = true;
    }

    private void initViews() {
        store_spinner = findViewById(R.id.store_spinner);
        zone_title = findViewById(R.id.zone_title);
        viewContainer = findViewById(R.id.container_view);
        timeBtn = findViewById(R.id.time_picker);
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTimePicer();
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

        CustomEdittext remarks = findViewById(R.id.remarks);
        remarks_edt = remarks.getEditText();

        CustomEdittext other_sales = findViewById(R.id.other_sales);
        other_sales_edt = other_sales.getEditText();
//        viewContainer.setLayoutManager(new LinearLayoutManager(this));
//        viewContainer.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    private void setTimePicer() {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                time_edt.setText(selectedHour + ":" + selectedMinute);
                store_out_time = selectedHour + ":" + selectedMinute;
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();

    }

    @Override
    public void storeListSuccess(List<StoresList> list) {
        if (list != null && list.size() > 0) {
            StoresList item1 = new StoresList();
            item1.setStoreId(-1);
            item1.setStoreName("--choose store--");
            item1.setZone(selected_zone);

            list.add(0, item1);

            StoresAdapter adapter = new StoresAdapter(list, this);
            store_spinner.setAdapter(adapter);
            store_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (parent.getAdapter().getItemId(position) != -1) {
                        storeId = ((StoresList) parent.getAdapter().getItem(position)).getStoreId();
                    } else {
                        storeId = -1;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    storeId = -1;
                }
            });
        }
    }

    @Override
    public void onFailure() {
        AppUtils.showToast(this, "no data found");
    }

    ArrayList<TextView> salesEdittextList = new ArrayList<>();

    @Override
    public void itemsListReceived(List<SalesItems> body) {
        if (body.size() > 0) {
            //create custom entry for each item
            Log.d("Items received ", body.size() + "");
            InsertItemsTask task = new InsertItemsTask(this, body);
            task.execute();
//            if (viewContainer.getChildCount() > 0) {
//                viewContainer.removeAllViews();
//            }
//            for (SalesItems items : body) {
//                View view = LayoutInflater.from(this).inflate(R.layout.store_items_layout, null);
//                TextView label = view.findViewById(R.id.item_label);
//                EditText answerView = view.findViewById(R.id.item_answer);
//                answerView.setTag(items.getItemId() + "");
//
//                salesEdittextList.add(answerView);
//
//                label.setText(items.getTemName());
//                viewContainer.addView(view);
//            }
        }
        hideProgressDialog();
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

    ArrayList<SalesItemsRequest> ansList;

    public void onDoneClick(View v) {
        if (storeId == -1) {
            AppUtils.showToast(this, "Plesae select a store name");
            return;
        }
        if (!AppUtils.isValid(store_out_time)) {
            AppUtils.showToast(this, "Plesae set store out time");
            return;
        }

        salesDataObj.setStore(storeId);
        salesDataObj.setStoreOutTime(store_out_time);

        salesDataObj.setOtherRemarks(remarks_edt.getText().toString());
        salesDataObj.setOtherSale(other_sales_edt.getText().toString());


        ansList = new ArrayList<>();
        // container has items
        if (salesEdittextList.size() > 0) {

            int childCount = salesEdittextList.size();

            for (int i = 0; i < childCount; i++) {
                TextView itemEdt = salesEdittextList.get(i);
                if (AppUtils.isValid(itemEdt.getText().toString())) {
                    SalesItemsRequest answer = new SalesItemsRequest();
                    answer.setId((String) itemEdt.getTag());
                    answer.setAnswer(itemEdt.getText().toString());

                    ansList.add(answer);
                }


            }

            salesDataObj.setItems(ansList);
            controller.postSalesData(salesDataObj);
        } else {
            AppUtils.showToast(this, "Plesae add items.");
        }
    }

    @Override
    public void failedToPostData(String message) {
        Dialog dialog = AppUtils.showDialog(this, "Failed", message,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    @Override
    public void salesDataPostedSuccessfuly(String message) {
        Dialog dialog = AppUtils.showDialog(this, "Done", message,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        prefManager.setUserAsLogin(false);
                        prefManager.saveUserId("");

//                        mTracking = false;
//                        gpsService.stopTracking();
//                        unbindService(serviceConnection);
                        ((PansariApplication) SalesPageTwo.this.getApplicationContext()).stopConnection();

                        Intent login = new Intent(SalesPageTwo.this, LoginActivity.class);
                        login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(login);
                        SalesPageTwo.this.finish();
//                        setResult(222);

                    }
                });
        dialog.show();
    }

    String Selcategory = "", selSubCategory = "";

    public void addNewItem(View v) {
        if (!itemsAvailable) {
            return;
        }
        final CustomAlertDialog alertDialog = new CustomAlertDialog(this);

        String[] arrCategory = DatabaseHolder.getAppDatabase(this).userDao().getAllCategories();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrCategory);
        alertDialog.getCategorySpinnner().setAdapter(adapter);
        alertDialog.getCategorySpinnner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Selcategory = (String) parent.getAdapter().getItem(position);
                String[] arrSubCategory = DatabaseHolder.getAppDatabase(SalesPageTwo.this).userDao().getSubCategories(Selcategory);
                ArrayAdapter adapter = new ArrayAdapter(SalesPageTwo.this, android.R.layout.simple_spinner_dropdown_item, arrSubCategory);
                alertDialog.getSubCatSpinner().setAdapter(adapter);

                itemToAddAndDisplay = null;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        alertDialog.getSubCatSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selSubCategory = (String) parent.getAdapter().getItem(position);
                List<SalesItems> arrItemNames = DatabaseHolder.getAppDatabase(SalesPageTwo.this).userDao()
                        .getItemNamesWithId(Selcategory, selSubCategory);
                ItemsNamesSpinnerAdapter adapter = new ItemsNamesSpinnerAdapter(SalesPageTwo.this,
                        arrItemNames);
                alertDialog.getItemNameSpinner().setAdapter(adapter);

                itemToAddAndDisplay = null;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        alertDialog.getItemNameSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SalesItems itemSelected = (SalesItems) parent.getAdapter().getItem(position);
                itemToAddAndDisplay = itemSelected;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        alertDialog.getOk_btn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = alertDialog.getQunatityEdt().getText().toString();
                if (AppUtils.isValid(val) && itemToAddAndDisplay != null) {
                    alertDialog.dismiss();
                    addItemToMainScreen(itemToAddAndDisplay, val);
                } else {
                    AlertDialog dia = AppUtils.showDialog(SalesPageTwo.this, "", "Please enter a valid quantity to add the item",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    dia.show();
                }

            }
        });
        alertDialog.getCloseBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private SalesItems itemToAddAndDisplay;
    private View viewToBeEdited;

    private void addItemToMainScreen(SalesItems items, String val) {
        final View view = LayoutInflater.from(this).inflate(R.layout.sales_item_display, null);
        TextView label = view.findViewById(R.id.item_label);
        TextView answerView = view.findViewById(R.id.item_answer);
        ImageView deleteBtn = view.findViewById(R.id.delete_entry);
        ImageView editBtn = view.findViewById(R.id.edit_entry);

        //adding val from above into items for easy access
        items.setQuantityValue(val);

        editBtn.setTag(items);
        answerView.setTag(items.getItemId() + "");
        view.setTag(items.getItemId() + "");

        salesEdittextList.add(answerView);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout l = (LinearLayout) v.getParent();
                viewContainer.removeView((RelativeLayout) l.getParent());
                View answerV = l.findViewById(R.id.item_answer);
                salesEdittextList.remove(answerV);
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // added tag as item name
                viewToBeEdited = view;
                editItemEntry((SalesItems) v.getTag());
            }
        });

        label.setText(items.getItemName());
        answerView.setText(val);
        viewContainer.addView(view);
    }

    ArrayList<String> itemsIdsList = new ArrayList<>();

    private void EditItemToMainScreen(SalesItems items, String val) {


        View view = viewToBeEdited;
        TextView label = view.findViewById(R.id.item_label);
        TextView answerView = view.findViewById(R.id.item_answer);
        ImageView deleteBtn = view.findViewById(R.id.delete_entry);
        ImageView editBtn = view.findViewById(R.id.edit_entry);

        //adding val from above into items for easy access
        items.setQuantityValue(val);

        editBtn.setTag(items);
        answerView.setTag(items.getItemId() + "");
        view.setTag(items.getItemId() + "");

//        salesEdittextList.add(answerView);

//        deleteBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LinearLayout l = (LinearLayout) v.getParent();
//                viewContainer.removeView((RelativeLayout) l.getParent());
//                View answerV = l.findViewById(R.id.item_answer);
//                salesEdittextList.remove(answerV);
//            }
//        });
//
//        editBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // added tag as item name
//                editItemEntry((SalesItems) v.getTag());
//            }
//        });

        label.setText(items.getItemName());
        answerView.setText(val);
//        viewContainer.addView(view);
    }

    private void editItemEntry(final SalesItems items) {
        final CustomAlertDialog alertDialog = new CustomAlertDialog(this);
        SalesItemsDao dao = DatabaseHolder.getAppDatabase(this).userDao();
        String[] arrCategory = dao.getAllCategories();
        String[] arrSecondary = dao.getAllSecondaryCategories();

        String subCategorySelected = items.getSecondaryCategory();// dao.getSecondaryCategory(itemName);
        String primarySelected = items.getPrimaryCategory();// dao.getPrimaryCategory(subCategorySelected, itemName);
        List<SalesItems> itemsList = dao.getItemNamesWithId(primarySelected, subCategorySelected);

        int indexPrimary = 0;
        for (int i = 0; i < arrCategory.length; i++) {
            if (arrCategory[i].equals(primarySelected)) {
                indexPrimary = i;
                break;
            }

        }

        int indexSecondary = 0;
        for (int i = 0; i < arrSecondary.length; i++) {
            if (arrSecondary[i].equals(subCategorySelected)) {
                indexSecondary = i;
                break;
            }

        }

        int indexItem = 0;
        for (int i = 0; i < itemsList.size(); i++) {
            if (itemsList.get(i).getItemName().equals(items.getItemName())) {
                indexItem = i;
                break;
            }

        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrCategory);
        alertDialog.getCategorySpinnner().setAdapter(adapter);
        alertDialog.getCategorySpinnner().setSelection(indexPrimary);
        alertDialog.getCategorySpinnner().setEnabled(false);

        ArrayAdapter adapterSec = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrSecondary);
        alertDialog.getSubCatSpinner().setAdapter(adapterSec);
        alertDialog.getSubCatSpinner().setSelection(indexSecondary);
        alertDialog.getSubCatSpinner().setEnabled(false);


        ItemsNamesSpinnerAdapter adapterItem = new ItemsNamesSpinnerAdapter(SalesPageTwo.this,
                itemsList);
        alertDialog.getItemNameSpinner().setAdapter(adapterItem);
        alertDialog.getItemNameSpinner().setSelection(indexItem);
        alertDialog.getItemNameSpinner().setEnabled(false);

        alertDialog.getQunatityEdt().setText(items.getQuantityValue());

        alertDialog.getOk_btn().getTv().setText("Edit");
        alertDialog.getOk_btn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = alertDialog.getQunatityEdt().getText().toString();
                if (AppUtils.isValid(val)) {
                    alertDialog.dismiss();
                    EditItemToMainScreen(items, val);
                } else {
                    AlertDialog dia = AppUtils.showDialog(SalesPageTwo.this, "", "Please enter a valid quantity to add the item",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    dia.show();
                }

            }
        });

        alertDialog.getCloseBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                viewToBeEdited = null;
            }
        });
        alertDialog.show();
    }
}
