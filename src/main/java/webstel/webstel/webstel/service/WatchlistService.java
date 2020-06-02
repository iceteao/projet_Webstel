package webstel.webstel.webstel.service;


import webstel.webstel.webstel.Repository.ItemRepository;
import webstel.webstel.webstel.Repository.ListRepository;
import webstel.webstel.webstel.Repository.WatchlistRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import webstel.webstel.webstel.WatchlistItem;
import webstel.webstel.webstel.exception.DuplicateAddressException;


@Service
public class WatchlistService {
	@Autowired
	private ListRepository listRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	WatchlistRepository watchlistRepository = new WatchlistRepository();
	
	
	public List<WatchlistItem> getWatchlistItems(){
		return watchlistRepository.getList();
	}
	
	public int getWatchlistItemsSize(){
		return watchlistRepository.getList().size();
	}
	
	public WatchlistItem findWatchlistItemById(Integer id) {
		return watchlistRepository.findById(id);
	}
	
	public Optional<WatchlistItem> findById(int id) {
		return listRepository.findById(id);
	}
	

	public void delete(Integer id) {
		listRepository.deleteById(id);
		
	}

	public void save(WatchlistItem watchlistitem) {
		listRepository.save(watchlistitem);
		
	}


	
	public List<WatchlistItem> getWatchlist(){
		return (List<WatchlistItem>) listRepository.findAll();
	}
}