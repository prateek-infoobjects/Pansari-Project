package com.pansari.promoter.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SalesItemsRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("answer")
    @Expose
    private String answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
