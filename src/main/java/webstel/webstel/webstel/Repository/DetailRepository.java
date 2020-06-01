package webstel.webstel.webstel.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import webstel.webstel.webstel.ProfileDetails;

@Repository
public interface DetailRepository extends JpaRepository<ProfileDetails, Integer> {

    @Query(value="SELECT * FROM websteldb.profiledetails WHERE userid = :uid", nativeQuery=true)
	public List<ProfileDetails> findbyUser(@Param("uid")int uid);

}