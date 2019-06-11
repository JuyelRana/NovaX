package com.dreamfactory.novax.model;

public class SocialRating {

    private int tradersImage,startradersImage;
    private String tradersName, startradersName,tradersRating,checking;



    public SocialRating() {
    }

    public SocialRating(int tradersImage, String tradersName, String tradersRating,String checking) {
        this.tradersImage = tradersImage;
        this.tradersName = tradersName;
        this.tradersRating = tradersRating;
        this.checking=checking;
    }

    public SocialRating(int startradersImage, String startradersName) {
        this.startradersImage = startradersImage;
        this.startradersName = startradersName;
    }

    public int getTradersImage() {
        return tradersImage;
    }

    public int getStartradersImage() {
        return startradersImage;
    }

    public String getTradersName() {
        return tradersName;
    }

    public String getStartradersName() {
        return startradersName;
    }

    public String getTradersRating() {
        return tradersRating;
    }

    public String getChecking() {
        return checking;
    }
}
