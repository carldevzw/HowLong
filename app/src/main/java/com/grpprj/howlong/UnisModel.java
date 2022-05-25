package com.grpprj.howlong;

public class UnisModel {

    private String uniName, numOfCamps;
    private int uniLogo;


    public UnisModel(String uniName, String numOfCamps, int uniLogo) {
        this.uniName = uniName;
        this.numOfCamps = numOfCamps;
        this.uniLogo = uniLogo;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getNumOfCamps() {
        return numOfCamps;
    }

    public void setNumOfCamps(String numOfCamps) {
        this.numOfCamps = numOfCamps;
    }

    public int getUniLogo() {
        return uniLogo;
    }

    public void setUniLogo(int uniLogo) {
        this.uniLogo = uniLogo;
    }
}
