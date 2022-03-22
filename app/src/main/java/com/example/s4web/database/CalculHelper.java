package com.example.s4web.database;

import com.example.s4web.entity.Calcul;

public class CalculHelper {
    private CalculDB CalculDB;

    public CalculHelper(CalculDB CalculDB) {
        this.CalculDB = CalculDB;
    }

    public void storeInDB(Calcul calcul){
        CalculDB.create(calcul);
    }
}
