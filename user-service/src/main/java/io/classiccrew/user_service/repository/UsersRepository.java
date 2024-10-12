package io.classiccrew.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.classiccrew.user_service.entity.AppUsers;

@Repository
public interface UsersRepository extends JpaRepository<AppUsers, Long> {

}