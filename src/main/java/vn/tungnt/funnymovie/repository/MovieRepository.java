package vn.tungnt.funnymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.tungnt.funnymovie.domain.Movie;


/**
 * @author nttung 11/5/19
 * @project funnymovie
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
