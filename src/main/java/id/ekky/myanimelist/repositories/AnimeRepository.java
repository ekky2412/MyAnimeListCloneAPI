package id.ekky.myanimelist.repositories;

import id.ekky.myanimelist.models.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {
    @Query("""
            SELECT a FROM Anime a
            WHERE (:name IS NULL
                OR a.title LIKE %:name%)
                AND
                (:genre IS NULL
                OR a.genres LIKE %:genre%)
                AND
                (:year IS NULL
                OR a.premiered LIKE %:year%)
                AND
                (:isHentai IS NULL
                OR a.isHentai = :isHentai)
            ORDER BY a.id
            """)
    public Page<Anime> findAll(
            Pageable pageable,
            @Param("name") String name,
            @Param("genre") String genre,
            @Param("year") Integer year,
            @Param("isHentai") Boolean isHentai
            );

    @Query("""
            SELECT a.imageUrl FROM Anime a
            WHERE a.id = :id
            """)
    public Optional<String> findImageUrlFromId(
            @Param("id") Integer id
    );
}
