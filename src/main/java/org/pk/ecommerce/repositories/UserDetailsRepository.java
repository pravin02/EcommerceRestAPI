package org.pk.ecommerce.repositories;

import org.pk.ecommerce.entities.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
}
