package vn.tungnt.funnymovie.web.rest;

import io.github.jhipster.web.util.PaginationUtil;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vn.tungnt.funnymovie.security.AuthoritiesConstants;
import vn.tungnt.funnymovie.service.dto.MovieDTO;
import vn.tungnt.funnymovie.service.movie.MovieLoaderService;

import java.util.List;


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
}

