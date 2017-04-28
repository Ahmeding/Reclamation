
package com.geek7aggart.gestion2reclamation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.geek7aggart.gestion2reclamation.Model.Intervention;
import com.geek7aggart.gestion2reclamation.Model.Reclamation;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class ReclamtionActivity extends AppCompatActivity {

    TextView tvAffTitre,tvAffDesc,tvAffDate,tvAffEtat;
    String keyIntent;
    Reclamation reclamation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamtion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        reclamation = new Reclamation();
        tvAffTitre = (TextView) findViewById(R.id.tv_AffRecTitre);
        tvAffDesc = (TextView) findViewById(R.id.tv_AffRecDesc);
        tvAffEtat = (TextView) findViewById(R.id.tv_AffRecEtat);
        tvAffDate = (TextView) findViewById(R.id.tv_AffRecDate);

        Bundle KEY_INTENT_bundle = getIntent().getExtras();
        if(KEY_INTENT_bundle!=null){
            keyIntent=KEY_INTENT_bundle.getString("REC");
        }
        Log.i("---------","------------------------------------>"+keyIntent);

        reclamation=getRec(keyIntent);

        tvAffTitre.setText(String.valueOf(reclamation.getTitre()));
       tvAffDesc.setText(reclamation.getDescription());
       tvAffEtat.setText(reclamation.getEtat());
       tvAffDate.setText(reclamation.getDateRec());

    }

    private Reclamation getRec(String keyIntent)  {
        JSONObject jsonObj ;
        try {
            jsonObj = new JSONObject(keyIntent);
            return (new Reclamation(
                  jsonObj.getInt("idReclamation"),
                  jsonObj.getString("titre"),
                 /* jsonObj.getString("refRec"),
                  jsonObj.getString("_client"),
                  jsonObj.getString("adresse"),
                  jsonObj.getString("contactTel"),*/
                  jsonObj.getString("dateRec"),
                 /* jsonObj.getString("sgnlPar"),
                  jsonObj.getString("observInit"),
                  jsonObj.getString("observeTech"),*/
                  jsonObj.getString("description"),
                  jsonObj.getString("etat")
            ));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_add:

                startActivity(new Intent(this,AjouterActivity.class));
                toast("add");
                return true;
            case R.id.action_edit:

                Intent intent = new Intent(ReclamtionActivity.this, ModifierActivity.class);
                intent.putExtra("REC", (new Gson().toJson(reclamation)));
                startActivity(intent);

                toast("edite");
                return true;

        }
        return false;


    }
    public void btnActionOnclick(View v){
        Intent intent = new Intent(ReclamtionActivity.this, Intervention.class);
      //  intent.putExtra("REC", (new Gson().toJson(reclamation)));
        startActivity(intent);
    }

    public void btnEffacerOnclick(View v){
        /*DAOdbReclamation db = new DAOdbReclamation((this));
        db.deleteReclamation(reclamation);
        db.close();*/
        toast("EFFACER !");
        startActivity(new Intent(this, ListeReclamationActivity.class));
        finish();
    }
    public void btnRetourOnclick(View v){

        toast("Retour!");
        startActivity(new Intent(this, ListeReclamationActivity.class));
        finish();
    }
    public void toast(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    } //en
}
