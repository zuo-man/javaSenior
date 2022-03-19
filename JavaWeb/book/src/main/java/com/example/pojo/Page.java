package com.example.pojo;

import java.util.List;

/**
 *  Page是分页的模型对象
 *  <T> 是具体的模块的javaBean类
 */
public class Page<T> {

    public static final Integer PAGE_SIZE = 4;      //定义全局常量，  每页显示4个数据
                                                    //常量不需要GetSet方法

    private Integer pageNo;  //当前页码

    private Integer pageTotal;  //总页码

    private Integer pageSize = PAGE_SIZE;  //当前页显示数量

    private Integer pageTotalCount;  //总记录数

    private List<T> items;  //当前页数据

    private String url;  //分页条的请求地址

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        /* 数据边界的有效检查  输入跳转的页码小于1，就跳转到第一页。输入跳转的页码大于总页码，跳转到最后一页 */
        if(pageNo < 1){
            pageNo = 1;
        }
        if (pageNo > pageTotal){
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }
    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getPageTotalCount() {
        return pageTotalCount;
    }
    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }
    public List<T> getItems() {
        return items;
    }
    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
