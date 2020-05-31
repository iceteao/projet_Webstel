package webstel.webstel.webstel.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import webstel.webstel.webstel.WatchlistItem;


@Repository
public interface SearchRepository extends JpaRepository<WatchlistItem, Integer> {
	@Query(value ="SELECT DISTINCT list_item FROM list_item i WHERE i.address LIKE :address%", nativeQuery=true)
	@Transactional(readOnly = true)
Collection<WatchlistItem> findByAddress(@Param("address") String address);


}
