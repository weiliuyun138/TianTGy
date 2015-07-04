package com.example.administrator.tiantgy.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/6/28.
 */
public class CategoryCommon implements Serializable {

    /**
     * ename : 时令最新鲜/品鲜无时差/品质鲜果
     * is_hot : 0
     * name : 全部鲜果
     * photo : http://cdn.fruitday.com/images/2014-07-02/1404297307_classphoto.png
     * id : 40
     * class_photo : http://cdn.fruitday.com/images/2015-04-30/1430360743_class_photo.jpg
     * sub_level : [{"ename":"","is_hot":"0","parent_id":"40","name":"西梅","photo":"","step":"2","id":"207","class_photo":"http://cdn.fruitday.com/images/2015-06-18/2d3e299252a11178d055ae943741f619.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"樱桃","photo":"","step":"2","id":"135","class_photo":"http://cdn.fruitday.com/images/2015-06-15/34e289229b0df6953854aca64ca390fc.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"奇异果","photo":"","step":"2","id":"133","class_photo":"http://cdn.fruitday.com/images/2015-06-15/f669bb427d14eb8a0944c9a9f7558ef3.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"橙子","photo":"","step":"2","id":"144","class_photo":"http://cdn.fruitday.com/images/2015-06-15/e86a511bacd85a1a4655c311ecfa29de.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"苹果","photo":"http://cdn.fruitday.com/images/2015-06-15/ba61a5d1d0ec51427878d93ba4212bca.jpg","step":"2","id":"131","class_photo":"http://cdn.fruitday.com/images/2015-06-15/5056c78225bc4e7e524993d73e171c5e.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"香蕉","photo":"","step":"2","id":"143","class_photo":"http://cdn.fruitday.com/images/2015-06-15/e5fdd01cbae7646ba863e8461636ed93.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"芒果","photo":"","step":"2","id":"145","class_photo":"http://cdn.fruitday.com/images/2015-06-15/1ba649912bae5e3de9a5d710e530eb52.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"凤梨","photo":"","step":"2","id":"142","class_photo":"http://cdn.fruitday.com/images/2015-06-15/6dcd5db0b07d6a20167cfa1bf721fee1.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"西瓜","photo":"","step":"2","id":"148","class_photo":"http://cdn.fruitday.com/images/2015-06-15/cc96e5417feeb75598ec2567635f0482.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"牛油果","photo":"","step":"2","id":"141","class_photo":"http://cdn.fruitday.com/images/2015-06-15/2d90cc05148e89a20a4109050adb9c97.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"甜瓜","photo":"","step":"2","id":"152","class_photo":"http://cdn.fruitday.com/images/2015-06-15/962057a500ffcd485a1f3f71b9965648.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"柠檬","photo":"","step":"2","id":"140","class_photo":"http://cdn.fruitday.com/images/2015-06-15/ced4f4d52fa0a8c40343a5b3af88089b.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"莲雾","photo":"","step":"2","id":"146","class_photo":"http://cdn.fruitday.com/images/2015-06-15/20074e7bbd1d22ef158d83b16fc4a6a8.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"梨","photo":"","step":"2","id":"139","class_photo":"http://cdn.fruitday.com/images/2015-06-15/8466da6967e1a8d75ab1a4ffc3705884.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"提子","photo":"","step":"2","id":"138","class_photo":"http://cdn.fruitday.com/images/2015-06-15/c66a4625acd1af6b55992f973cf6cf55.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"木瓜","photo":"","step":"2","id":"151","class_photo":"http://cdn.fruitday.com/images/2015-06-15/67e09e286efa05c89d36b6b503a17027.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"芭乐","photo":"","step":"2","id":"149","class_photo":"http://cdn.fruitday.com/images/2015-06-15/9777b349867c6bf772e2eff18166c93d.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"火龙果","photo":"","step":"2","id":"137","class_photo":"http://cdn.fruitday.com/images/2015-06-15/cc004809ace5875243f0feee38d7fe44.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"蓝莓","photo":"","step":"2","id":"136","class_photo":"http://cdn.fruitday.com/images/2015-06-15/a72d266d61e3be744e03754fd137ef91.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"榴莲","photo":"","step":"2","id":"134","class_photo":"http://cdn.fruitday.com/images/2015-06-15/36acfe4c0a2b00bc4ed539df522bb87c.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"荔枝","photo":"","step":"2","id":"153","class_photo":"http://cdn.fruitday.com/images/2015-06-15/f1d6bf28eb3926ac25d6e512633e5be1.jpg"},{"ename":"","is_hot":"0","parent_id":"40","name":"杨梅","photo":"","step":"2","id":"150","class_photo":"http://cdn.fruitday.com/images/2015-06-15/29059f9d137709305cbc04c73211310a.jpg"},{"ename":"","is_hot":"1","name":"全部","photo":"","id":"40","class_photo":"http://cdn.fruitday.com/sale/images/gengd.jpg"}]
     */
    private String ename;
    private String is_hot;
    private String name;
    private String photo;
    private String id;
    private String class_photo;
    private List<CategorySub_level> sub_level;

    public List<CategorySub_level> getSub_level() {
        return sub_level;
    }

    public void setSub_level(List<CategorySub_level> sub_level) {
        this.sub_level = sub_level;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setIs_hot(String is_hot) {
        this.is_hot = is_hot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClass_photo(String class_photo) {
        this.class_photo = class_photo;
    }



    public String getEname() {
        return ename;
    }

    public String getIs_hot() {
        return is_hot;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getId() {
        return id;
    }

    public String getClass_photo() {
        return class_photo;
    }



}
