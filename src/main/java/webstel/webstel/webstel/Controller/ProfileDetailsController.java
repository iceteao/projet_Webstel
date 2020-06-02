package webstel.webstel.webstel.Controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import webstel.webstel.webstel.ProfileDetails;
import webstel.webstel.webstel.UserPrincipal;
import webstel.webstel.webstel.WatchlistItem;
import webstel.webstel.webstel.Repository.DetailRepository;
import webstel.webstel.webstel.Repository.ItemRepository;
import webstel.webstel.webstel.Repository.ListRepository;
import webstel.webstel.webstel.service.ProfileDetailService;
import webstel.webstel.webstel.service.SaveService;
import webstel.webstel.webstel.service.WatchlistService;


@Controller
public class ProfileDetailsController {
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	DetailRepository detailRepository;
	@Autowired
	private ProfileDetailService profiledetailService;
	
	
//	@GetMapping("/profiledetails")
//	public String getDetails(Model model) {		
//		model.addAttribute("profiledetails", profiledetailService.getDetails());	
//	
//		return "ProfileDetails";
//	}	
	
	@RequestMapping(value="/profiledetails/addNew", method= {RequestMethod.POST})
	public String addNew(ProfileDetails profiledetail) {
		profiledetailService.save(profiledetail);
		return "redirect:/watchlist";
	}
	
//	@RequestMapping(value="/profiledetails/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
//	public String delete(Integer id) {
//		profiledetailService.delete(id);
//		return "redirect:/watchlist";
//	}
//	
	@RequestMapping(value="/profiledetails/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(ProfileDetails profiledetail) {
		profiledetailService.save(profiledetail);
		return "redirect:/watchlist";
	}

	
	@GetMapping(value = "/profile")
	public ModelAndView getUserDetails(Authentication auth, Integer userid) {
		String viewName= "Profile";
		auth = SecurityContextHolder.getContext().getAuthentication();
		userid  = ((UserPrincipal)auth.getPrincipal()).getId();
		List<ProfileDetails> userdetails = detailRepository.findbyUser(userid);

		Map<String,Object> model = new HashMap<String,Object>();
		model.put("userdetails", userdetails);
		return new ModelAndView(viewName,model);	
		
	}
	
	
	@RequestMapping("profiledetails/findById")
	@ResponseBody 
	public Optional<ProfileDetails> findById(int id) {
		return profiledetailService.findById(id);
	}
	
		
	
}
