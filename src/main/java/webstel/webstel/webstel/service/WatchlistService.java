package webstel.webstel.webstel.service;


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
	
//	public void addOrUpdateWatchlistItem(WatchlistItem watchlistItem) throws DuplicateAddressException {
//		
//		WatchlistItem existingItem = findWatchlistItemById(watchlistItem.getId());
//
//		if (existingItem == null) {
//			if (watchlistRepository.findByAddress(watchlistItem.getAddress())!=null) {
//				throw new DuplicateAddressException();
//			}
//			watchlistRepository.addItem(watchlistItem);
//		} else {
//			existingItem.setCountry(watchlistItem.getCountry());
//			existingItem.setDateFrom(watchlistItem.getDateFrom());
//			existingItem.setDateTo(watchlistItem.getDateTo());
//			existingItem.setHdesc(watchlistItem.getHdesc());
//			existingItem.setService(watchlistItem.getService());
//			existingItem.setLimit(watchlistItem.getLimit());
//			existingItem.setComment(watchlistItem.getComment());
//			existingItem.setAddress(watchlistItem.getAddress());  
//		}
//	}

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