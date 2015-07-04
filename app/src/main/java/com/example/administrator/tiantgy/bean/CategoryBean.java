package com.example.administrator.tiantgy.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/6/28.
 */
public class CategoryBean implements Serializable {
    private List<CategoryHot> hot;
    private List<CategoryCommon> common;

    public List<CategoryHot> getHot() {
        return hot;
    }

    public void setHot(List<CategoryHot> hot) {
        this.hot = hot;
    }

    public List<CategoryCommon> getCommon() {
        return common;
    }

    public void setCommon(List<CategoryCommon> common) {
        this.common = common;
    }
}
