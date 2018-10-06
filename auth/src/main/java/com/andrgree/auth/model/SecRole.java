package com.andrgree.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity
//@Table(name = "sec_role")
public class SecRole {

    @Id
    @GeneratedValue
    private Long roleId;

    private String name;

    private String description;

    @ManyToMany(fetch = LAZY)
    private Set<SecPrivilege> privileges = new HashSet<>(0);

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(final Long roleId) {
        this.roleId = roleId;
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

    public Set<SecPrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(final Set<SecPrivilege> privileges) {
        this.privileges = privileges;
    }

}
