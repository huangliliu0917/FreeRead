package com.yinglan.FreeRead.Base;

import android.graphics.drawable.Drawable;

/**
 * Created by ${AUTHOR} on 2019/3/26 0026
 * Function: ${Function}
 */
public class CardBean {

    private Drawable cardIcon;//银行卡图标
    private String cardType;//银行卡类型
    private String cardName;//银行卡名称
    private String cardId;//银行卡卡号

    public CardBean(Drawable cardIcon, String cardType, String cardName, String cardId) {
        this.cardIcon = cardIcon;
        this.cardType = cardType;
        this.cardName = cardName;
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Drawable getCardIcon() {
        return cardIcon;
    }

    public void setCardIcon(Drawable cardIcon) {
        this.cardIcon = cardIcon;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
