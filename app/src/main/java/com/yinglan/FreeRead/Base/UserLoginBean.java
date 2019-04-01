package com.yinglan.FreeRead.Base;

import java.io.Serializable;

/**
 * Created by ${AUTHOR} on 2019/3/31 0031
 * Function: ${Function}
 */
public class UserLoginBean implements Serializable {


    /**
     * user : {"UserId":1021,"NickName":"18289596200","Avatar":"","FullName":"","PhoneNumber":"18289596200","Email":"duyang3651@126.com","Password":"MTIzNDU2","Balance":0}
     * sign : {"IsSign":true,"SeriesSignDays":2,"TotalSignDays":2}
     * code : 200
     * result : Success
     * msg : 登录成功
     */

    private UserBean user;
    private SignBean sign;
    private int code;
    private String result;
    private String msg;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public SignBean getSign() {
        return sign;
    }

    public void setSign(SignBean sign) {
        this.sign = sign;
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

    public static class UserBean {
        /**
         * UserId : 1021
         * NickName : 18289596200
         * Avatar :
         * FullName :
         * PhoneNumber : 18289596200
         * Email : duyang3651@126.com
         * Password : MTIzNDU2
         * Balance : 0
         */

        private int UserId;
        private String NickName;
        private String Avatar;
        private String FullName;
        private String PhoneNumber;
        private String Email;
        private String Password;
        private int Balance;

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public String getAvatar() {
            return Avatar;
        }

        public void setAvatar(String Avatar) {
            this.Avatar = Avatar;
        }

        public String getFullName() {
            return FullName;
        }

        public void setFullName(String FullName) {
            this.FullName = FullName;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = PhoneNumber;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        public int getBalance() {
            return Balance;
        }

        public void setBalance(int Balance) {
            this.Balance = Balance;
        }
    }

    public static class SignBean {
        /**
         * IsSign : true
         * SeriesSignDays : 2
         * TotalSignDays : 2
         */

        private boolean IsSign;
        private int SeriesSignDays;
        private int TotalSignDays;

        public boolean getisIsSign() {
            return IsSign;
        }

        public void setIsSign(boolean IsSign) {
            this.IsSign = IsSign;
        }

        public int getSeriesSignDays() {
            return SeriesSignDays;
        }

        public void setSeriesSignDays(int SeriesSignDays) {
            this.SeriesSignDays = SeriesSignDays;
        }

        public int getTotalSignDays() {
            return TotalSignDays;
        }

        public void setTotalSignDays(int TotalSignDays) {
            this.TotalSignDays = TotalSignDays;
        }
    }
}
