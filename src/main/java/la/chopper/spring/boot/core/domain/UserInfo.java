package la.chopper.spring.boot.core.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @author TonyTonyChopper
 * @version 1.0
 */
public class UserInfo {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private String userId;

    private String userName;

    private Boolean gender;

    private Integer age;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    private String address;

    private String userType;

    private String realName;

    private String qq;

    private String email;

    private String tel;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserInfo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModified=" + gmtModified)
                .add("userId='" + userId + "'")
                .add("userName='" + userName + "'")
                .add("gender=" + gender)
                .add("age=" + age)
                .add("birthday=" + birthday)
                .add("address='" + address + "'")
                .add("userType='" + userType + "'")
                .add("realName='" + realName + "'")
                .add("qq='" + qq + "'")
                .add("email='" + email + "'")
                .add("tel='" + tel + "'")
                .add("password='" + password + "'")
                .toString();
    }
}