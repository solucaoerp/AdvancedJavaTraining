package com.ibrplanner.dscommerce.config.customgrant;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Classe CustomUserAuthorities.
 * Esta classe é usada para encapsular informações sobre um usuário, incluindo seu nome de usuário e autoridades concedidas.
 */
public class CustomUserAuthorities {

	private String username;
	private Collection<? extends GrantedAuthority> authorities;

	/**
	 * Construtor para a classe CustomUserAuthorities.
	 *
	 * @param username O nome de usuário deste usuário.
	 * @param authorities A coleção de autoridades (ou permissões) concedidas a este usuário.
	 */
	public CustomUserAuthorities(String username, Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.authorities = authorities;
	}

	/**
	 * Este método retorna o nome de usuário associado a este usuário.
	 *
	 * @return Retorna o nome de usuário associado a este usuário.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Este método retorna as autoridades concedidas a este usuário.
	 *
	 * @return Retorna uma coleção das autoridades concedidas a este usuário.
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
