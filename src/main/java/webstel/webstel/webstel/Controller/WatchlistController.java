package webstel.webstel.webstel.Controller;


import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import webstel.webstel.webstel.User;
import webstel.webstel.webstel.UserPrincipal;
import webstel.webstel.webstel.WatchlistItem;
import webstel.webstel.webstel.Repository.ItemRepository;
import webstel.webstel.webstel.Repository.ListRepository;
import webstel.webstel.webstel.exception.DuplicateAddressException;
import webstel.webstel.webstel.service.SaveService;
import webstel.webstel.webstel.service.WatchlistService;


@Controller
public class WatchlistController {
	@Autowired
	SaveService saveService;
	
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	ListRepository listRepository;
	
	@Autowired
	private WatchlistService watchlistService;
	
	
	@GetMapping("/watchlistItemForm")
	public String getClients(Model model) {		
		model.addAttribute("watchlists", watchlistService.getWatchlist());	
	
		return "watchlistItemForm";
	}	
	
	@RequestMapping(value="/watchlistItemForm/addNew", method= {RequestMethod.POST})
	public String addNew(WatchlistItem watchlistitem) {
		watchlistService.save(watchlistitem);
		return "redirect:/watchlist";
	}
	
	@RequestMapping(value="/watchlistItemForm/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		watchlistService.delete(id);
		return "redirect:/watchlist";
	}
	
	@RequestMapping(value="/watchlistItemForm/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(WatchlistItem watchlistitem) {
		watchlistService.save(watchlistitem);
		return "redirect:/watchlist";
	}
	


	@GetMapping(value = "/acc")
	public ModelAndView getAllWatchlistItem() {
		String viewName= "acc";
		List<WatchlistItem> items = itemRepository.findAll();

		Map<String,Object> model = new HashMap<String,Object>();
				
		model.put("items", items);
		model.put("numberOfAccommodation", watchlistService.getWatchlistItemsSize());
		
		return new ModelAndView(viewName,model);	
		
	}
	
	@GetMapping(value = "/watchlist")
	public ModelAndView getUserWatchlistItem(Authentication auth, Integer userid) {
		String viewName= "watchlist";
		auth = SecurityContextHolder.getContext().getAuthentication();
		userid  = ((UserPrincipal)auth.getPrincipal()).getId();
		
		List<WatchlistItem> useritems = listRepository.findbyUser(userid);

		Map<String,Object> model = new HashMap<String,Object>();
				
		model.put("useritems", useritems);
		model.put("numberOfAccommodation", watchlistService.getWatchlistItemsSize());
		
		return new ModelAndView(viewName,model);	
		
	}
	
	
	@RequestMapping("watchlistItemForm/findById")
	@ResponseBody 
	public Optional<WatchlistItem> findById(int id) {
		return watchlistService.findById(id);
	}
	
		
	
}
