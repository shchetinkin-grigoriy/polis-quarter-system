package com.andrgree.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Table(name = "sec_privilege")
public class SecPrivilege {

    @Id
    @GeneratedValue
    private long privilegeId;

    private String name;

    private String description;

    public long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(final long privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
