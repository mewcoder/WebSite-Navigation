package com.zen.navigation.domain;

public class Site {
    private int wid;
    private String name;
    private String url;
    private String description;
    private int category;
    private int liked;//点赞数
    private boolean  state;//状态

    public int getWid() {
        return wid;
    }

    @Override
    public String toString() {
        return "Site{" +
                "wid=" + wid +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", liked=" + liked +
                ", state=" + state +
                '}';
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
