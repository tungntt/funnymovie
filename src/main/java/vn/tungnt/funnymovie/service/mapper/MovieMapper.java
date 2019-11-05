package vn.tungnt.funnymovie.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.tungnt.funnymovie.domain.Movie;
import vn.tungnt.funnymovie.service.dto.MovieDTO;


/**
 * @author nttung 11/5/19
 * @project funnymovie
 */
@Mapper(componentModel = "spring", uses = {})
public interface MovieMapper extends EntityMapper<MovieDTO, Movie> {

    @Mapping(source = "user.email", target = "sharedBy")
    @Override
    MovieDTO toDto(Movie entity);

    @Mapping(source = "url", target = "url")
    @Mapping(source = "sharedBy", target = "user.email")
    @Override
    Movie toEntity(MovieDTO dto);
}
