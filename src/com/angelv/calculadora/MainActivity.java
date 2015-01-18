
package com.angelv.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {


	public Button bt_1, bt_2, bt_3, bt_4, bt_5,bt_6,bt_7,bt_8,bt_9,bt_0 ;
	 public Button bt_division, bt_suma, bt_resta, bt_multip, bt_decimal,bt_igual,bt_borrar ;
	 public Button bt_porcen, bt_pow, bt_raiz;
	 public TextView lblMensaje;
	 public TextView lblDebug;
	 private Calculadora calc;
	 private String cadenatemp, cadenaopertemp;
	
   @Override
   protected void onCreate(Bundle savedInstanceState) {
	 
	   if (savedInstanceState !=null) {
	//Mantengo las variables al rotar pantalla o iniciar Activity.
	   cadenatemp = savedInstanceState.getString("CADENA_");
	   cadenaopertemp=savedInstanceState.getString("CADENAOPER_");
	   }
	   requestWindowFeature(Window.FEATURE_NO_TITLE);
	   getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
	   super.onCreate(savedInstanceState);
      
       setContentView(R.layout.activity_main);
             
       bt_0 = (Button)findViewById(R.id.bt_0);
       bt_1 = (Button)findViewById(R.id.bt_1);
       bt_2 = (Button)findViewById(R.id.bt_2);
       bt_3 = (Button)findViewById(R.id.bt_3);
       bt_4 = (Button)findViewById(R.id.bt_4);
       bt_5 = (Button)findViewById(R.id.bt_5);
       bt_6 = (Button)findViewById(R.id.bt_6);
       bt_7 = (Button)findViewById(R.id.bt_7);
       bt_8 = (Button)findViewById(R.id.bt_8);
       bt_9 = (Button)findViewById(R.id.bt_9);
       
       bt_division = (Button)findViewById(R.id.bt_division);
       bt_suma = (Button)findViewById(R.id.bt_suma);
       bt_resta = (Button)findViewById(R.id.bt_resta);
       bt_multip = (Button)findViewById(R.id.bt_multip);
       bt_decimal = (Button)findViewById(R.id.bt_decimal);
       bt_igual = (Button)findViewById(R.id.bt_igual);
       bt_borrar = (Button)findViewById(R.id.btBorrar);
       
    
       bt_porcen=(Button)findViewById(R.id.btPorcen);
       bt_pow=(Button)findViewById(R.id.btPow);
       bt_raiz=(Button)findViewById(R.id.btRaiz);
       
       lblMensaje = (TextView)findViewById(R.id.textView1 );
       lblDebug = (TextView)findViewById(R.id.textView2);
      
       calc=new Calculadora();
       if (savedInstanceState !=null) {
       calc.setCadena(cadenatemp);
       calc.setCadenaoper(cadenaopertemp);
       lblMensaje.setText(calc.getCadena());
       }
       
	   bt_0.setOnClickListener(new View.OnClickListener() {
       
       	public void onClick(View arg0)
       	{
       		calc.escribirCadena("0");
       		lblMensaje.setText(calc.getCadena());
       		lblDebug.setText(calc.getCadenaDebug());
       	}
       });
       bt_1.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
       		calc.escribirCadena("1");
       		lblMensaje.setText(calc.getCadena());
       		lblDebug.setText(calc.getCadenaDebug());
           }
       });
       bt_2.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
       		calc.escribirCadena("2");
       		lblMensaje.setText(calc.getCadena());
            lblDebug.setText(calc.getCadenaDebug());
           }
       });
       bt_3.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
       		calc.escribirCadena("3");
       		lblMensaje.setText(calc.getCadena());
       		lblDebug.setText(calc.getCadenaDebug());
           }
       });
     
       
       bt_4.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
       		calc.escribirCadena("4");
       		lblMensaje.setText(calc.getCadena());
       		lblDebug.setText(calc.getCadenaDebug());
           }
       });
       bt_5.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
       		calc.escribirCadena("5");
       		lblMensaje.setText(calc.getCadena());        		
       		lblDebug.setText(calc.getCadenaDebug());
           }
       });
       bt_6.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
       		calc.escribirCadena("6");
       		lblMensaje.setText(calc.getCadena());
       		lblDebug.setText(calc.getCadenaDebug());
           }
       });
       bt_7.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
       		calc.escribirCadena("7");
       		lblMensaje.setText(calc.getCadena());
       		lblDebug.setText(calc.getCadenaDebug());
           }
       });
       bt_8.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
       		calc.escribirCadena("8");
       		lblMensaje.setText(calc.getCadena());
       		lblDebug.setText(calc.getCadenaDebug());
           }
       });
       bt_9.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
       		calc.escribirCadena("9");
       		lblMensaje.setText(calc.getCadena());
       		lblDebug.setText(calc.getCadenaDebug());
           }
       });
       
       bt_suma.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
           	calc.escribirCadena("+");
           	lblMensaje.setText(calc.getCadena());
           	lblDebug.setText(calc.getCadenaDebug());
           }
       });
       
       bt_resta.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
           	calc.escribirCadena("-");
           	lblMensaje.setText(calc.getCadena());
            lblDebug.setText(calc.getCadenaDebug());      
           }
       });
       
       bt_multip.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
           	calc.escribirCadena("x");
           	lblMensaje.setText(calc.getCadena());
           	lblDebug.setText(calc.getCadenaDebug());
           }
       });
       
       bt_division.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
           	calc.escribirCadena("÷");
           	lblMensaje.setText(calc.getCadena());
           	lblDebug.setText(calc.getCadenaDebug());
           }
       });
       
       
       bt_porcen.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
           	calc.escribirCadena("%");
           	lblMensaje.setText(calc.getCadena());
           	lblDebug.setText(calc.getCadenaDebug());
           }
       });
       
       bt_pow.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
           	calc.escribirCadena("^");
           	lblMensaje.setText(calc.getCadena());
           	lblDebug.setText(calc.getCadenaDebug());
           }
       });
       
