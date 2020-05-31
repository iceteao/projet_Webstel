package webstel.webstel.webstel.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import webstel.webstel.webstel.WatchlistItem;
import webstel.webstel.webstel.Repository.ItemRepository;
import webstel.webstel.webstel.exception.DuplicateAddressException;
import webstel.webstel.webstel.service.SaveService;
import webstel.webstel.webstel.service.WatchlistService;


@Controller
public class WatchlistController {
	@Autowired
	SaveService saveService;
	
	
	@Autowired
	ItemRepository itemRepository;
	
	private WatchlistService watchlistService = new WatchlistService();
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchlistItemForm(@RequestParam(required = false) Integer id) {
		
		String viewName = "watchlistItemForm";
		
		Map<String,Object> model = new HashMap<String,Object>();
		
		WatchlistItem watchlistItem = watchlistService.findWatchlistItemById(id);
		
		if (watchlistItem == null) {
			model.put("watchlistItem", new WatchlistItem());	
		} else {
			model.put("watchlistItem", watchlistItem);
		}
		return new ModelAndView(viewName,model); 
	}

	@RequestMapping(value="/watchlistItemForm",  method = RequestMethod.POST)
	public ModelAndView submitWatchlistItemForm(@Valid WatchlistItem watchlistItem, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			return new ModelAndView("watchlistItemForm");
		}
		else {
			saveService.saveWatchlistItem(watchlistItem);
		}
		try {
			watchlistService.addOrUpdateWatchlistItem(watchlistItem);
		} catch (DuplicateAddressException e) {
			bindingResult.rejectValue("address", "", "This address is already being used");
			return new ModelAndView("watchlistItemForm");
		}
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/watchlist");
		

		return new ModelAndView(redirect);
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
	
		
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		
		String viewName= "watchlist";
		
		Map<String,Object> model = new HashMap<String,Object>();
				
		model.put("watchlistItems", watchlistService.getWatchlistItems());
		model.put("numberOfAccommodation", watchlistService.getWatchlistItemsSize());
		
		return new ModelAndView(viewName,model);		
	}
}
