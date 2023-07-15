package com.ibrplanner.dscommerce.config.customgrant;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Classe de conversor de autenticação personalizada.
 * Esta classe é responsável por converter uma solicitação HTTP em um objeto de autenticação.
 */
public class CustomPasswordAuthenticationConverter implements AuthenticationConverter {
	/**
	 * Este método converte uma solicitação HTTP em um objeto de autenticação.
	 * Ele primeiro verifica o tipo de concessão e, em seguida, processa os parâmetros da solicitação para criar o objeto de autenticação.
	 *
	 * @param request O objeto HttpServletRequest que contém os detalhes da solicitação do cliente.
	 * @return Retorna um objeto de autenticação se o tipo de concessão for 'password', caso contrário, retorna null.
	 */
	@Nullable
	@Override
	public Authentication convert(HttpServletRequest request) {
		
		String grantType = request.getParameter(OAuth2ParameterNames.GRANT_TYPE);
				
		if (!"password".equals(grantType)) {
			return null;
		}
		
		MultiValueMap<String, String> parameters = getParameters(request);
		
		// scope (OPTIONAL)
		String scope = parameters.getFirst(OAuth2ParameterNames.SCOPE);
		if (StringUtils.hasText(scope) &&
				parameters.get(OAuth2ParameterNames.SCOPE).size() != 1) {
			throw new OAuth2AuthenticationException(OAuth2ErrorCodes.INVALID_REQUEST);
		}
		
		// username (REQUIRED)
		String username = parameters.getFirst(OAuth2ParameterNames.USERNAME);
		if (!StringUtils.hasText(username) ||
				parameters.get(OAuth2ParameterNames.USERNAME).size() != 1) {
			throw new OAuth2AuthenticationException(OAuth2ErrorCodes.INVALID_REQUEST);
		}
		
		// password (REQUIRED)
		String password = parameters.getFirst(OAuth2ParameterNames.PASSWORD);
		if (!StringUtils.hasText(password) ||
				parameters.get(OAuth2ParameterNames.PASSWORD).size() != 1) {
			throw new OAuth2AuthenticationException(OAuth2ErrorCodes.INVALID_REQUEST);
		}
				
		Set<String> requestedScopes = null;
		if (StringUtils.hasText(scope)) {
			requestedScopes = new HashSet<>(
					Arrays.asList(StringUtils.delimitedListToStringArray(scope, " ")));
		}
		
		Map<String, Object> additionalParameters = new HashMap<>();
		parameters.forEach((key, value) -> {
			if (!key.equals(OAuth2ParameterNames.GRANT_TYPE) &&
					!key.equals(OAuth2ParameterNames.SCOPE)) {
				additionalParameters.put(key, value.get(0));
			}
		});

		// Autenticação do cliente extraída do contexto de segurança.
		Authentication clientPrincipal = SecurityContextHolder.getContext().getAuthentication();

		// Retorna uma nova instância de CustomPasswordAuthenticationToken usando os dados extraídos da solicitação.
		return new CustomPasswordAuthenticationToken(clientPrincipal, requestedScopes, additionalParameters);
	}

	/**
	 * Este método privado é responsável por extrair os parâmetros da solicitação HTTP.
	 *
	 * @param request O objeto HttpServletRequest que contém os detalhes da solicitação do cliente.
	 * @return Retorna um MultiValueMap dos parâmetros extraídos da solicitação.
	 */
	private static MultiValueMap<String, String> getParameters(HttpServletRequest request) {
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>(parameterMap.size());
		parameterMap.forEach((key, values) -> {
			if (values.length > 0) {
				for (String value : values) {
					parameters.add(key, value);
				}
			}
		});
		return parameters;
	}
}