bt_raiz.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
           	calc.escribirCadena("v");
           	lblMensaje.setText(calc.getCadena());
           	lblDebug.setText(calc.getCadenaDebug());
           }
       });
       
       bt_decimal.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
           	calc.escribirCadena(".");
           	lblMensaje.setText(calc.getCadena());
           	lblDebug.setText(calc.getCadenaDebug());
           }
       });
       
       bt_igual.setOnClickListener(new View.OnClickListener() {
           
           public void onClick(View arg0)
           {
           	String resul; 
           	Log.i("R","Estoy aqui2" + calc.getCadenaoper());
           	resul=calc.realizaOperacion(calc.getCadenaoper());
           	if(resul.equals("error")){
          			lblMensaje.setText("Error");     		
           			calc.escribirCadena("0");           			
               		calc.setError(false);
           	}else{
           		
           		calc.setResultadoFinal(resul);
           		         	
           		if (calc.getResultadoFinal().substring(calc.getResultadoFinal().length()-2).equals(".0")){
           			calc.setResultadoFinal(calc.getResultadoFinal().substring(0,calc.getResultadoFinal().length()-2));
           		}
           	
           		calc.escribirCadena(calc.getResultadoFinal());
           		calc.setCadenaoper("");
           		lblMensaje.setText(calc.getCadena());
           		lblDebug.setText(calc.getCadenaDebug());
           	}
           }            	      
       });
       
       bt_borrar.setOnClickListener(new View.OnClickListener() {
           
       	public void onClick(View arg0)
           {
           	lblMensaje.setText("0");
           	calc.setCadena("0");
           	calc.setCadenaDebug("");
           	calc.setCadenaoper("0");
           	lblDebug.setText(""); 
           }
      });
   }
   @Override
   protected void onSaveInstanceState(Bundle outState) {
       super.onSaveInstanceState(outState);
      //Mantengo las variables al rotar pantalla o iniciar Activity.
       outState.putString("CADENA_", calc.getCadena());
       outState.putString("CADENAOPER_", calc.getCadenaoper());
       
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
     
       getMenuInflater().inflate(R.menu.main, menu);
       return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       
       int id = item.getItemId();
       if (id == R.id.action_settings) {
           return true;
       }
       return super.onOptionsItemSelected(item);
   }	
}