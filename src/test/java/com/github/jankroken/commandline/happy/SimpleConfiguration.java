package com.github.jankroken.commandline.happy;

import com.github.jankroken.commandline.annotations.*;

public class SimpleConfiguration {

    private String filename;
    private boolean verbose;

    public String getFilename() {
        return filename;
    }

    @Option
    @LongSwitch("filename")
    @ShortSwitch("f")
    @SingleArgument
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean getVerbose() {
        return verbose;
    }

    @Option
    @LongSwitch("verbose")
    @ShortSwitch("v")
    @Toggle(true)
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

}
