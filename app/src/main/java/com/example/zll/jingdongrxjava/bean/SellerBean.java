package com.example.zll.jingdongrxjava.bean;

import java.io.Serializable;

/**
 * Created by zll on 2018/5/17.
 */

public class SellerBean  implements Serializable {
    private String sellerName;
    private String sellerid;
    private boolean selected;//商家是否选中

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }
}
