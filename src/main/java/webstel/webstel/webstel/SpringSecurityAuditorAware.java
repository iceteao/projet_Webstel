package webstel.webstel.webstel;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SpringSecurityAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		
		String username = authentication.getName();
		UserPrincipal customUser = (UserPrincipal)authentication.getPrincipal();
		int userId = customUser.getUserId();

		return Optional.ofNullable(username).filter(s -> !s.isEmpty());
	}

}
