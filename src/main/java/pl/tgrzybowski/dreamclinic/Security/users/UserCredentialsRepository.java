package pl.tgrzybowski.dreamclinic.Security.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tgrzybowski.dreamclinic.register.entity.Account;

@Repository
public interface UserCredentialsRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
