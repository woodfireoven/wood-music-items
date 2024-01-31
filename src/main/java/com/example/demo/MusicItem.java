package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class MusicItem {

    private @Id @GeneratedValue Long id;
    private String name;
    private String artist_group;
    private String genre;

    MusicItem() {}

    MusicItem(String name, String artist_group, String genre) {

        this.name = name;
        this.artist_group = artist_group;
        this.genre = genre;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getArtist_group() {
        return this.artist_group;
    }

    public String getGenre(){
        return this.genre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist_group(String artist_group) {
        this.artist_group = artist_group;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }


    /*@Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof MusicItem))
            return false;
        MusicItem item = (MusicItem) o;
        return Objects.equals(this.id, item.id) && Objects.equals(this.name, item.name)
                && Objects.equals(this.artist_group, item.artist_group)
                && Objects.equals(this.genre, item.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.artist_group, this.genre);
    }

    @Override
    public String toString() {
        return "MusicItem{" + "id=" + this.id + ", name='" + this.name + '\'' + ", artist_group='" + this.artist_group
                + '\'' + "genre='" + this.genre + '\'' + '}';
    }*/
}
