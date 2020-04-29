package com.demo.ranklist;

public class RankListBean {
    /**
     * 名称
     */
    private String Name = "";
    /**
     * 积分
     */
    private int Integral = 0;
    /**
     * 照片URL
     */
    private String PhotoUrl = "";
    /**
     * 排名
     */
    private int Ranking = 0;

    public RankListBean(String name, int integral, String photoUrl, int ranking) {
        Name = name;
        Integral = integral;
        PhotoUrl = photoUrl;
        Ranking = ranking;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIntegral() {
        return Integral;
    }

    public void setIntegral(int integral) {
        Integral = integral;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public int getRanking() {
        return Ranking;
    }

    public void setRanking(int ranking) {
        Ranking = ranking;
    }
}
