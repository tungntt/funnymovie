package vn.tungnt.funnymovie.service.mapper;

import java.util.List;


/**
 * @author nttung 11/5/19
 * @project funnymovie
 */
public interface EntityMapper <D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List <D> toDto(List<E> entityList);
}
