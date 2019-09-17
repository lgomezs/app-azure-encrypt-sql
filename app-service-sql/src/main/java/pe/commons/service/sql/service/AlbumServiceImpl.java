package pe.commons.service.sql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.commons.service.sql.domaim.Album;
import pe.commons.service.sql.dao.AlbumDAO;

import java.util.List;

@Service
public class AlbumServiceImpl implements  AlbumService{

    @Autowired
    private AlbumDAO albumDAO;

    @Override
    public List<Album> findAll() {
        return albumDAO.findAll();
    }

    @Override
    public void save(Album entity) {
        albumDAO.save(entity);
    }


}
