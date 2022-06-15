package com.domain;

import java.util.List;

public class PageInfo<T> {
    private List<T> list;
    private int totalPage;
    private int totalCount;
    private int size;
    private int currentPage;
    private String info;



    public PageInfo() {
    }

    public PageInfo(List<T> list, int totalPage, int totalCount, int size, int currentPage) {
        this.list = list;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.size = size;
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getSize() {
        return size;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "list=" + list +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", size=" + size +
                ", currentPage=" + currentPage +
                ", info='" + info + '\'' +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}


