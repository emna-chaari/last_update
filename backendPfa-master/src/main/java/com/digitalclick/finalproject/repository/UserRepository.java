package com.digitalclick.finalproject.repository;

import com.digitalclick.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>, UserRepositoryCustom {
    //Optional<List<User>> findByRoleId(Integer role_id);
    /*@Transactional
    @Modifying
    @Query(value="UPDATE users SET first_Name =:firstname, last_name=:lastname, password=:password, email=:email, adress=:adress, phone_number=:phone_number where role_id=:role", nativeQuery = true)
    public User updateByRoleId(@Param("role_id")   Integer role_id, @Param("id")Integer id);
*/

    @Query(value="SELECT u FROM User u WHERE u.email = :email", nativeQuery = true)
    public User getUserByEmail(@Param("email") String email);


}