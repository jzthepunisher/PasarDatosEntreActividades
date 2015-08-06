package spa.seccionuno.pasardatosentreactividades;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class DestinoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);

        //Obtiene los datos pasasdos usando getStringExtra
        Toast.makeText(this,"Nomnres : " + getIntent().getStringExtra("Nombres"), Toast.LENGTH_LONG).show();

        //Obtiene los datos pasasdos usando getIntExtra();
        Toast.makeText(this,"Edad : " + Integer.toString(getIntent().getIntExtra("Edad",0)),Toast.LENGTH_LONG).show();

        //Obtiene el objeto Bundle pasado
        Bundle bundle = getIntent().getExtras();
        //Obtiene los datos usando getString
        Toast.makeText(this,"Apellidos : " + bundle.getString("Apellidos"),Toast.LENGTH_LONG).show();
        //Obtiene los datos usando el metodo getInt
        Toast.makeText(this,"Hijos : " + Integer.toString(bundle.getInt("Hijos")),Toast.LENGTH_LONG).show();

    }

    public void onClick(View view){
        //usa un objeto Intent para retornar datos
        Intent i= new Intent();
        i.putExtra("Direccion","Av. Primavera");
        //usa el metodo setData para retornar valores
        i.setData(Uri.parse("http://youtube.com"));
        //establece el resultado con Ok y el objeto intent
        setResult(RESULT_OK,i);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_destino, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
