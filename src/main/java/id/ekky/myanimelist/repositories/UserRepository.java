package id.ekky.myanimelist.repositories;

import id.ekky.myanimelist.models.Anime;
import id.ekky.myanimelist.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("""
            SELECT u FROM User u
            WHERE (:username IS NULL
                OR u.username LIKE %:username%)
                AND
                (:gender IS NULL
                OR u.gender LIKE %:gender%)
                AND
                (:location IS NULL
                OR u.location LIKE %:location%)
            ORDER BY u.id
            """)
    public Page<User> findAll(
            Pageable pageable,
            @Param("username") String username,
            @Param("gender") String gender,
            @Param("location") String location
    );
}
