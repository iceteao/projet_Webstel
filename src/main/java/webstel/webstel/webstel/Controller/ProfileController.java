package webstel.webstel.webstel.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import webstel.webstel.webstel.User;
import webstel.webstel.webstel.UserPrincipal;
import webstel.webstel.webstel.WatchlistItem;
import webstel.webstel.webstel.service.UserService;


@Controller
public class ProfileController {
	@Autowired
	private UserService userService;

	
	@RequestMapping(value="/profile")
	public String getProfile(Principal principal,Model model) {

		String un = principal.getName();
		model.addAttribute("employee", userService.findByUsername(un));
		return "profile";
	}
}
