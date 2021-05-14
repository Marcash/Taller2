package com.example.laboratorio1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class WelcomeActivity extends AppCompatActivity {

    private TextView id_welcome_user;

    private List<String> nombres;
    private GridView gridView;
    private MyAdapter myAdapter;
    private int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        id_welcome_user = (TextView)findViewById(R.id.id_welcome_user);
        String aux = getIntent().getStringExtra("usuario");
        id_welcome_user.setText("Bienvenido " + aux);

        gridView = (GridView) findViewById(R.id.gridView);
        nombres = new ArrayList<String>();
        nombres.add("Peluche");
        nombres.add("Kata");
        nombres.add("Sophia");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(WelcomeActivity.this, "clic en "+nombres.get(i), Toast.LENGTH_LONG).show();
            }
        });

        myAdapter = new MyAdapter(this, R.layout.grid_item, nombres);
        gridView.setAdapter(myAdapter);

        registerForContextMenu(gridView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_item:
                //agregamos un nuevo nombre
                this.nombres.add("nombre"+ (++contador));
                //Notificamos al adaptador del cambio producido
                this.myAdapter.notifyDataSetChanged();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.nombres.get(info.position));
        inflater.inflate(R.menu.context_menu,menu);
    }

    @Override

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete_item:
                //eliminamos el item clickeado
                this.nombres.remove(info.position);
                //notificamos al adapter del cambio
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}