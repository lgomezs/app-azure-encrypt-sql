package pe.commons.service.sql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.commons.service.sql.domaim.Album;

@Repository
public interface AlbumDAO extends JpaRepository<Album,Long> {



}
