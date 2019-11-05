package vn.tungnt.funnymovie.service.dto;

import lombok.Data;


/**
 * @author nttung 11/5/19
 * @project funnymovie
 */
public class MovieDTO {

    private String title;

    private String url;

    private String sharedBy;

    private String description;

    private int voteUp;

    private int voteDown;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(final String url)
    {
        this.url = url;
    }

    public String getSharedBy()
    {
        return sharedBy;
    }

    public void setSharedBy(final String sharedBy)
    {
        this.sharedBy = sharedBy;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public int getVoteUp()
    {
        return voteUp;
    }

    public void setVoteUp(final int voteUp)
    {
        this.voteUp = voteUp;
    }

    public int getVoteDown()
    {
        return voteDown;
    }

    public void setVoteDown(final int voteDown)
    {
        this.voteDown = voteDown;
    }
}

