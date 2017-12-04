package com.jnhouse.app.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 员工详情表
 * @author lou
 *
 */
public class UserInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String realname;

    private Integer city_id;

    private Integer cityarea_id;

    private Integer cityarea2_id;

    private String broker_mobile;

    private String avatar;

    private String idcard_pic;

    private String idcard;

    private String aptitude;

    private String business;

    private String signed;

    private String company;

    private String outlet;

    private String outlet_addr;

    private String post_code;

    private String com_tell;

    private String com_fax;

    private Boolean gender;

    private Date birthday;

    private Integer borough_id;

    private String qq;

    private String msn;

    private Byte broker_type;

    private String outlet_first;

    private String outlet_last;

    private Integer specialty;

    private String banner;

    private String background;

    private Integer working_life;

    private Integer max_refresh_manual;

    private Boolean verify_status;

    private Boolean is_broker;

    private Integer max_refresh_auto;

    private Boolean vip_status;

    private Integer vip_endtime;

    private Boolean feature_status;

    private String feature_time;

    private Boolean recommend_1;

    private Boolean recommend_2;

    private Boolean recommend_3;

    private Boolean recommend_4;

    private Boolean recommend_5;

    private Boolean recommend_6;

    private Boolean recommend_7;

    private Boolean recommend_8;

    private Boolean recommend_9;

    private Integer r1_time;

    private Integer r2_time;

    private Integer r3_time;

    private Integer r4_time;

    private Integer r5_time;

    private Integer r6_time;

    private Integer r7_time;

    private Integer r8_time;

    private Integer r9_time;

    private String summary;

    private String introduce;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getCityarea_id() {
        return cityarea_id;
    }

    public void setCityarea_id(Integer cityarea_id) {
        this.cityarea_id = cityarea_id;
    }

    public Integer getCityarea2_id() {
        return cityarea2_id;
    }

    public void setCityarea2_id(Integer cityarea2_id) {
        this.cityarea2_id = cityarea2_id;
    }

    public String getBroker_mobile() {
        return broker_mobile;
    }

    public void setBroker_mobile(String broker_mobile) {
        this.broker_mobile = broker_mobile == null ? null : broker_mobile.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getIdcard_pic() {
        return idcard_pic;
    }

    public void setIdcard_pic(String idcard_pic) {
        this.idcard_pic = idcard_pic == null ? null : idcard_pic.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getAptitude() {
        return aptitude;
    }

    public void setAptitude(String aptitude) {
        this.aptitude = aptitude == null ? null : aptitude.trim();
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public String getSigned() {
        return signed;
    }

    public void setSigned(String signed) {
        this.signed = signed == null ? null : signed.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet == null ? null : outlet.trim();
    }

    public String getOutlet_addr() {
        return outlet_addr;
    }

    public void setOutlet_addr(String outlet_addr) {
        this.outlet_addr = outlet_addr == null ? null : outlet_addr.trim();
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code == null ? null : post_code.trim();
    }

    public String getCom_tell() {
        return com_tell;
    }

    public void setCom_tell(String com_tell) {
        this.com_tell = com_tell == null ? null : com_tell.trim();
    }

    public String getCom_fax() {
        return com_fax;
    }

    public void setCom_fax(String com_fax) {
        this.com_fax = com_fax == null ? null : com_fax.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getBorough_id() {
        return borough_id;
    }

    public void setBorough_id(Integer borough_id) {
        this.borough_id = borough_id;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
    }

    public Byte getBroker_type() {
        return broker_type;
    }

    public void setBroker_type(Byte broker_type) {
        this.broker_type = broker_type;
    }

    public String getOutlet_first() {
        return outlet_first;
    }

    public void setOutlet_first(String outlet_first) {
        this.outlet_first = outlet_first == null ? null : outlet_first.trim();
    }

    public String getOutlet_last() {
        return outlet_last;
    }

    public void setOutlet_last(String outlet_last) {
        this.outlet_last = outlet_last == null ? null : outlet_last.trim();
    }

    public Integer getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Integer specialty) {
        this.specialty = specialty;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner == null ? null : banner.trim();
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background == null ? null : background.trim();
    }

    public Integer getWorking_life() {
        return working_life;
    }

    public void setWorking_life(Integer working_life) {
        this.working_life = working_life;
    }

    public Integer getMax_refresh_manual() {
        return max_refresh_manual;
    }

    public void setMax_refresh_manual(Integer max_refresh_manual) {
        this.max_refresh_manual = max_refresh_manual;
    }

    public Boolean getVerify_status() {
        return verify_status;
    }

    public void setVerify_status(Boolean verify_status) {
        this.verify_status = verify_status;
    }

    public Boolean getIs_broker() {
        return is_broker;
    }

    public void setIs_broker(Boolean is_broker) {
        this.is_broker = is_broker;
    }

    public Integer getMax_refresh_auto() {
        return max_refresh_auto;
    }

    public void setMax_refresh_auto(Integer max_refresh_auto) {
        this.max_refresh_auto = max_refresh_auto;
    }

    public Boolean getVip_status() {
        return vip_status;
    }

    public void setVip_status(Boolean vip_status) {
        this.vip_status = vip_status;
    }

    public Integer getVip_endtime() {
        return vip_endtime;
    }

    public void setVip_endtime(Integer vip_endtime) {
        this.vip_endtime = vip_endtime;
    }

    public Boolean getFeature_status() {
        return feature_status;
    }

    public void setFeature_status(Boolean feature_status) {
        this.feature_status = feature_status;
    }

    public String getFeature_time() {
        return feature_time;
    }

    public void setFeature_time(String feature_time) {
        this.feature_time = feature_time == null ? null : feature_time.trim();
    }

    public Boolean getRecommend_1() {
        return recommend_1;
    }

    public void setRecommend_1(Boolean recommend_1) {
        this.recommend_1 = recommend_1;
    }

    public Boolean getRecommend_2() {
        return recommend_2;
    }

    public void setRecommend_2(Boolean recommend_2) {
        this.recommend_2 = recommend_2;
    }

    public Boolean getRecommend_3() {
        return recommend_3;
    }

    public void setRecommend_3(Boolean recommend_3) {
        this.recommend_3 = recommend_3;
    }

    public Boolean getRecommend_4() {
        return recommend_4;
    }

    public void setRecommend_4(Boolean recommend_4) {
        this.recommend_4 = recommend_4;
    }

    public Boolean getRecommend_5() {
        return recommend_5;
    }

    public void setRecommend_5(Boolean recommend_5) {
        this.recommend_5 = recommend_5;
    }

    public Boolean getRecommend_6() {
        return recommend_6;
    }

    public void setRecommend_6(Boolean recommend_6) {
        this.recommend_6 = recommend_6;
    }

    public Boolean getRecommend_7() {
        return recommend_7;
    }

    public void setRecommend_7(Boolean recommend_7) {
        this.recommend_7 = recommend_7;
    }

    public Boolean getRecommend_8() {
        return recommend_8;
    }

    public void setRecommend_8(Boolean recommend_8) {
        this.recommend_8 = recommend_8;
    }

    public Boolean getRecommend_9() {
        return recommend_9;
    }

    public void setRecommend_9(Boolean recommend_9) {
        this.recommend_9 = recommend_9;
    }

    public Integer getR1_time() {
        return r1_time;
    }

    public void setR1_time(Integer r1_time) {
        this.r1_time = r1_time;
    }

    public Integer getR2_time() {
        return r2_time;
    }

    public void setR2_time(Integer r2_time) {
        this.r2_time = r2_time;
    }

    public Integer getR3_time() {
        return r3_time;
    }

    public void setR3_time(Integer r3_time) {
        this.r3_time = r3_time;
    }

    public Integer getR4_time() {
        return r4_time;
    }

    public void setR4_time(Integer r4_time) {
        this.r4_time = r4_time;
    }

    public Integer getR5_time() {
        return r5_time;
    }

    public void setR5_time(Integer r5_time) {
        this.r5_time = r5_time;
    }

    public Integer getR6_time() {
        return r6_time;
    }

    public void setR6_time(Integer r6_time) {
        this.r6_time = r6_time;
    }

    public Integer getR7_time() {
        return r7_time;
    }

    public void setR7_time(Integer r7_time) {
        this.r7_time = r7_time;
    }

    public Integer getR8_time() {
        return r8_time;
    }

    public void setR8_time(Integer r8_time) {
        this.r8_time = r8_time;
    }

    public Integer getR9_time() {
        return r9_time;
    }

    public void setR9_time(Integer r9_time) {
        this.r9_time = r9_time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}