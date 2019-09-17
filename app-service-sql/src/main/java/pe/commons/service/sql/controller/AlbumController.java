package pe.commons.service.sql.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.commons.service.sql.domaim.Album;
import pe.commons.service.sql.service.AlbumService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/albums")
public class AlbumController {
    private static final Logger logger = LoggerFactory.getLogger(AlbumController.class);
    @Autowired
    private AlbumService albumService;


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Album> albums() {
        return albumService.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Album add(@RequestBody @Valid Album album) {
        logger.info("Adding album " + album.getId());
        albumService.save(album);
        return album;
    }
}