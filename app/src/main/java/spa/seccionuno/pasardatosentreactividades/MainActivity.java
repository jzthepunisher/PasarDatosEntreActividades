package spa.seccionuno.pasardatosentreactividades;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent i= new Intent("spa.seccionuno.pasardatosentreactividades.DestinoActivity");

        //usa putExtra para adicionar pares clave/valor
        i.putExtra("Nombres","Yerico Yampool");
        i.putExtra("Edad" ,28);

        //usa un objeto Bundle para adicionar valores clave/valor
        Bundle extras= new Bundle();
        extras.putString("Apellidos","Ezeta Ticona");
        extras.putInt("Hijos",0);
        //adjunta el objeto bundle al objeto Intent
        i.putExtras(extras);

        startActivityForResult(i, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        //verifica si el codigo de solicitud es 1
        if (requestCode==1){
            //si el resulttado es OK
            if(resultCode==RESULT_OK){
                //obtiene el resultado usando getintExtra
                Toast.makeText(this, data.getStringExtra("Direccion"),Toast.LENGTH_LONG).show();
                //obtiene el resultado usando getData
                Uri url=data.getData();
                Toast.makeText(this,url.toString(),Toast.LENGTH_LONG).show();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
