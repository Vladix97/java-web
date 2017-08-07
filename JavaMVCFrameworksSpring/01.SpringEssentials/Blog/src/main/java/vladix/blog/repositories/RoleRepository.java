package vladix.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vladix.blog.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
