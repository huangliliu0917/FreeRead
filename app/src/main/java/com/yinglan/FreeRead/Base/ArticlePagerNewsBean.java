package com.yinglan.FreeRead.Base;

import java.util.List;

/**
 * Created by ${AUTHOR} on 2019/4/1 0001
 * Function: ${Function}
 */
public class ArticlePagerNewsBean {


    /**
     * list : [{"NewsId":1,"CategoryId":1,"ImgUrls":"http://5b0988e595225.cdn.sohucs.com/c_zoom,h_231/images/20190331/2e2a5db18cba4f3cb7abfb7b35db9d53.jpeg;http://5b0988e595225.cdn.sohucs.com/c_zoom,h_231/images/20190331/0788356572404284915cc85336409e6a.jpeg;http://5b0988e595225.cdn.sohucs.com/c_zoom,h_231/images/20190331/2096d204f3d6473c89b81bdd1001fb8f.jpeg","VideoUrl":"","Title":"中国对原产于美国的汽车及零部件继续暂停加征关税","BodyContent":"财政部网站3月31日消息，为落实中美两国元首阿根廷会晤共识，继续为中美经贸磋商创造良好氛围，根据《中华人民共和国对外贸易法》、《中华人民共和国进出口关税条例》等法律法规，经党中央、国务院批准，国务院关税税则委员会决定从2019年4月1日起，对原产于美国的汽车及零部件继续暂停加征关税。暂停加征关税措施截止时间另行通知。2018 年12月14日， 国务院关税税则委员会发布公告， 从2019年1月1日起， 对原产于美国的汽车及零部件暂停加征关税3个月。 今年3月美方宣布对2018年9月起加征关税的自华进口商品， 再次推迟提高加征关税税率， 在另行通知之前加征关税税率维持10 % 。对原产于美国的汽车及零部件继续暂停加征关税， 是中方对美方推迟提高税率措施的积极回应， 是为促进双方经贸磋商采取的实际举动。 我们希望， 美方与中方一道共同努力， 加紧磋商， 朝着终止贸易摩擦的目标作出切实努力。（ 原题为《 国务院关税税则委员会发布公告决定对原产于美国的汽车及零部件继续暂停加征关税》） ","Url ":"http: //www.sohu.com/a/305036053_260616?_f=index_chan08news_0","Author":"搜狐公众平台","CreateTime":"2019/4/1 星期一 2:41:40","FromSource":"搜狐新闻"}]
     * code : 200
     * result : Success
     * msg : 成功读取新闻数据
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
         * NewsId : 1
         * CategoryId : 1
         * ImgUrls : http://5b0988e595225.cdn.sohucs.com/c_zoom,h_231/images/20190331/2e2a5db18cba4f3cb7abfb7b35db9d53.jpeg;http://5b0988e595225.cdn.sohucs.com/c_zoom,h_231/images/20190331/0788356572404284915cc85336409e6a.jpeg;http://5b0988e595225.cdn.sohucs.com/c_zoom,h_231/images/20190331/2096d204f3d6473c89b81bdd1001fb8f.jpeg
         * VideoUrl :
         * Title : 中国对原产于美国的汽车及零部件继续暂停加征关税
         * BodyContent : 财政部网站3月31日消息，为落实中美两国元首阿根廷会晤共识，继续为中美经贸磋商创造良好氛围，根据《中华人民共和国对外贸易法》、《中华人民共和国进出口关税条例》等法律法规，经党中央、国务院批准，国务院关税税则委员会决定从2019年4月1日起，对原产于美国的汽车及零部件继续暂停加征关税。暂停加征关税措施截止时间另行通知。2018 年12月14日， 国务院关税税则委员会发布公告， 从2019年1月1日起， 对原产于美国的汽车及零部件暂停加征关税3个月。 今年3月美方宣布对2018年9月起加征关税的自华进口商品， 再次推迟提高加征关税税率， 在另行通知之前加征关税税率维持10 % 。对原产于美国的汽车及零部件继续暂停加征关税， 是中方对美方推迟提高税率措施的积极回应， 是为促进双方经贸磋商采取的实际举动。 我们希望， 美方与中方一道共同努力， 加紧磋商， 朝着终止贸易摩擦的目标作出切实努力。（ 原题为《 国务院关税税则委员会发布公告决定对原产于美国的汽车及零部件继续暂停加征关税》）
         * Url  : http: //www.sohu.com/a/305036053_260616?_f=index_chan08news_0
         * Author : 搜狐公众平台
         * CreateTime : 2019/4/1 星期一 2:41:40
         * FromSource : 搜狐新闻
         */

        private int NewsId;
        private int CategoryId;
        private String ImgUrls;
        private String VideoUrl;
        private String Title;
        private String BodyContent;
        private String Url;
        private String Author;
        private String CreateTime;
        private String FromSource;

        public int getNewsId() {
            return NewsId;
        }

        public void setNewsId(int NewsId) {
            this.NewsId = NewsId;
        }

        public int getCategoryId() {
            return CategoryId;
        }

        public void setCategoryId(int CategoryId) {
            this.CategoryId = CategoryId;
        }

        public String getImgUrls() {
            return ImgUrls;
        }

        public void setImgUrls(String ImgUrls) {
            this.ImgUrls = ImgUrls;
        }

        public String getVideoUrl() {
            return VideoUrl;
        }

        public void setVideoUrl(String VideoUrl) {
            this.VideoUrl = VideoUrl;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getBodyContent() {
            return BodyContent;
        }

        public void setBodyContent(String BodyContent) {
            this.BodyContent = BodyContent;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getAuthor() {
            return Author;
        }

        public void setAuthor(String Author) {
            this.Author = Author;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getFromSource() {
            return FromSource;
        }

        public void setFromSource(String FromSource) {
            this.FromSource = FromSource;
        }
    }
}
