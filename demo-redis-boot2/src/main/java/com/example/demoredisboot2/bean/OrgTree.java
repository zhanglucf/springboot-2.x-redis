package com.example.demoredisboot2.bean;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgTree implements Serializable {
    private final static Gson GSON = new Gson();

    private Long id;

    private String name;

    private Date createTime;

    private List<User> users = new ArrayList<>();

    private List<Org> orgs = new ArrayList<>();

    public OrgTree() {
    }

    public OrgTree(Long id, String name, Date createTime, Long orgId, String orgName, Long userId, String userName) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.addOrg(orgId, orgName);
        this.addUser(userId, userName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Org> getOrgs() {
        return orgs;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setOrgs(List<Org> orgs) {
        this.orgs = orgs;
    }

    public void addOrg(Long id, String name) {
        Org org = new Org();
        org.setOrgId(id);
        org.setOrgName(name);
        this.orgs.add(org);
    }

    public void addUser(Long id, String name) {
        User user = new User();
        user.setUserId(id);
        user.setUserName(name);
        this.users.add(user);
    }

    public String toJson() {
        return GSON.toJson(this);
    }

    class User implements Serializable {
        private Long userId;

        private String userName;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    class Org implements Serializable {
        private Long orgId;

        private String orgName;

        public Long getOrgId() {
            return orgId;
        }

        public void setOrgId(Long orgId) {
            this.orgId = orgId;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }
    }
}
