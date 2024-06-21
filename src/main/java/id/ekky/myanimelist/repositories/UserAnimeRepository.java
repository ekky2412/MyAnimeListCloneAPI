package id.ekky.myanimelist.repositories;

import id.ekky.myanimelist.models.UserAnime;
import id.ekky.myanimelist.models.UserAnimeId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAnimeRepository extends JpaRepository<UserAnime, UserAnimeId> {
    @Query("""
            SELECT ua
            FROM UserAnime ua
            WHERE ua.id.userId = :userId
            ORDER BY ua.id.animeId
            """)
    public Page<UserAnime> findAllByUserId(
            Pageable pageable,
            @Param("userId") Integer userId
    );

    @Query("""
            SELECT ua
            FROM UserAnime ua 
            WHERE ua.id.animeId = :animeId 
            ORDER BY ua.id.animeId
            """)
    public Page<UserAnime> findAllByAnimeId(
            Pageable pageable,
            @Param("animeId") Integer animeId
    );
}
