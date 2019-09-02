package com.pansari.promoter.utils;

import android.app.Dialog;
import android.content.Context;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.pansari.promoter.R;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;


public class CustomAlertDialog extends Dialog {
    private DisplayMetrics displayDimen;
    private TextView title1;

    public EditText getQunatityEdt() {
        return qunatityEdt;
    }

    private EditText qunatityEdt;

    public Spinner getCategorySpinnner() {
        return categorySpinnner;
    }

    public Spinner getSubCatSpinner() {
        return subCatSpinner;
    }

    public Spinner getItemNameSpinner() {
        return itemNameSpinner;
    }

    private TextView title2;
    private Spinner categorySpinnner, subCatSpinner, itemNameSpinner;

    public DisplayMetrics getDisplayDimen() {
        return displayDimen;
    }

    public void setDisplayDimen(DisplayMetrics displayDimen) {
        this.displayDimen = displayDimen;
    }

    public TextView getTitle1() {
        return title1;
    }

    public void setTitle1(TextView title1) {
        this.title1 = title1;
    }

    public TextView getTitle2() {
        return title2;
    }

    public void setTitle2(TextView title2) {
        this.title2 = title2;
    }


    public AppButton getOk_btn() {
        return ok_btn;
    }

    public void setOk_btn(AppButton ok_btn) {
        this.ok_btn = ok_btn;
    }

    public AppButton getCloseBtn() {
        return closeBtn;
    }

    public void setCloseBtn(AppButton closeBtn) {
        this.closeBtn = closeBtn;
    }

    private AppButton ok_btn, closeBtn;

    public CustomAlertDialog(Context context) {
        super(context, R.style.Theme_AppCompat_Light_Dialog);

        displayDimen = AppUtils.getDeviceMetrics(context);

        setDialogProperties();
        initViews();
    }

    private void initViews() {
        title1 = findViewById(R.id.dialog_title1);
        title2 = findViewById(R.id.dialog_title2);
        ok_btn = findViewById(R.id.yes_logout);
        closeBtn = findViewById(R.id.close_logout);
        categorySpinnner = findViewById(R.id.category_spinner);
        subCatSpinner = findViewById(R.id.category_sub_spinner);
        itemNameSpinner = findViewById(R.id.name_spinner);
        CustomEdittext qEdt = findViewById(R.id.quantity);
        qunatityEdt = qEdt.getEditText();
        qunatityEdt.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    private void setDialogProperties() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_top_icon);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.dialog_top_icon);
        setCancelable(false);
        getWindow().getAttributes().width = (int) (0.8f * displayDimen.widthPixels);
        getWindow().getAttributes().height = RelativeLayout.LayoutParams.MATCH_PARENT;
    }

    public CustomAlertDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, R.style.Theme_AppCompat_Light_Dialog);

        displayDimen = AppUtils.getDeviceMetrics(context);

        setDialogProperties();
        initViews();
    }

    public void setTitle(String title) {
        setTitle(title);
    }

    public void setMessage(String title) {
        setMessage(title);
    }


    @Override
    public void show() {
        super.show();
    }
}
