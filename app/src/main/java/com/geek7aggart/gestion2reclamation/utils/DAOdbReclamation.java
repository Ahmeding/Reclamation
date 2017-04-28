
package com.geek7aggart.gestion2reclamation.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.geek7aggart.gestion2reclamation.Model.Reclamation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BARA' on 07/05/2016.
 */
public class DAOdbReclamation {
   private  SQLiteDatabase database;
    private DBhelper dBhelper;

    public DAOdbReclamation(Context context){
        dBhelper = new DBhelper(context);
        database = dBhelper.getWritableDatabase();
         }
    public void close(){
        dBhelper.close();
    }
 //  COLUMN_TITRE + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_DESC + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_REF + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_CLIENT + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_ADRESSE + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_CONTACT_TEL + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_RG + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_SR + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_TETE + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_AMORCE + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_COULEUR + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_DATETIME_REC + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_DATE_INTERVENTIEN + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_SGNL_PAR + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_OBSERV_INIT + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_OBSERV_TECH + TEXT_TYPE + COMMA_SEP +
 //  COLUMN_ETAT + TEXT_TYPE + ")";

    public long addReclamation(Reclamation reclamation){
        ContentValues contentValues =new ContentValues();
        contentValues.put(dBhelper.COLUMN_TITRE_REC,reclamation.getTitre());
        contentValues.put(dBhelper.COLUMN_REF_REC,reclamation.getRefRec());
        contentValues.put(dBhelper.COLUMN_CLIENT_REC, reclamation.get_client());
        contentValues.put(dBhelper.COLUMN_ADRESSE_REC,reclamation.getAdresse());
        contentValues.put(dBhelper.COLUMN_CONTACT_TEL_REC,reclamation.getContactTel());
        contentValues.put(dBhelper.COLUMN_DATETIME_REC,reclamation.getDateRec());
        contentValues.put(dBhelper.COLUMN_SGNL_PAR_REC,reclamation.getSgnlPar());
        contentValues.put(dBhelper.COLUMN_OBSERV_INIT_REC,reclamation.getObservInit());
        contentValues.put(dBhelper.COLUMN_OBSERV_TECH_REC, reclamation.getObserveTech());
        contentValues.put(dBhelper.COLUMN_DESC_REC,reclamation.getDescription());
        contentValues.put(dBhelper.COLUMN_ETAT_REC,reclamation.getEtat());

        return database.insert(dBhelper.TABLE_RECLAMATION,null,contentValues);

    }


    public boolean updateReclamation(Reclamation reclamation) {


        String whereClause = dBhelper.COLUMN_ID_REC + "=?";
        String[] whereArgs = new String[]{String.valueOf(reclamation.getIdReclamation())};
        ContentValues contentValues = new ContentValues();
        contentValues.put(dBhelper.COLUMN_TITRE_REC,reclamation.getTitre());
        contentValues.put(dBhelper.COLUMN_DESC_REC,reclamation.getDescription());
        contentValues.put(dBhelper.COLUMN_REF_REC,reclamation.getRefRec());
        contentValues.put(dBhelper.COLUMN_CLIENT_REC, reclamation.get_client());
        contentValues.put(dBhelper.COLUMN_ADRESSE_REC,reclamation.getAdresse());
        contentValues.put(dBhelper.COLUMN_CONTACT_TEL_REC,reclamation.getContactTel());
        contentValues.put(dBhelper.COLUMN_DATETIME_REC,reclamation.getDateRec());
        contentValues.put(dBhelper.COLUMN_SGNL_PAR_REC,reclamation.getSgnlPar());
        contentValues.put(dBhelper.COLUMN_OBSERV_INIT_REC,reclamation.getObservInit());
        contentValues.put(dBhelper.COLUMN_OBSERV_TECH_REC, reclamation.getObserveTech());
        contentValues.put(dBhelper.COLUMN_ETAT_REC,reclamation.getEtat());

        database.update(dBhelper.TABLE_RECLAMATION, contentValues, whereClause, whereArgs);
        return true;
    }

public void deleteReclamation (Reclamation reclamation){

    String whereClause = dBhelper.COLUMN_ID_REC+"=?";
    String []whereArgs=new String[]{String.valueOf(reclamation.getIdReclamation())};

    database.delete(dBhelper.TABLE_RECLAMATION, whereClause, whereArgs);
}

    public List<Reclamation> getReclamations(){
        List<Reclamation> reclamations= new ArrayList<>();
        Cursor cursor = database.query(dBhelper.TABLE_RECLAMATION,null,null,null,null,null,dBhelper.COLUMN_ID_REC+" DESC");
                cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Reclamation reclamation= cursorToReclamtion(cursor);
            reclamations.add(reclamation);
            cursor.moveToNext();
        }
        cursor.close();
        return reclamations;
    }

    private Reclamation cursorToReclamtion(Cursor cursor) {

        Reclamation reclamation = new Reclamation();
        reclamation.setIdReclamation(cursor.getColumnIndex(dBhelper.COLUMN_ID_REC));
        reclamation.setTitre(cursor.getString(cursor.getColumnIndex(dBhelper.COLUMN_TITRE_REC)));
        reclamation.setDateRec(cursor.getString((cursor.getColumnIndex(dBhelper.COLUMN_DATETIME_REC))));
        reclamation.setDescription(cursor.getString(cursor.getColumnIndex(dBhelper.COLUMN_DESC_REC)));
        reclamation.setEtat(cursor.getString(cursor.getColumnIndex(dBhelper.COLUMN_ETAT_REC)));
        reclamation.setRefRec(cursor.getString(cursor.getColumnIndex(dBhelper.COLUMN_REF_REC)));
        reclamation.set_client(cursor.getString((cursor.getColumnIndex(dBhelper.COLUMN_CLIENT_REC))));
        reclamation.setContactTel(cursor.getString(cursor.getColumnIndex(dBhelper.COLUMN_CONTACT_TEL_REC)));
        reclamation.setSgnlPar(cursor.getString((cursor.getColumnIndex(dBhelper.COLUMN_SGNL_PAR_REC))));
        reclamation.setObservInit(cursor.getString(cursor.getColumnIndex(dBhelper.COLUMN_OBSERV_INIT_REC)));
        reclamation.setObserveTech(cursor.getString(cursor.getColumnIndex(dBhelper.COLUMN_OBSERV_TECH_REC)));

        return reclamation;
    }
}





















