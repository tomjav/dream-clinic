package pl.tgrzybowski.dreamclinic.register.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.tgrzybowski.dreamclinic.register.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT p.role FROM Account p WHERE p.role.role = :name")
    Role findRoleByName(@Param("name") String name);

//    @Query("SELECT d FROM Account a INNER JOIN Doctor d WHERE a.username = :username")
//    Doctor getDoctorByUserName(@Param("username") String username);
}
