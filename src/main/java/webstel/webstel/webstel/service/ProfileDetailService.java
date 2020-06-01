package webstel.webstel.webstel.service;


import webstel.webstel.webstel.Repository.DetailRepository;
import webstel.webstel.webstel.Repository.ItemRepository;
import webstel.webstel.webstel.Repository.ListRepository;
import webstel.webstel.webstel.Repository.WatchlistRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstel.webstel.webstel.ProfileDetails;



@Service
public class ProfileDetailService {

	@Autowired
	private DetailRepository detailRepository;
	

	public Optional<ProfileDetails> findById(int id) {
		return detailRepository.findById(id);
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
		detailRepository.deleteById(id);
		
	}

	public void save(ProfileDetails profiledetail) {
		detailRepository.save(profiledetail);
		
	}

	public List<ProfileDetails> getDetails() {
		return detailRepository.findAll();
	}
}