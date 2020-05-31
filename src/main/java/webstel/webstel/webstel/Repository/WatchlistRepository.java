package webstel.webstel.webstel.Repository;

import java.util.ArrayList;
import java.util.List;

import webstel.webstel.webstel.WatchlistItem;

public class WatchlistRepository {
	private List<WatchlistItem> watchlistItems = new ArrayList<WatchlistItem>();
	private int index = 1;
	
	
	
	public List<WatchlistItem> getList(){
		return watchlistItems;
	}
	
	public void addItem(WatchlistItem watchlistItem) {
		watchlistItem.setId(index++);
		watchlistItems.add(watchlistItem);
	}
	
	public WatchlistItem findById(Integer id) {
		for (WatchlistItem watchlistItem : watchlistItems) {
			if (watchlistItem.getId().equals(id)) {
				return watchlistItem;
			}
		}
		return null;
	}
	
	public WatchlistItem findByAddress(String address) {
		for (WatchlistItem watchlistItem : watchlistItems) {
			if (watchlistItem.getAddress().equals(address)) {
				return watchlistItem;
			}
		}
		return null;
	}
	
}
