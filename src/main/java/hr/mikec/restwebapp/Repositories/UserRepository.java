package hr.mikec.RESTwebApp.Repositories;

import hr.mikec.RESTwebApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
