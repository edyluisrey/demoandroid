package com.example.demoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;


public class MainActivity extends ListActivity {

	static final String[] PAGINAS = new String[] {    
		"Afiliados", "Desafiliados", 
		"Pendientes", "Postulantes",
		"Solicitudes", "Eliminados"};
	
	OnItemClickListener mCorkyListener = new OnItemClickListener() 
	{    
		public void onItemClick(AdapterView<?> parent, View view,        
				int position, long id) {      
			// cuando se pulsa, salta a la página correspondiente   			
			Intent intent=new Intent(MainActivity.this, ActividadPersonas.class);
			intent.putExtra("position", position);
			MainActivity.this.startActivity(intent);  			
		}  
	};
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);  
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, PAGINAS));
		ListView lv = getListView();  
		lv.setTextFilterEnabled(true);  
		lv.setOnItemClickListener(mCorkyListener);
		
		//Abrimos la base de datos 'DBUsuarios' en modo escritura
       /* UsuariosSQLiteHelper usdbh =
            new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();       
        if(db != null) {           
                         
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                           "VALUES ('Edy Luisrey Aguirre', 'Av. Ignacio Merino 123','eaguirre378@gmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Favio  Condori', 'Av. Arequipa 123','faavio@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Puol Tahobara', 'Av. Paseo la Republica 123','paul@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Mrtin Linases Gahoa', 'AV. Angamos 456','martin@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Miguel Chavez Diaz', 'Av. Ramon castilla 123','miguel@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Carmen Llanos Ticona', 'Jr. Ayacucho 456','carmen@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Carlos gonzales laura', 'AV. 28 de Julio 123','carlos@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Laura Quintana Tii', 'Av. Benavides 456','laura@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Frank Guitirrez Lazo', 'Av. Grau 1234','frank@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Ramon valdes Valdez', 'Av. Mexico 456','ramon@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Gabriel  Cuba Mendez', 'Av. Venezuela 456','gabriel@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Andrea Miranda', 'AV. Arequipa 4566','andrea@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Luis Ramos Ticnona', 'Av. Esapaña 123','luis@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Maria guitierres', 'Av. Canevaro Moreyra 123','maria@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Juan Quiroz Ramos', 'Av, Piorola 456','juan@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Sandra Gonzales Luur', 'Jr. La union 456','sandra@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Dante Avlia Gomez', 'AV. la Rinconada 456','dante@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Nadine Heredo Heredo', 'Av. EL ejercito 456','nadine@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Felipe Cuellar Llanos', 'Av. Arica 453','felipe@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Yiyo Huanxa Diaz','AV. Tarapaca 455','yiyo@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Wilson  Aguirre', 'Av. Wilson 456','wilson@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Cristian  shaune han', 'AV. Juan de Arona 423','cristian@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Mario Bross bros', 'AV. Urugay 123','mario@yopmail.com')");
                db.execSQL("INSERT INTO Usuarios (nombre, direccion, email) " +
                        "VALUES ('Karla mamami mendez', 'AV. Bolivia 1544','karla@yopmail.com')");
                      
            db.close();
        }*/
        
	}
}
