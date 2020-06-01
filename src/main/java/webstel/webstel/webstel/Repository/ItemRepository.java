package webstel.webstel.webstel.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webstel.webstel.webstel.WatchlistItem;

@Repository
public interface ItemRepository extends JpaRepository<WatchlistItem, Integer> {

    public WatchlistItem findById(int id);
}