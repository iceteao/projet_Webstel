package webstel.webstel.webstel.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import webstel.webstel.webstel.User;
import webstel.webstel.webstel.WatchlistItem;
import webstel.webstel.webstel.service.*;



@Controller
public class UserController {

		@Autowired private UserService userService;
		
		@GetMapping("/users")
		public String listUsers(Model model, @RequestParam(defaultValue="") String username) {
			model.addAttribute("listusers",userService.findByUsername(username));
		return "Users";
	}
		
		
		//Modified method to Add a new user User
		@PostMapping(value="users/addNew")
		public RedirectView addNew(User user, RedirectAttributes redir) {
			
			userService.save(user);	
			
			RedirectView  redirectView= new RedirectView("/login",true);
			
		    redir.addFlashAttribute("message",	"You successfully registered! You can now login");
		        
		    return redirectView;				
		}
		
		@RequestMapping(value="/users/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
		public String delete(Integer id) {
			userService.delete(id);
			return "redirect:/users";
		}
		
		@RequestMapping("users/findById")
		@ResponseBody 
		public User findById(int id) {
			return userService.findById(id);
		}
		
		

		
		}
		