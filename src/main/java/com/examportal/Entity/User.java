package com.examportal.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User  implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String username;
private String password;
private String firstname;
private String lastname;
@Column(unique = true)
private String email;
private String phone;
private boolean enabled=true;
private String profiles;
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JsonIgnore
private List<UserRole> userList=new ArrayList<UserRole>();






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
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
public String getProfiles() {
	return profiles;
}
public void setProfiles(String profiles) {
	this.profiles = profiles;
}
public List<UserRole> getUserList() {
	return userList;
}
public void setUserList(List<UserRole> userList) {
	this.userList = userList;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	List<SimpleGrantedAuthority> role = this.userList.stream().map(i->new SimpleGrantedAuthority(i.getRole().getRoleName())).collect(Collectors.toList());
	return role;
}
@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return this.enabled;
}
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return this.enabled;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
			+ ", lastname=" + lastname + ", email=" + email + ", phone=" + phone + ", enabled=" + enabled
			+ ", profiles=" + profiles + ", userList=" + userList + "]";
}







}








