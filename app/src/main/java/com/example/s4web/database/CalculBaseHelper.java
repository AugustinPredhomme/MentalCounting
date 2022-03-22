package com.example.s4web.database;

import android.content.Context;

public class CalculBaseHelper extends DataBaseHelper {

    public CalculBaseHelper(Context context) {
        super(context, "historique", 1);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS calculs  (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                CalculDB.StatsPremierElement + " DOUBLE NOT NULL," +
                CalculDB.StatsDeuxiemeElement + " DOUBLE NOT NULL," +
                CalculDB.StatsSymbole + " VARCHAR(255) NOT NULL," +
                CalculDB.StatsResultat + " DOUBLE NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
