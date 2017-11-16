package com.jnhouse.app.bean;

import java.util.Date;

public class SupTemplate {
    private Integer id;

    private String menu_title;

    private Integer menu_level;

    private Integer is_delete;

    private Date updated_time;

    private Date created_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenu_title() {
        return menu_title;
    }

    public void setMenu_title(String menu_title) {
        this.menu_title = menu_title == null ? null : menu_title.trim();
    }

    public Integer getMenu_level() {
        return menu_level;
    }

    public void setMenu_level(Integer menu_level) {
        this.menu_level = menu_level;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public Date getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(Date updated_time) {
        this.updated_time = updated_time;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }
}