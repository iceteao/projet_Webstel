package webstel.webstel.webstel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstel.webstel.webstel.Repository.ItemRepository;
import webstel.webstel.webstel.service.SaveService;

import webstel.webstel.webstel.WatchlistItem;



@Service
public class SaveServiceImp implements SaveService {
	@Autowired
	ItemRepository ItemRepository;
	
	
	@Override
	public void saveWatchlistItem(WatchlistItem item_list) {
		ItemRepository.save(item_list);

	}
}