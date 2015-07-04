package com.example.administrator.tiantgy.bean;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/7/2.
 */
@Table
public class CategoryNewCate implements Serializable {
    /**
     * mobile_price : 0
     * volume : 4斤装
     * thum_photo : http://cdn.fruitday.com/product_pic/4153/1/1-180x180-4153-XSSPPRAX.jpg
     * price : 258
     * product_id : 4348
     * old_price : 288
     * price_id : 6356
     * photo : http://cdn.fruitday.com/product_pic/4153/1/1-370x370-4153-XSSPPRAX.jpg
     * id : 4348
     * stock : 0
     * product_name : 超大美国西北樱桃
     * product_no : 2150609103
     */
    private String mobile_price;
    private String volume;
    private String thum_photo;
    private String price;
    private String product_id;
    private String old_price;
    private String price_id;
    private String photo;
    @Id
    private String id;
    private String stock;
    private String product_name;
    private String product_no;

    public void setMobile_price(String mobile_price) {
        this.mobile_price = mobile_price;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setThum_photo(String thum_photo) {
        this.thum_photo = thum_photo;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setOld_price(String old_price) {
        this.old_price = old_price;
    }

    public void setPrice_id(String price_id) {
        this.price_id = price_id;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_no(String product_no) {
        this.product_no = product_no;
    }

    public String getMobile_price() {
        return mobile_price;
    }

    public String getVolume() {
        return volume;
    }

    public String getThum_photo() {
        return thum_photo;
    }

    public String getPrice() {
        return price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getOld_price() {
        return old_price;
    }

    public String getPrice_id() {
        return price_id;
    }

    public String getPhoto() {
        return photo;
    }

    public String getId() {
        return id;
    }

    public String getStock() {
        return stock;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_no() {
        return product_no;
    }
}
