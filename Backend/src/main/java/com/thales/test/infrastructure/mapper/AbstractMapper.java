package com.thales.test.infrastructure.mapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This abstract class represents a mapper for converting between domain and entity objects.
 * It provides methods to convert single objects, lists, sets, and pages.
 *
 * @param <D> The domain object type.
 * @param <E> The entity object type.
 *
 * @author David Corredor R. - dgcorredorr@gmail.com
 */
public abstract class AbstractMapper<D, E> {

    public abstract D toDomain(E entity);

    public abstract E toEntity(D dto);

    public List<D> toDomainList(List<E> entityList) {
        return (entityList != null) ? entityList.stream()
                .map(this::toDomain)
                .collect(Collectors.toList()) : null;
    }

    public List<E> toEntityList(List<D> dtoList) {
        return (dtoList != null) ? dtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList()) : null;
    }

    public Set<D> toDomainSet(Set<E> entitySet) {
        return (entitySet != null) ? entitySet.stream()
                .map(this::toDomain)
                .collect(Collectors.toSet()) : null;
    }

    public Set<E> toEntitySet(Set<D> dtoSet) {
        return (dtoSet != null) ? dtoSet.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet()) : null;
    }

    public Page<D> toDomainPage(Page<E> entityPage) {
        return entityPage.map(this::toDomain);
    }
}
