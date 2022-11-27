package com.springfilmproject.springfilmproject.repository;

import com.springfilmproject.springfilmproject.model.Kullanici;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface KullaniciRepository extends JpaRepository<Kullanici,Long> {

    @Override
    List<Kullanici> findAll();

    @Override
    List<Kullanici> findAll(Sort sort);

    @Override
    List<Kullanici> findAllById(Iterable<Long> longs);

    @Override
    <S extends Kullanici> List<S> saveAll(Iterable<S> entities);

    @Override
    void flush();

    @Override
    <S extends Kullanici> S saveAndFlush(S entity);

    @Override
    <S extends Kullanici> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Kullanici> entities) {

    }

    @Override
    void deleteAllInBatch(Iterable<Kullanici> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Kullanici getOne(Long aLong);

    @Override
    Kullanici getById(Long aLong);

    @Override
    Kullanici getReferenceById(Long aLong);

    @Override
    <S extends Kullanici> List<S> findAll(Example<S> example);

    @Override
    <S extends Kullanici> List<S> findAll(Example<S> example, Sort sort);

    @Override
    Page<Kullanici> findAll(Pageable pageable);

    @Override
    <S extends Kullanici> S save(S entity);

    @Override
    Optional<Kullanici> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Kullanici entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Kullanici> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Kullanici> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Kullanici> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Kullanici> long count(Example<S> example);

    @Override
    <S extends Kullanici> boolean exists(Example<S> example);

    @Override
    <S extends Kullanici, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
