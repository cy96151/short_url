package com.cy.shorturl.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 链接信息
 *
 * @author: caoyi
 */
@TableName("url_info")
public class UrlInfo extends Model<UrlInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 链接编号
     */
    @TableId(value = "ID",type = IdType.AUTO)
    private Long id;

    /**
     * 链接
     */
    @TableField("url")
    private String url;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UrlInfo(){
    }

    public UrlInfo(String url){
        this.url = url;
        this.createTime = new Date();
    }

    @Override
    public String toString() {
        return "UrlInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
