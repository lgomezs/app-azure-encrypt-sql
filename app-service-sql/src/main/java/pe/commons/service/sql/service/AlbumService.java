package pe.commons.service.sql.service;

import pe.commons.service.sql.domaim.Album;

import java.util.List;


public interface AlbumService {

    List<Album> findAll();

    void save(Album entity);


}
