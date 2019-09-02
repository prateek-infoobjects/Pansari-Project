package com.pansari.promoter.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;
import com.pansari.promoter.R;

import androidx.annotation.Nullable;


public class CustomEdittext extends TextInputLayout {
    @Nullable
    @Override
    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    EditText editText;

    public CustomEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomEdittext, 0, 0);

        LinearLayout.LayoutParams textInputLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(textInputLayoutParams);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);

        editText = new EditText(context);
//        editText.setHintTextColor(getResources().getColor(R.color.dark_text_color));
        editText.setId(a.getInteger(R.styleable.CustomEdittext_id, 0));
        editText.setLayoutParams(params);
        editText.setTextSize(16);
        editText.setText(a.getString(R.styleable.CustomEdittext_edittext_text));
        editText.setHint(a.getString(R.styleable.CustomEdittext_hint));
        editText.setMaxLines(a.getInteger(R.styleable.CustomEdittext_num_lines, 1));

        this.addView(editText);

    }

    public CustomEdittext(Context context, AttributeSet attrs, int def) {
        super(context, attrs, def);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomEdittext, def, 0);

        LinearLayout.LayoutParams textInputLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(textInputLayoutParams);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                100);

        EditText editText = new EditText(context);
//        editText.setHintTextColor(getResources().getColor(R.color.dark_text_color));
        editText.setId(a.getInt(R.styleable.CustomEdittext_id, 0));
        editText.setLayoutParams(params);
        editText.setText(a.getString(R.styleable.CustomEdittext_edittext_text));
        editText.setHint(a.getString(R.styleable.CustomEdittext_hint));

        this.addView(editText);
    }

    public CustomEdittext(Context context) {
        super(context);
    }
}
