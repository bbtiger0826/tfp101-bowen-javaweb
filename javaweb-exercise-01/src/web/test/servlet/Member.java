package web.test.servlet;

import java.sql.Timestamp;

public class Member {
    private Integer id; // 會員編號
    private String account; // 帳號
    private String password; // 密碼
    private Boolean pass; // 激活記號
    private Timestamp lastUpdateDate; // 最後修改日期
    
    public Member(Integer id, String account, String password, Boolean pass, Timestamp lastUpdateDate) {
        super();
        this.id = id;
        this.account = account;
        this.password = password;
        this.pass = pass;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
