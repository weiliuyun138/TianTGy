package com.example.administrator.tiantgy.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/7/3.
 */
public class FruitfoodBaseBean implements Serializable {
    private List<Top> top;
    private List<Main> main;

    public List<Top> getTop() {
        return top;
    }

    public void setTop(List<Top> top) {
        this.top = top;
    }

    public List<Main> getMain() {
        return main;
    }

    public void setMain(List<Main> main) {
        this.main = main;
    }
}
