package vn.tungnt.funnymovie.service.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.tungnt.funnymovie.service.dto.MovieDTO;


/**
 * @author nttung 11/5/19
 * @project funnymovie
 */
public interface MovieLoaderService {

    boolean saveMovie(final MovieDTO movieDTO);

    Page<MovieDTO> getAllMovies(final Pageable pageable);
}
