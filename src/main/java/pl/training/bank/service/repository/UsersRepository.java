package pl.training.bank.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.bank.entity.User;

public interface UsersRepository extends JpaRepository<User, Long> {

    User getByLogin(String login);

}
