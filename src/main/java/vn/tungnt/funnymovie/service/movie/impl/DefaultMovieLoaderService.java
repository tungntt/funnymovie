package vn.tungnt.funnymovie.service.movie.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author nttung 11/5/19
 * @project funnymovie
 */
@Service
public class DefaultMovieLoaderService implements MovieLoaderService {

    private Logger log = LoggerFactory.getLogger(DefaultMovieLoaderService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;

    private static final Pattern YOUTUBE_VIDEO_ID_REGEX = Pattern.compile("(?:[?&]v=|\\/embed\\/|\\/1\\/|\\/v\\/)([^&\\n?#]+)");


    @Override
    public boolean saveMovie(final MovieDTO movieDTO) {
        Matcher matcher = YOUTUBE_VIDEO_ID_REGEX.matcher(movieDTO.getUrl());
        if (matcher.find()) {
            String group = matcher.group(1);
            Movie movie = this.movieMapper.toEntity(movieDTO);
            movie.setVideoId(matcher.group(1));
            userRepository.findOneByEmailIgnoreCase(movieDTO.getSharedBy()).ifPresent(existingUser -> {
                movie.setUser(existingUser);
            });
            movieRepository.save(movie);
            log.debug("Created Sharing movie: {}", movie);
            return true;
        }
        return false;
    }

    @Override
    public Page<MovieDTO> getAllMovies(final Pageable pageable) {
        Page<Movie> page = movieRepository.findAll(pageable);
        return page.map(this.movieMapper::toDto);
    }
}

