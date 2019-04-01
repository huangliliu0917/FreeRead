package com.yinglan.FreeRead.Base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${AUTHOR} on 2019/4/1 0001
 * Function: ${Function}
 */
public class CategoryBean implements Serializable {


    /**
     * list : [{"Id":1,"Name":"推荐"},{"Id":2,"Name":"热点"},{"Id":3,"Name":"娱乐"},{"Id":4,"Name":"体育"},{"Id":5,"Name":"视频"}]
     * code : 200
     * result : Success
     * msg : 成功读取新闻栏目数据
     */

    private int code;
    private String result;
    private String msg;
    private List<ListBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * Id : 1
         * Name : 推荐
         */

        private int Id;
        private String Name;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }
    }
}
