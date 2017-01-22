package xyz.stg.bbs.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by shitiangao on 16/7/8.
 */
@Entity
@Table(name = "user")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "password")
    private String password;

    @Column(name = "roles")
    private String roles = "";

    @Column(name = "authorities")
    private String authorities = "";

    @Column(name = "enable")
    private Boolean enable = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String authority : authorities.trim().split(",")) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        for (String role : roles.trim().split(",")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return grantedAuthorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Column(name = "account_non_expired")
    private Boolean accountNonExpired = true;

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }


    @Column(name = "account_non_locked")
    private Boolean accountNonLocked = true;

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired = true;

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}