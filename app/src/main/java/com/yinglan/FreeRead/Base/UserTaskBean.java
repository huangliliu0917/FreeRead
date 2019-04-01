package com.yinglan.FreeRead.Base;

import java.util.List;

/**
 * Created by ${AUTHOR} on 2019/4/1 0001
 * Function: ${Function}
 */
public class UserTaskBean {


    /**
     * list : [{"IsFinish":false,"IsDraw":true,"TaskId":2,"TaskName":"新手邀请好友有奖","TaskIcon":"1","Description":"首次邀请好友，奖励32个金币","RewardAmount":32,"RewardUnit":"金币"},{"IsFinish":false,"IsDraw":true,"TaskId":4,"TaskName":"阅读文章、视频有奖","TaskIcon":"","Description":"阅读文章、视频满半个小时，奖励50金币","RewardAmount":50,"RewardUnit":"金币"}]
     * taskedcount : 0
     * totalincome : 0
     * code : 200
     * result : Success
     * msg : 成功读取任务数据
     */

    private int taskedcount;
    private int totalincome;
    private int code;
    private String result;
    private String msg;
    private List<ListBean> list;

    public int getTaskedcount() {
        return taskedcount;
    }

    public void setTaskedcount(int taskedcount) {
        this.taskedcount = taskedcount;
    }

    public int getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(int totalincome) {
        this.totalincome = totalincome;
    }

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
         * IsFinish : false
         * IsDraw : true
         * TaskId : 2
         * TaskName : 新手邀请好友有奖
         * TaskIcon : 1
         * Description : 首次邀请好友，奖励32个金币
         * RewardAmount : 32
         * RewardUnit : 金币
         */

        private boolean IsFinish;
        private boolean IsDraw;
        private int TaskId;
        private String TaskName;
        private String TaskIcon;
        private String Description;
        private int RewardAmount;
        private String RewardUnit;

        public boolean isIsFinish() {
            return IsFinish;
        }

        public void setIsFinish(boolean IsFinish) {
            this.IsFinish = IsFinish;
        }

        public boolean isIsDraw() {
            return IsDraw;
        }

        public void setIsDraw(boolean IsDraw) {
            this.IsDraw = IsDraw;
        }

        public int getTaskId() {
            return TaskId;
        }

        public void setTaskId(int TaskId) {
            this.TaskId = TaskId;
        }

        public String getTaskName() {
            return TaskName;
        }

        public void setTaskName(String TaskName) {
            this.TaskName = TaskName;
        }

        public String getTaskIcon() {
            return TaskIcon;
        }

        public void setTaskIcon(String TaskIcon) {
            this.TaskIcon = TaskIcon;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public int getRewardAmount() {
            return RewardAmount;
        }

        public void setRewardAmount(int RewardAmount) {
            this.RewardAmount = RewardAmount;
        }

        public String getRewardUnit() {
            return RewardUnit;
        }

        public void setRewardUnit(String RewardUnit) {
            this.RewardUnit = RewardUnit;
        }
    }
}
