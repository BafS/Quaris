package ch.heigvd.quaris.dao.hibernate;

import ch.heigvd.quaris.model.EndUser;

public class EndUserRepository implements ch.heigvd.quaris.dao.EndUserRepository {

    @Override
    public EndUser findByApplicationNameAndIdInApplication(String targetApplicationName, String targetEndUserId) {
        return null;
    }

    @Override
    public <S extends EndUser> S save(S s) {
        return null;
    }

    @Override
    public <S extends EndUser> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public EndUser findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<EndUser> findAll() {
        return null;
    }

    @Override
    public Iterable<EndUser> findAll(Iterable<Long> iterable) {
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
    public void delete(EndUser endUser) {

    }

    @Override
    public void delete(Iterable<? extends EndUser> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
