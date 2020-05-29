package repositories.interfaces;

public interface BaseRepository <T,ID>{

    void save(T entity);

    void delete(ID id);

    T getById(ID id );
}
