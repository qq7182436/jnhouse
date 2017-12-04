package com.jnhouse.app.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 员工表
 * @author lou
 *
 */
public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String username;

    private String passwd;

    private String email;

    private String mobile;

    private Integer is_delete;

    private Integer is_effect;

    private String code;

    private Byte user_type;

    private String qq_openid;

    private String sina_openid;

    private Integer logins;

    private Integer scores;

    private Integer sell_num;

    private Integer rent_num;

    private Integer last_login;

    private String active_str;

    private Integer active_rate;

    private Integer active_total;

    private Float order_weight;

    private Byte top_day;

    private Integer add_time;

    private Integer status;

    private Byte is_index;

    private String money;

    private Integer addsale;

    private Integer addrent;

    private Byte vip;

    private Integer vexation;

    private Integer company_id;

    private Integer area_id;

    private Integer store_id;

    private Integer e_accurate;

    private Integer e_satisfaction;

    private Integer e_specialty;

    private Integer integrate_id;

    private Integer recommend_num;

    private Integer publish_sum;

    private Integer refresh_num;

    private Boolean is_broker;

    private Boolean user_status;

    private Integer is_dz;

    private String broker_info;

    private String usernamebak;

    private Integer is_photoer;

    private Boolean regular;

    private Date regular_time;

    private Integer open_time;

    private Integer open_time_now;

    private Integer is_newhouse;

    private Integer newhouse_manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public Integer getIs_effect() {
        return is_effect;
    }

    public void setIs_effect(Integer is_effect) {
        this.is_effect = is_effect;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Byte getUser_type() {
        return user_type;
    }

    public void setUser_type(Byte user_type) {
        this.user_type = user_type;
    }

    public String getQq_openid() {
        return qq_openid;
    }

    public void setQq_openid(String qq_openid) {
        this.qq_openid = qq_openid == null ? null : qq_openid.trim();
    }

    public String getSina_openid() {
        return sina_openid;
    }

    public void setSina_openid(String sina_openid) {
        this.sina_openid = sina_openid == null ? null : sina_openid.trim();
    }

    public Integer getLogins() {
        return logins;
    }

    public void setLogins(Integer logins) {
        this.logins = logins;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public Integer getSell_num() {
        return sell_num;
    }

    public void setSell_num(Integer sell_num) {
        this.sell_num = sell_num;
    }

    public Integer getRent_num() {
        return rent_num;
    }

    public void setRent_num(Integer rent_num) {
        this.rent_num = rent_num;
    }

    public Integer getLast_login() {
        return last_login;
    }

    public void setLast_login(Integer last_login) {
        this.last_login = last_login;
    }

    public String getActive_str() {
        return active_str;
    }

    public void setActive_str(String active_str) {
        this.active_str = active_str == null ? null : active_str.trim();
    }

    public Integer getActive_rate() {
        return active_rate;
    }

    public void setActive_rate(Integer active_rate) {
        this.active_rate = active_rate;
    }

    public Integer getActive_total() {
        return active_total;
    }

    public void setActive_total(Integer active_total) {
        this.active_total = active_total;
    }

    public Float getOrder_weight() {
        return order_weight;
    }

    public void setOrder_weight(Float order_weight) {
        this.order_weight = order_weight;
    }

    public Byte getTop_day() {
        return top_day;
    }

    public void setTop_day(Byte top_day) {
        this.top_day = top_day;
    }

    public Integer getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Integer add_time) {
        this.add_time = add_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getIs_index() {
        return is_index;
    }

    public void setIs_index(Byte is_index) {
        this.is_index = is_index;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public Integer getAddsale() {
        return addsale;
    }

    public void setAddsale(Integer addsale) {
        this.addsale = addsale;
    }

    public Integer getAddrent() {
        return addrent;
    }

    public void setAddrent(Integer addrent) {
        this.addrent = addrent;
    }

    public Byte getVip() {
        return vip;
    }

    public void setVip(Byte vip) {
        this.vip = vip;
    }

    public Integer getVexation() {
        return vexation;
    }

    public void setVexation(Integer vexation) {
        this.vexation = vexation;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public Integer getE_accurate() {
        return e_accurate;
    }

    public void setE_accurate(Integer e_accurate) {
        this.e_accurate = e_accurate;
    }

    public Integer getE_satisfaction() {
        return e_satisfaction;
    }

    public void setE_satisfaction(Integer e_satisfaction) {
        this.e_satisfaction = e_satisfaction;
    }

    public Integer getE_specialty() {
        return e_specialty;
    }

    public void setE_specialty(Integer e_specialty) {
        this.e_specialty = e_specialty;
    }

    public Integer getIntegrate_id() {
        return integrate_id;
    }

    public void setIntegrate_id(Integer integrate_id) {
        this.integrate_id = integrate_id;
    }

    public Integer getRecommend_num() {
        return recommend_num;
    }

    public void setRecommend_num(Integer recommend_num) {
        this.recommend_num = recommend_num;
    }

    public Integer getPublish_sum() {
        return publish_sum;
    }

    public void setPublish_sum(Integer publish_sum) {
        this.publish_sum = publish_sum;
    }

    public Integer getRefresh_num() {
        return refresh_num;
    }

    public void setRefresh_num(Integer refresh_num) {
        this.refresh_num = refresh_num;
    }

    public Boolean getIs_broker() {
        return is_broker;
    }

    public void setIs_broker(Boolean is_broker) {
        this.is_broker = is_broker;
    }

    public Boolean getUser_status() {
        return user_status;
    }

    public void setUser_status(Boolean user_status) {
        this.user_status = user_status;
    }

    public Integer getIs_dz() {
        return is_dz;
    }

    public void setIs_dz(Integer is_dz) {
        this.is_dz = is_dz;
    }

    public String getBroker_info() {
        return broker_info;
    }

    public void setBroker_info(String broker_info) {
        this.broker_info = broker_info == null ? null : broker_info.trim();
    }

    public String getUsernamebak() {
        return usernamebak;
    }

    public void setUsernamebak(String usernamebak) {
        this.usernamebak = usernamebak == null ? null : usernamebak.trim();
    }

    public Integer getIs_photoer() {
        return is_photoer;
    }

    public void setIs_photoer(Integer is_photoer) {
        this.is_photoer = is_photoer;
    }

    public Boolean getRegular() {
        return regular;
    }

    public void setRegular(Boolean regular) {
        this.regular = regular;
    }

    public Date getRegular_time() {
        return regular_time;
    }

    public void setRegular_time(Date regular_time) {
        this.regular_time = regular_time;
    }

    public Integer getOpen_time() {
        return open_time;
    }

    public void setOpen_time(Integer open_time) {
        this.open_time = open_time;
    }

    public Integer getOpen_time_now() {
        return open_time_now;
    }

    public void setOpen_time_now(Integer open_time_now) {
        this.open_time_now = open_time_now;
    }

    public Integer getIs_newhouse() {
        return is_newhouse;
    }

    public void setIs_newhouse(Integer is_newhouse) {
        this.is_newhouse = is_newhouse;
    }

    public Integer getNewhouse_manager() {
        return newhouse_manager;
    }

    public void setNewhouse_manager(Integer newhouse_manager) {
        this.newhouse_manager = newhouse_manager;
    }
}