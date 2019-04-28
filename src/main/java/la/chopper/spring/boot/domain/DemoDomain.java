package la.chopper.spring.boot.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.StringJoiner;

/**
 * 测试domain
 *
 * @author TonyTonyChopper
 * @version 1.0
 */
public class DemoDomain {

    private int id;

    private String userName;

    private String remarks;

    @JSONField(format="yyyy-MM-dd HH:mm")
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DemoDomain.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userName='" + userName + "'")
                .add("remarks='" + remarks + "'")
                .add("createTime=" + createTime)
                .toString();
    }
}
