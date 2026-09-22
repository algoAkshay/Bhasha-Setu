package com.bhashasetu.repository;
import com.bhashasetu.model.Scheme; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param; import java.util.*;
public interface SchemeRepository extends JpaRepository<Scheme,Long> {
 @EntityGraph(attributePaths="rules") List<Scheme> findByActiveTrueOrderByNameAsc();
 @EntityGraph(attributePaths="rules") Optional<Scheme> findWithRulesById(Long id);
 @EntityGraph(attributePaths="rules") Optional<Scheme> findBySourceKey(String sourceKey);
 @Query("select s from Scheme s where s.active=true and lower(s.name) like lower(concat('%',:q,'%')) order by s.name") List<Scheme> searchActive(@Param("q") String q);
}
