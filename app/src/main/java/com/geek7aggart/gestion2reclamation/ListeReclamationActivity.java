
package com.geek7aggart.gestion2reclamation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.geek7aggart.gestion2reclamation.Adapters.ReclamationAdapter;
import com.geek7aggart.gestion2reclamation.Model.Reclamation;
import com.geek7aggart.gestion2reclamation.utils.DAOdbReclamation;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ListeReclamationActivity extends AppCompatActivity {

    ListView lvRec;
    ArrayList<Reclamation> reclamations;
    Reclamation reclamation, reclamation1, reclamation2, reclamation3, reclamation4, reclamation5, reclamation6,
            reclamation7, reclamation8, reclamation9, reclamation10, reclamation11, reclamation13, reclamation14, reclamation15, reclamation16, reclamation12;
    private DAOdbReclamation daOdbReclamation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_reclamation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        reclamations = new ArrayList<>();
        intiDAOREC();

        reclamation = new Reclamation();
        reclamation.setEtat("ok");
        reclamation.setDescription("panne grave");
        reclamation.setTitre("Panne generale");
        reclamation.setDateRec("12-12-2016");
        reclamation.setIdReclamation(1);

        reclamations.add(reclamation);
     //   reclamations.add(reclamation1);
     //   reclamations.add(reclamation2);
     //   reclamations.add(reclamation3);
     //   reclamations.add(reclamation4);
     //   reclamations.add(reclamation5);
     //   reclamations.add(reclamation6);
     //   reclamations.add(reclamation7);
     //   reclamations.add(reclamation8);
//
     //   reclamations.add(reclamation9);
     //   reclamations.add(reclamation10);
     //   reclamations.add(reclamation11);
     //   reclamations.add(reclamation12);
     //   reclamations.add(reclamation13);
     //   reclamations.add(reclamation14);
     //   reclamations.add(reclamation15);
     //   reclamations.add(reclamation16);


        lvRec = (ListView) findViewById(R.id.listVRec);
        ReclamationAdapter reclamationAdapter = new ReclamationAdapter(this, R.layout.raw_layout, reclamations);
        lvRec.setAdapter(reclamationAdapter);
        addItemClickListener(lvRec);
    }
    public void intiDAOREC() {
        daOdbReclamation = new DAOdbReclamation(this);
        for (Reclamation r : daOdbReclamation.getReclamations()) {
            reclamations.add(r);
        }
    }
    private void addItemClickListener(final ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Reclamation reclamation = (Reclamation) listView.getItemAtPosition(position);
                Intent intent = new Intent(ListeReclamationActivity.this, ReclamtionActivity.class);
                intent.putExtra("REC", (new Gson().toJson(reclamation)));
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add:

                startActivity(new Intent(this, AjouterActivity.class));
                toast("add");
                return true;

        }
        return false;


    }

    public void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    } //end toasttt


    }
