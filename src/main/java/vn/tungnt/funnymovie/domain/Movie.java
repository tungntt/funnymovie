package vn.tungnt.funnymovie.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author nttung 11/5/19
 * @project funnymovie
 */
@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="shared_by", nullable=false, referencedColumnName="email")
    private User user;

    @Column(name = "url")
    private String url;

    @Column(name = "video_id")
    private String videoId;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(final User user)
    {
        this.user = user;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(final String url)
    {
        this.url = url;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(final String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", user=" + user + ", url='" + url + '\'' + ", videoId='" + videoId + '\'' + '}';
    }
}

