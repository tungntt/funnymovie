package vn.tungnt.funnymovie.web.rest;

import io.github.jhipster.web.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vn.tungnt.funnymovie.service.dto.MovieDTO;
import vn.tungnt.funnymovie.service.movie.MovieLoaderService;

import java.util.List;
import java.util.regex.Pattern;


/**
 * @author nttung 11/5/19
 * @project funnymovie
 */
@RestController
@RequestMapping("/api/movie")
public class MovieResource {

    @Autowired
    private MovieLoaderService movieLoaderService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getByDates(Pageable pageable) {
        Page<MovieDTO> movies = movieLoaderService.getAllMovies(pageable);
        HttpHeaders headers = PaginationUtil
            .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), movies);
        return new ResponseEntity<>(movies.getContent(), headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> saveMovieUrl(@RequestBody MovieDTO movieRequest) {
        boolean isSaved = this.movieLoaderService.saveMovie(movieRequest);
        return ResponseEntity.ok(isSaved);
    }
}

