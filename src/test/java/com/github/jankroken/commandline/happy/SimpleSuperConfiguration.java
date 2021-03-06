package com.github.jankroken.commandline.happy;

import com.github.jankroken.commandline.annotations.*;

public class SimpleSuperConfiguration {

    private String logfile;
    private boolean verbose;
    private AlbumConfiguration album;


    @Option
    @LongSwitch("logfile")
    @ShortSwitch("l")
    @SingleArgument
    public void setFilename(String logfile) {
        this.logfile = logfile;
    }

    @Option
    @LongSwitch("verbose")
    @ShortSwitch("v")
    @Toggle(true)
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    @Option
    @LongSwitch("album")
    @ShortSwitch("a")
    @SubConfiguration(AlbumConfiguration.class)
    public void setAlbum(AlbumConfiguration album) {
        this.album = album;
    }

    public boolean getVerbose() {
        return verbose;
    }

    public String getLogfile() {
        return logfile;
    }

    public AlbumConfiguration getAlbum() {
        return album;
    }
}
