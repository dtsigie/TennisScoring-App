package com.bignerdranch.android.tennisscoring;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Dawit on 9/4/2015.
 */
public class Stats implements Serializable {

    private int ace;
    private int fault;
    private int doubleFault;
    private int winner;
    private int forcedError;
    private int unforcedError;


    public Stats() {
        ace=0;
        fault=0;
        doubleFault=0;
        winner=0;
        forcedError=0;
        unforcedError=0;

    }

    public int getAce() {
        return ace;
    }

    public void setAce(int ace) {
        this.ace = ace;
    }

    public int getFault() {
        return fault;
    }

    public void setFault(int fault) {
        this.fault = fault;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getDoubleFault() {
        return doubleFault;
    }

    public void setDoubleFault(int doubleFault) {
        this.doubleFault = doubleFault;
    }

    public int getForcedError() {
        return forcedError;
    }

    public void setForcedError(int forcedError) {
        this.forcedError = forcedError;
    }

    public int getUnforcedError() {
        return unforcedError;
    }

    public void setUnforcedError(int unforcedError) {
        this.unforcedError = unforcedError;
    }
}
