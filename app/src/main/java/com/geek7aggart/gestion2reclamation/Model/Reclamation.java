
package com.geek7aggart.gestion2reclamation.Model;

/**
 * Created by BARA' on 07/04/2016.
 */
public class Reclamation {

    private int idReclamation;
    private String
            titre,
            refRec="RefIM",
            _client="client",
            adresse,
            contactTel,
            dateRec,
    _RG,
    _SR,
    _tete,
    _amorce,
    _couleur,
            sgnlPar,
            observInit,
            observeTech,
            description,
            etat;


    public Reclamation() {
    }

    public Reclamation(
            int idReclamation,
                       String titre,
                       String refRec,
                       String _client,
                       String adresse,
                       String contactTel,
                       String dateRec,
                       String sgnlPar,
                       String observInit,
                       String observeTech,
                       String description,
                       String etat) {
        this.idReclamation = idReclamation;
        this.titre = titre;
        this.refRec = refRec;
        this._client = _client;
        this.adresse = adresse;
        this.contactTel = contactTel;
        this.dateRec = dateRec;
        this.sgnlPar = sgnlPar;
        this.observInit = observInit;
        this.observeTech = observeTech;
        this.description = description;
        this.etat = etat;
    }
//////////////////////////////////////////////////////////////////////


    public Reclamation(
            int idReclamation,
            String titre,
            String dateRec,
            String description,
            String etat) {
        this.idReclamation = idReclamation;
        this.titre = titre;
        this.dateRec = dateRec;
        this.description = description;
        this.etat = etat;
    }

    ///////////////////////////////////////////////////////////////
    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRefRec() {
        return refRec;
    }

    public void setRefRec(String refRec) {
        this.refRec = refRec;
    }

    public String get_client() {
        return _client;
    }

    public void set_client(String _client) {
        this._client = _client;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getDateRec() {
        return dateRec;
    }

    public void setDateRec(String dateRec) {
        this.dateRec = dateRec;
    }

    public String getSgnlPar() {
        return sgnlPar;
    }

    public void setSgnlPar(String sgnlPar) {
        this.sgnlPar = sgnlPar;
    }

    public String getObservInit() {
        return observInit;
    }

    public void setObservInit(String observInit) {
        this.observInit = observInit;
    }

    public String getObserveTech() {
        return observeTech;
    }

    public void setObserveTech(String observeTech) {
        this.observeTech = observeTech;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
