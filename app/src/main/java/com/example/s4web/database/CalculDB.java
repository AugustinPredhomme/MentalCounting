package com.example.s4web.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.s4web.entity.Calcul;

public class CalculDB extends BaseDao<Calcul> {
    static String StatsPremierElement = "PremierElement";
    static String StatsDeuxiemeElement = "DeuxiemeElement";
    static String StatsSymbole = "Symbole";
    static String StatsResultat = "Résultat";
    public CalculDB(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return "calculs";
    }

    @Override
    protected void putValues(ContentValues values, Calcul entity) {
        values.put(StatsPremierElement,entity.getPremierElement());
        values.put(StatsDeuxiemeElement,entity.getDeuxiemeElement());
        values.put(StatsSymbole,entity.getSymbole());
        values.put(StatsResultat,entity.getResultat());
    }

    @Override
    protected Calcul getEntity(Cursor cursor) {
        cursor.moveToFirst();
        Integer indexPremierElement = cursor.getColumnIndex(StatsPremierElement);
        Integer indexDeuxiemeElement = cursor.getColumnIndex(StatsDeuxiemeElement);
        Integer indexSymbole = cursor.getColumnIndex(StatsSymbole);
        Integer indexResultat = cursor.getColumnIndex(StatsResultat);
        Calcul calcul = new Calcul();
        calcul.setPremierElement(cursor.getInt(indexPremierElement));
        calcul.setDeuxiemeElement(cursor.getInt(indexDeuxiemeElement));
        calcul.setSymbole(cursor.getString(indexSymbole));
        calcul.setResultat(cursor.getInt(indexResultat));
        cursor.close();
        return calcul;
    }


}