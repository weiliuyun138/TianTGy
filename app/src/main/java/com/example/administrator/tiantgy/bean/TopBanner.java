package com.example.administrator.tiantgy.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/6/23.
 */
public class TopBanner  implements Serializable{

    /**
     * page_url : http://huodong.fruitday.com/sale/cherry618/appall.html?
     * price : 0
     * photo : http://cdn.fruitday.com/images/2015-06-18/1434599288_pic.jpg
     * description :
     * target_id : 0
     * position : 1
     * title : 618樱桃全仓
     * type : 6
     */
    private String page_url;
    private String price;
    private String photo;
    private String description;
    private String target_id;
    private String position;
    private String title;
    private String type;

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTarget_id(String target_id) {
        this.target_id = target_id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPage_url() {
        return page_url;
    }

    public String getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getTarget_id() {
        return target_id;
    }

    public String getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
}
