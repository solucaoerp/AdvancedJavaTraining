package com.ibrplanner.dscommerce.config.customgrant;

import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Classe CustomPasswordAuthenticationToken que estende OAuth2AuthorizationGrantAuthenticationToken.
 * Esta classe é responsável por encapsular as informações do token de autenticação com nome de usuário e senha.
 */
public class CustomPasswordAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {

	private static final long serialVersionUID = 1L;
	
	private final String username;
	private final String password;
	private final Set<String> scopes;

	/**
	 * Construtor para a classe CustomPasswordAuthenticationToken.
	 *
	 * @param clientPrincipal A autenticação principal do cliente que representa o cliente autenticado.
	 * @param scopes O conjunto opcional de escopos associados a este token.
	 * @param additionalParameters Um mapa opcional de parâmetros adicionais.
	 */
	public CustomPasswordAuthenticationToken(Authentication clientPrincipal,
			@Nullable Set<String> scopes, @Nullable Map<String, Object> additionalParameters) {
		
		super(new AuthorizationGrantType("password"), clientPrincipal, additionalParameters);
		
		this.username = (String) additionalParameters.get("username");
		this.password = (String) additionalParameters.get("password");
		this.scopes = Collections.unmodifiableSet(
				scopes != null ? new HashSet<>(scopes) : Collections.emptySet());
	}

	/**
	 * Este método retorna o nome de usuário associado a este token.
	 *
	 * @return Retorna o nome de usuário associado a este token.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Este método retorna a senha associada a este token.
	 *
	 * @return Retorna a senha associada a este token.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Este método retorna o conjunto de escopos associados a este token.
	 *
	 * @return Retorna o conjunto de escopos associados a este token.
	 */
	public Set<String> getScopes() {
		return this.scopes;
	}
}
