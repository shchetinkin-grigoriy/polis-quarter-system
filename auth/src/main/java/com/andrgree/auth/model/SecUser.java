package com.andrgree.auth.model;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "sec_user")
public class SecUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<SecRole> roles;

    private boolean enabled = true;

    public SecUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Set<SecRole> getRoles() {
        return roles;
    }

    public void setRoles(final Set<SecRole> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }
}
