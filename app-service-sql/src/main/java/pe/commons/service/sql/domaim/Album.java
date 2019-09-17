package pe.commons.service.sql.domaim;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Album  implements Serializable {
    private static final long serialVersionUID = 8229740159209213042L;
    @Id
    @Column(name = "id")
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;
    @Column(name = "release_year")
    private String releaseYear;
    @Column(name = "genre")
    private String genre;
    @Column(name = "track_count")
    private int trackCount;

    public Album() {
    }


    public Album(String title, String artist, String releaseYear, String genre) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

}
