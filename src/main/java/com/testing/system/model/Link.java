package com.testing.system.model;


import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link1 = (Link) o;
        return linkId == link1.linkId &&
                link.equals(link1.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId, link);
    }
}
