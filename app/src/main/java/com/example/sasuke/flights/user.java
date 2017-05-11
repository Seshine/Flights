package com.example.sasuke.flights;

/**
 * Created by sasuke on 5/10/2017.
 */

class user {
    String from;
    String to;
    String plain;
    String btime;
    String bItime;
    String dtime;
    String atime;

    String terminal;
    String gate;
    String seat;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getPlain() {
        return plain;
    }

    public String getBtime() {
        return btime;
    }

    public String getbItime() {
        return bItime;
    }

    public String getDtime() {
        return dtime;
    }

    public String getAtime() {
        return atime;
    }

    public String getTerminal() {
        return terminal;
    }

    public String getGate() {
        return gate;
    }

    public String getSeat() {
        return seat;
    }

    public user(){

     }
    public user(String from, String to, String plain, String btime, String bItime, String dtime, String atime, String terminal, String gate, String seat) {
        this.from = from;
        this.to = to;
        this.plain = plain;
        this.btime = btime;
        this.bItime = bItime;
        this.dtime = dtime;
        this.atime = atime;
        this.terminal = terminal;
        this.gate = gate;
        this.seat = seat;
    }
}
