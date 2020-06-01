package webstel.webstel.webstel.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import webstel.webstel.webstel.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int id);
	User findByUsername(String username);
	List<User> findByUsernameLike(String username);

}
