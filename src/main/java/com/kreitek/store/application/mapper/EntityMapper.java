package com.kreitek.store.application.mapper;

import java.util.List;

//Mapper genérico en cargado de transformar entidades a DTO's y viceversa
public interface EntityMapper <D, E> {

    //Transforma un DTO a una Entidad
    E toEntity(D dto);

    //Transforma una entidad a un DTO
    D toDto(E entity);

    //Transforma una lista de DTO's a entidades
    List<E> toEntity(List<D> dto);

    //Transforma una lista de entidades a DTO's
    List<D> toDto(List<E> entity);
}
