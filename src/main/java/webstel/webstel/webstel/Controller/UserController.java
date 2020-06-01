package webstel.webstel.webstel.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import webstel.webstel.webstel.User;
import webstel.webstel.webstel.service.*;



@Controller
public class UserController {

		@Autowired private UserService userService;
		
		@GetMapping("/users")
		public String getCountries() {
		return "User";
	}
		
		
		//Modified method to Add a new user User
		@PostMapping(value="users/addNew")
		public RedirectView addNew(User user, RedirectAttributes redir) {
			
			userService.save(user);	
			
			RedirectView  redirectView= new RedirectView("/login",true);
			
		    redir.addFlashAttribute("message",	"You successfully registered! You can now login");
		        
		    return redirectView;				
		}
		
		@RequestMapping(value="/users/id/{Id}")
			public List<User> getUsersById(@PathVariable int Id){
				return Arrays.asList(userService.getUsersById(Id));
			}
		

		
		}
		