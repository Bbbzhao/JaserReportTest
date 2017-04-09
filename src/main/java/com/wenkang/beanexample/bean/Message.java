package com.wenkang.beanexample.bean;

import java.util.Date;

/**
 * Created by wenka on 2017/4/7.
 */
public class Message
{
    private int id;
    private String username;
    private String outgo;
    private Date time;
    private double price;
    private String remark;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getOutgo()
    {
        return outgo;
    }

    public void setOutgo(String outgo)
    {
        this.outgo = outgo;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}
