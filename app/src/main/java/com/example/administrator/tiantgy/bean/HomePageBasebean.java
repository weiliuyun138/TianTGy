package com.example.administrator.tiantgy.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/6/23.
 */
public class HomePageBasebean implements Serializable {


    private List<Rotation> rotation;
    private List<Banner> banner;
    private List<TopBanner> top_banner;
    private List<MobileProductList> mobile_product_list;
    private List<MixProductBanner> mix_product_banner;
    private List<HorizontalProductBanner> horizontal_product_banner;
    private String is_store_exist;
    private List<QiangxianProductList> qiangxian_product_list;

    public List<Banner> getBanner() {
        return banner;
    }

    public void setBanner(List<Banner> banner) {
        this.banner = banner;
    }

    public List<TopBanner> getTop_banner() {
        return top_banner;
    }

    public void setTop_banner(List<TopBanner> top_banner) {
        this.top_banner = top_banner;
    }

    public List<MobileProductList> getMobile_product_list() {
        return mobile_product_list;
    }

    public void setMobile_product_list(List<MobileProductList> mobile_product_list) {
        this.mobile_product_list = mobile_product_list;
    }

    public List<MixProductBanner> getMix_product_banner() {
        return mix_product_banner;
    }

    public void setMix_product_banner(List<MixProductBanner> mix_product_banner) {
        this.mix_product_banner = mix_product_banner;
    }

    public List<HorizontalProductBanner> getHorizontal_product_banner() {
        return horizontal_product_banner;
    }

    public void setHorizontal_product_banner(List<HorizontalProductBanner> horizontal_product_banner) {
        this.horizontal_product_banner = horizontal_product_banner;
    }

    public String getIs_store_exist() {
        return is_store_exist;
    }

    public void setIs_store_exist(String is_store_exist) {
        this.is_store_exist = is_store_exist;
    }

    public List<QiangxianProductList> getQiangxian_product_list() {
        return qiangxian_product_list;
    }

    public void setQiangxian_product_list(List<QiangxianProductList> qiangxian_product_list) {
        this.qiangxian_product_list = qiangxian_product_list;
    }

    public List<Rotation> getRotation() {
        return rotation;
    }

    public void setRotation(List<Rotation> rotation) {
        this.rotation = rotation;
    }
}
