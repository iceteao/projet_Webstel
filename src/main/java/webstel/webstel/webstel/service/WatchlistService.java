package webstel.webstel.webstel.service;

import webstel.webstel.webstel.Repository.WatchlistRepository;

import java.util.List;



import webstel.webstel.webstel.WatchlistItem;
import webstel.webstel.webstel.exception.DuplicateAddressException;



public class WatchlistService {
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
	
	public void addOrUpdateWatchlistItem(WatchlistItem watchlistItem) throws DuplicateAddressException {
		
		WatchlistItem existingItem = findWatchlistItemById(watchlistItem.getId());

		if (existingItem == null) {
			if (watchlistRepository.findByAddress(watchlistItem.getAddress())!=null) {
				throw new DuplicateAddressException();
			}
			watchlistRepository.addItem(watchlistItem);
		} else {
			existingItem.setCountry(watchlistItem.getCountry());
			existingItem.setDateFrom(watchlistItem.getDateFrom());
			existingItem.setDateTo(watchlistItem.getDateTo());
			existingItem.setHdesc(watchlistItem.getHdesc());
			existingItem.setService(watchlistItem.getService());
			existingItem.setLimit(watchlistItem.getLimit());
			existingItem.setComment(watchlistItem.getComment());
			existingItem.setAddress(watchlistItem.getAddress());  
		}
	}
}