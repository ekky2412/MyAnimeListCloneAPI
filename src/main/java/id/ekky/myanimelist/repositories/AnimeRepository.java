package id.ekky.myanimelist.repositories;

import id.ekky.myanimelist.models.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {
    @Query("""
            SELECT a FROM Anime a
            WHERE (:name IS NULL
                OR a.title LIKE %:name%)
            ORDER BY a.id
            """)
    public Page<Anime> findAll(
            Pageable pageable,
            @Param("name") String name);
}
