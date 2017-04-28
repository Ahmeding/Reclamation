package com.geek7aggart.gestion2reclamation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.geek7aggart.gestion2reclamation.Model.Reclamation;

import org.json.JSONException;
import org.json.JSONObject;

public class InterventionActivity extends AppCompatActivity {

    private String keyIntent;
    private Reclamation reclamation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervention);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle KEY_INTENT_bundle = getIntent().getExtras();
        if (KEY_INTENT_bundle != null) {
            keyIntent = KEY_INTENT_bundle.getString("REC");
        }

        reclamation = getRec(keyIntent);


    }

    private Reclamation getRec(String keyIntent) {
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(keyIntent);
            return (new Reclamation(
                  // jsonObj.getInt("idReclamation"),
                  // jsonObj.getString("titre"),
                  // jsonObj.getString("ref"),
                  // jsonObj.getString("_client"),
                  // jsonObj.getString("adresse"),
                  // jsonObj.getString("contactTel"),
                  // jsonObj.getString("_RG"),
                  // jsonObj.getString("_SR"),
                  // jsonObj.getString("_tete"),
                  // jsonObj.getString("_amorce"),
                  // jsonObj.getString("_couleur"),
                  // jsonObj.getString("dateRec"),
                  // jsonObj.getString("sgnlPar"),
                  // jsonObj.getString("observInit"),
                  // jsonObj.getString("observeTech"),
                  // jsonObj.getString("description"),
                  // jsonObj.getString("datetimeIntervention"),
                  // jsonObj.getString("etat")
            ));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}