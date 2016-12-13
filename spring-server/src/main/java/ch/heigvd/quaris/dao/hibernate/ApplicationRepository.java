package ch.heigvd.quaris.dao.hibernate;

import ch.heigvd.quaris.model.Application;

public class ApplicationRepository implements ch.heigvd.quaris.dao.ApplicationRepository {

    public Application findByName(String name) {
        return null;
    }

    @Override
    public <S extends Application> S save(S s) {
        return null;
    }

    @Override
    public <S extends Application> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Application findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Application> findAll() {
        return null;
    }

    @Override
    public Iterable<Application> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Application application) {

    }

    @Override
    public void delete(Iterable<? extends Application> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
