package com.testing.system.model;


import javax.persistence.*;

@Entity
@Table(name="link")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int linkId;
    String link;

    @OneToOne
    @JoinColumn(name = "literatureId")
    Literature literature;

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Literature getLiterature() {
        return literature;
    }

    public void setLiterature(Literature literature) {
        this.literature = literature;
    }
}
