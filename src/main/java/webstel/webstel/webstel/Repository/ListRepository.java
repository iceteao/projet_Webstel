package webstel.webstel.webstel.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import webstel.webstel.webstel.WatchlistItem;

@Repository
public interface ListRepository extends JpaRepository<WatchlistItem, Integer> {
	@Query(value="SELECT * FROM websteldb.list_item WHERE userid = :uid", nativeQuery=true)
	public List<WatchlistItem> findbyUser(@Param("uid")int uid);
	
	

}