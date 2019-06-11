package com.dreamfactory.novax.model;

public class HomeMenu {

    private int imgMenuImage;
    private String firstText, secondText;

    public HomeMenu(int imgMenuImage, String firstText, String secondText) {
        this.imgMenuImage = imgMenuImage;
        this.firstText = firstText;
        this.secondText = secondText;
    }

    public HomeMenu() {
    }

    public int getImgMenuImage() {
        return imgMenuImage;
    }

    public void setImgMenuImage(int imgMenuImage) {
        this.imgMenuImage = imgMenuImage;
    }

    public String getFirstText() {
        return firstText;
    }

    public void setFirstText(String firstText) {
        this.firstText = firstText;
    }

    public String getSecondText() {
        return secondText;
    }

    public void setSecondText(String secondText) {
        this.secondText = secondText;
    }
}
