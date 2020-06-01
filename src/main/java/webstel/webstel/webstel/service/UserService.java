package webstel.webstel.webstel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import webstel.webstel.webstel.User;
import webstel.webstel.webstel.WatchlistItem;
import webstel.webstel.webstel.Repository.UserRepository;


@Service
public class UserService {
	
	@Autowired private BCryptPasswordEncoder encoder;
	
	@Autowired private UserRepository userRepository;
	
	public void save(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		userRepository.save(user);
	}
	public List<User> getUsers(){
		return (List<User>) userRepository.findAll();
	}


	public User getUsersById(int Id) {
		return userRepository.findById(Id);
	}
	public List<User> findAll() {

		return userRepository.findAll();
	}
	public List<User> findByUsername(String username) {
		return userRepository.findByUsernameLike("%"+username+"%");
	}
	public User findById(int id) {
		return userRepository.findById(id);
	}

	public void delete(Integer id) {
		userRepository.deleteById(id);
		
	}


}
