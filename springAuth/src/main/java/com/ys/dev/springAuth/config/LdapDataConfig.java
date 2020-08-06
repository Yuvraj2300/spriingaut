package com.ys.dev.springAuth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.ys.dev.springAuth.model.LdapAuthStructure;

@ComponentScan(basePackages = { "com.ys.dev.springAuth.config" })
public class LdapDataConfig {

	@Value("spring.ldap.urls")
	private String ldapUrls;

	@Value("spring.ldap.base")
	private String ldapBase;

	@Value("spring.ldap.password")
	private String ldapManagerPwd;

	@Value("spring.ldap.username")
	private String ldapManagerUserName;

	@Bean("ldapAuthStructure")
	public LdapAuthStructure getLDAPAuthStructure() {
		LdapAuthStructure struct = new LdapAuthStructure();
		struct.setLdapUrl(ldapUrls);
		struct.setLdapBase(ldapBase);
		struct.setLdapManagerPwd(ldapManagerPwd);
		struct.setLdapManagerDn(ldapManagerUserName);
		struct.setUserDnPattern("uid={0},ou=users");
		struct.setUserSearchBase("ou=roles");

		return struct;
	}
}
