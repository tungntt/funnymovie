package vn.tungnt.funnymovie.service.movie.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tungnt.funnymovie.domain.Movie;
import vn.tungnt.funnymovie.repository.MovieRepository;
import vn.tungnt.funnymovie.repository.UserRepository;
import vn.tungnt.funnymovie.service.dto.MovieDTO;
import vn.tungnt.funnymovie.service.mapper.MovieMapper;
import vn.tungnt.funnymovie.service.movie.MovieLoaderService;


/**
 * @author nttung 11/5/19
 * @project funnymovie
 */
@Service
@Slf4j
public class DefaultMovieLoaderService implements MovieLoaderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;


    @Override
    public boolean saveMovie(final MovieDTO movieDTO) {
        Movie movie = this.movieMapper.toEntity(movieDTO);
        userRepository.findOneByEmailIgnoreCase(movieDTO.getSharedBy()).ifPresent(existingUser -> {
            movie.setUser(existingUser);
        });
        movieRepository.save(movie);
        log.debug("Created Sharing movie: {}", movie);
        return true;
    }

    @Override
    public Page<MovieDTO> getAllMovies(final Pageable pageable) {
        Page<Movie> page = movieRepository.findAll(pageable);
        return page.map(this.movieMapper::toDto);
    }
}

