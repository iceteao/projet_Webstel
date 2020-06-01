package webstel.webstel.webstel.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webstel.webstel.webstel.WatchlistItem;

@Repository
public interface ListRepository extends JpaRepository<WatchlistItem, Integer> {

}