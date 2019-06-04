package model;

import model.media.AbstractMedia;
import model.media.Movie;
import model.media.Photo;
import model.media.Song;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class iPod implements Iterable<AbstractMedia> {

    private String name;
    private Collection<AbstractMedia> media;

    public iPod(String name) {
        this.name = name;
        this.media = new ArrayList<>();
    }

    // getters
    public String getName() { return name; }

    public void addMedia(AbstractMedia media) {
        this.media.add(media);
    }

    @Override
    public Iterator<AbstractMedia> iterator() {
        return new iPodIterator();
    }

    private class iPodIterator implements Iterator<AbstractMedia> {
        Iterator mediaIterator = media.iterator();

        @Override
        public boolean hasNext() {
            return mediaIterator.hasNext();
        }

        @Override
        public AbstractMedia next() {
            return (AbstractMedia) mediaIterator.next();
        }

    }
}