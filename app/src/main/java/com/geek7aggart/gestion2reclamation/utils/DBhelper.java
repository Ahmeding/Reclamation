
package com.geek7aggart.gestion2reclamation.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BARA' on 07/04/2016.
 */
public class DBhelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "sqliteReclamtion.db";
    public static final int DB_VERSION = 1;

    public static final String COMMA_SEP = ",";
    public static final String TEXT_TYPE = " TEXT";
    public static final String NUMERIC_TYPE = " INTEGER ";

    public static final String TABLE_PERSONEL = "personnel";
    public static final String TABLE_RECLAMATION = "reclamation";
    public static final String TABLE_INTERVENTION = "intervention";

//Colone Personnel

    public static final String COLUMN_IDPERS = "_id";
    public static final String COLUMN_NOM = "nom";
    public static final String COLUMN_PRENOM = "prenom";
    public static final String COLUMN_LOGIN = "login";
    public static final String COLUMN_PASSWORD = "password";


    //REQUET CREATION TABLE PERSONNEL
    private static final String DELETE_TABLEPERS = "DROP TABLE IF EXISTE " + TABLE_PERSONEL;
    private static final String CREATE_TABLEPERS = "CREATE TABLE " + TABLE_PERSONEL + "(" +
            COLUMN_IDPERS + NUMERIC_TYPE + " PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
            COLUMN_NOM + TEXT_TYPE + COMMA_SEP +
            COLUMN_PRENOM + TEXT_TYPE + COMMA_SEP +
            COLUMN_LOGIN + TEXT_TYPE + COMMA_SEP +
            COLUMN_PASSWORD + TEXT_TYPE +
            ")";

    //Colone Reclamation
    public static final String COLUMN_ID_REC = "_id";
    public static final String COLUMN_TITRE_REC = "titre";
    public static final String COLUMN_DESC_REC = "description";
    public static final String COLUMN_DATETIME_REC = "datetimeRec";
    public static final String COLUMN_ETAT_REC = "etat";
    public static final String COLUMN_REF_REC = "ref";
    public static final String COLUMN_CLIENT_REC = "client";
    public static final String COLUMN_ADRESSE_REC = "adresse";
    public static final String COLUMN_CONTACT_TEL_REC = "contacttel";
    public static final String COLUMN_SGNL_PAR_REC = "snglPar";
    public static final String COLUMN_OBSERV_INIT_REC = "observinit";
    public static final String COLUMN_OBSERV_TECH_REC = "obseevtechR";


//REQUET CREATION TABLE RECLAMATION

    private static final String DELETE_TABLEREC = "DROP TABLE IF EXISTE " + TABLE_RECLAMATION;
    private static final String CREATE_TABLEREC = "CREATE TABLE " + TABLE_RECLAMATION + "(" +
            COLUMN_ID_REC + NUMERIC_TYPE + " PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
            COLUMN_TITRE_REC + TEXT_TYPE + COMMA_SEP +
            COLUMN_DESC_REC + TEXT_TYPE + COMMA_SEP +
            COLUMN_REF_REC + TEXT_TYPE + COMMA_SEP +
            COLUMN_CLIENT_REC + TEXT_TYPE + COMMA_SEP +
            COLUMN_ADRESSE_REC + TEXT_TYPE + COMMA_SEP +
            COLUMN_CONTACT_TEL_REC + TEXT_TYPE + COMMA_SEP +
            COLUMN_DATETIME_REC + TEXT_TYPE + COMMA_SEP +
            COLUMN_SGNL_PAR_REC + TEXT_TYPE + COMMA_SEP +
            COLUMN_OBSERV_INIT_REC + TEXT_TYPE + COMMA_SEP +
            COLUMN_OBSERV_TECH_REC + TEXT_TYPE + COMMA_SEP +
            COLUMN_ETAT_REC + TEXT_TYPE + ")";


    //Colone Intervaention
    public static final String COLUMN_ID_INTER = "_id";
    public static final String COLUMN_REF_INTER = "ref";
    public static final String COLUMN_DESC_INTER = "description";
    public static final String COLUMN_RG = "rg";
    public static final String COLUMN_SR = "sr";
    public static final String COLUMN_TETE = "tete";
    public static final String COLUMN_AMORCE = "amorce";
    public static final String COLUMN_COULEUR = "couleur";
    public static final String COLUMN_DATE_INTER = "date_intervention";
    public static final String COLUMN_ETAT_PANE = "etat";
    public static final String COLUMN_ID_IR = "idInterRec";


//REQUET CREATION TABLE Intervention

    private static final String DELETE_TABLEINT = "DROP TABLE IF EXISTE " + TABLE_INTERVENTION;
    private static final String CREATE_TABLEINT = "CREATE TABLE " + TABLE_INTERVENTION + "(" +
            COLUMN_ID_INTER + NUMERIC_TYPE + " PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
            COLUMN_REF_INTER + TEXT_TYPE + COMMA_SEP +
            COLUMN_DESC_INTER + TEXT_TYPE + COMMA_SEP +
            COLUMN_RG + TEXT_TYPE + COMMA_SEP +
            COLUMN_SR + TEXT_TYPE + COMMA_SEP +
            COLUMN_TETE + TEXT_TYPE + COMMA_SEP +
            COLUMN_AMORCE + TEXT_TYPE + COMMA_SEP +
            COLUMN_COULEUR + TEXT_TYPE + COMMA_SEP +
            COLUMN_DATE_INTER + TEXT_TYPE + COMMA_SEP +
            COLUMN_ETAT_PANE + TEXT_TYPE +COMMA_SEP +
            COLUMN_ID_IR + NUMERIC_TYPE +COMMA_SEP +
            " FOREIGN KEY(" + COLUMN_ID_IR + ")" +
            " REFERENCES "+TABLE_RECLAMATION+"( " + COLUMN_ID_REC + " )" +
            ");";

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating required tables
        db.execSQL(CREATE_TABLEPERS);
        db.execSQL(CREATE_TABLEREC);
        db.execSQL(CREATE_TABLEINT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DELETE_TABLEPERS);
        db.execSQL(DELETE_TABLEREC);
        db.execSQL(DELETE_TABLEINT);
        onCreate(db);
    }
}
