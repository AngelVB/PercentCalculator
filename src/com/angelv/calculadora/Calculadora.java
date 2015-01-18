
package com.angelv.calculadora;

import java.util.Stack;

import android.util.Log;

public class Calculadora extends MainActivity {
	

	private String cadenaDebug;
	private String cadena="0";
	private String cadenaoper="0";
	private String resultadoFinal="";
	private boolean error=false;
	
	Calculadora(){}
		 	 
	public String realizaOperacion(String cad){
		double operando1 =0;
		double operando2 =0;
		double resultado=0;
		int i=0;	
		
		if (cad.length()>0){
			//Si el primer caracter de la cadena es un operador me lo cargo
			if ((cad.charAt(0)=='+')||(cad.charAt(0)=='-')||(cad.charAt(0)=='÷')||(cad.charAt(0)=='x')||(cad.charAt(0)==' ')){
				cad = cad.substring(3, cad.length());
			}
		}
		
		if (cad.length()>0){
			//Si el último caracter de la cadena es un "." me lo cargo
			if (cad.charAt(cad.length()-1)=='.'){
				cad = cad.substring(0, cad.length()-1);
			}
		}
		
		
		if (cad.length()>0){
			//Si el último caracter de la cadena es un "operador" me lo cargo-
			if (cad.charAt(cad.length()-1)==' ') {
				if (cad.charAt(cad.length()-2)=='v'){
					cad = cad.substring(0, cad.length()-2);
				}else{
				cad = cad.substring(0, cad.length()-3);
				}
			}
		}
		
		if( (cad.length()>0)&&(cad.length()-1)!='.'){
			Stack<Double> miPila = new Stack<Double>();
			String[] input = cad.split(" ");
		//Convierto la cadena a notación polaca inversa para poder calcularla aprovechando un método que aprendimos el año pasado.
			String[] output = RPN.infixToRPN(input);
		 //Recorro la cadena y voy calculando el resultado. Este es el algoritmo que realicé el año pasado como ejercicio y al que le he añadido la potencia, la raiz y el porcentaje.
		for (i=0; i<output.length; i++) {
			if (output[i].equals("+")) {
				if( ! miPila.empty() ) 
					operando2 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error1.";				
				}
				
				if( ! miPila.empty() ) 
					operando1 = (double) miPila.pop();
				else{
					error=true;
					cadenaDebug="Error2.";
				}
				resultado = operando1 + operando2;
				miPila.push ((double)resultado);
			}else if (output[i].equals("-")) {
				
				if( ! miPila.empty() ) 
					operando2 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error3.";					
				}
				if( ! miPila.empty() ) 
					operando1 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error4.";
				}
				
				resultado = operando1 - operando2;
				miPila.push ((double)resultado);
			}else if (output[i].equals("x")) {
				
				if( ! miPila.empty() ) 
					operando2 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error5.";
				}
				
				if( ! miPila.empty() ) 
					operando1 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error6.";
				}
				
				resultado = operando1 * operando2;
				miPila.push ((double)resultado);
			}else if (output[i].equals("^")) {
				
				if( ! miPila.empty() ) 
					operando2 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error5.";
				}
				
				if( ! miPila.empty() ) 
					operando1 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error6.";
				}
				
				resultado = Math.pow(operando1,operando2);
				miPila.push ((double)resultado);
			}else if (output[i].equals("v")) {
				
			
				if( ! miPila.empty() ) 
					operando1 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error6.";
				}
				
				resultado = Math.sqrt(operando1);
				miPila.push ((double)resultado);
			}else if (output[i].equals("%")) {
				
				if( ! miPila.empty() ) 
					operando2 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error5.";
				}
				
				if( ! miPila.empty() ) 
					operando1 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error6.";
				}
				
				resultado = (operando1*operando2)/100;
				miPila.push ((double)resultado);
			}else if (output[i].equals("÷")) {
				if( ! miPila.empty() ) 
					operando2 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error7.";
				}
				if( ! miPila.empty() ) 
					operando1 = (double) miPila.pop();
				else{ 
					error=true;
					cadenaDebug="Error8.";
				}
					resultado = operando1 / operando2;
				if (operando2 != 0) {
					miPila.push ((double)resultado);
				} else {
					cadenaDebug="Error9.";
				}
			}else{
				try{
					miPila.push(Double.parseDouble(output[i]));
				}catch (NumberFormatException e){
					error=true;
				}
			}		
		}
		
		if( ! miPila.empty() ) 
			resultado = (double)miPila.pop();
		else{
			error=true;
			cadenaDebug="No se puede dividir entre 0.";
		}
		
		input = null;
		output=null;
		cadena="";
		cadenaoper="";
	}
	if (error){
		return "error";
	}else{ 
		 return  Double.toString(resultado);
	}
}

	public void escribirCadena(String cadena1){
		
	//Compruebo si es operación o número
	if(cadena1.equals("v")||cadena1.equals("^")||cadena1.equals("%")||cadena1.equals("+")||cadena1.equals("-")||cadena1.equals("x")||cadena1.equals("÷")){
		
		//Si le he dado al igual relleno la cadena operación.
		if(cadenaoper.equals("")){
			cadenaoper=cadena;
			
		}
		//cadena1 no es número.
		
		//Compruebo el último carácter de la cadena. Si es un operador, lo sustituyo por el introducido
		if (cadenaoper.length()>0){
			if (cadenaoper.charAt(cadenaoper.length()-1)=='.'){
				cadenaoper = cadenaoper.substring(0, cadenaoper.length()-1);
				cadena = cadena.substring(0, cadena.length()-1);
			}
		}
		
		if (cadena.length()>1){	
			if ((cadena.charAt(cadena.length()-1)=='√')&&(cadena1=="v")){
				cadenaoper = cadenaoper.substring(0, cadenaoper.length()-2);
				cadena = cadena.substring(0, cadena.length()-1);
				
			}
		}
		
		//El último dato es un operador
		if (cadenaoper.length()>0){
			if (cadenaoper.charAt(cadenaoper.length()-1)==' ') {
				//Quiero meter una raiz
				if (cadena1.equals("v")){
					// Y El último operador no es una raiz
					if (cadena.charAt(cadena.length()-1)!='√'){
						cadenaoper="0"+cadenaoper+cadena1+" ";
						cadena = cadena+"√";
						
					}
				}else{
					//Quiero meter cualquier otro operador
					//Elimino el último operador y los espacios separadores.
					
					if (cadena.charAt(cadena.length()-1)!='√'){
						Log.i("R","Estoy aqui 1" + cadenaoper);
						
					cadenaoper = cadenaoper.substring(0, cadenaoper.length()-3);
					cadena = cadena.substring(0, cadena.length()-1);
					//Si la última operación es una raiz
					}else{
						
						
						if (cadenaoper.length()>4){
							Log.i("R","Estoy aqui 4" + cadenaoper);
						cadenaoper = cadenaoper.substring(0, cadenaoper.length()-5);
						cadena = cadena.substring(0, cadena.length()-2);
						}else{
							Log.i("R","Estoy aqui 5" + cadenaoper);
							cadenaoper = cadenaoper.substring(0, cadenaoper.length()-2);
							cadena = cadena.substring(0, cadena.length()-1);
						}
						Log.i("R","Estoy aqui 3" + cadenaoper);
							
					}
					//Escribo el operador
					
						cadena = cadena+cadena1;
						cadenaoper=cadenaoper+" "+cadena1+" ";
					
				}
		//El último caracter es un número			
			} else{
				
				if (cadena1.equals("v")){
					//Es una raiz y estoy en el principio	
					if ((cadena.equals("0"))||(getResultadoFinal().equals(cadena))){
						cadena="√";
						cadenaoper=cadena1+" ";
						//Es una raiz y concateno a número	
					}else{
						//Mientras el último carácter no sea un operador, eliminad número
						while ((cadenaoper.charAt(cadenaoper.length()-1)!=' ') &&(cadenaoper.length()>0)){
							if (cadenaoper.length()>0){
								cadenaoper = cadenaoper.substring(0, cadenaoper.length()-1);
								cadena = cadena.substring(0, cadena.length()-1);
								if (cadenaoper.length()==0){
									break;
								}
							}else{
								break;
							}
						}
						cadena=cadena+"√";	
						cadenaoper=cadenaoper+cadena1+" ";
					}
					//No es una raiz, Es un número
				}else{ 
					
						cadena=cadena+cadena1;
						cadenaoper=cadenaoper+" "+cadena1+" ";
					
				}	
			} 
		}					 
	}
			
	//Concateno operador
	else{
		if(cadenaoper.length()>0){
		if ((cadena1.equals("."))&&(cadenaoper.charAt(cadenaoper.length()-1)=='.')){
			Log.i("R","Estoy aqui 1" + cadenaoper);
			cadenaoper=cadenaoper.substring(0,cadenaoper.length()-1);
			cadena=cadena.substring(0,cadena.length()-1);
		}	
		}else{
			Log.i("R","Estoy aqui 7" + cadenaoper.length());
			if ((cadena1.equals("."))&&(cadenaoper.length()==0)){
				Log.i("R","Estoy aqui 6" + cadenaoper);
				cadenaoper=cadenaoper.substring(0,cadenaoper.length());
				cadena=cadena.substring(0,cadena.length());
			}
			
		}
		//cadena1 es un número

		//Compruebo si estoy al principio de una operación
		if ((cadena.equals("0"))||(cadenaoper.equals(""))){
			//Estoy al principio de operación. Reseteo cadena
			
			cadena=cadena1;
			cadenaoper=cadena1;
		}else{
			//No estoy al principio de operación. Concateno número al operando
			cadena=cadena+cadena1;
			cadenaoper=cadenaoper+cadena1;	
		}
	}

}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		
		this.cadena = cadena;
	}

	public String getCadenaDebug() {
		return cadenaDebug;
	}

	public void setCadenaDebug(String cadenaDebug) {
		this.cadenaDebug = cadenaDebug;
	}

	public String getCadenaoper() {
		return cadenaoper;
	}

	public void setCadenaoper(String cadenaoper) {
		this.cadenaoper = cadenaoper;
	}

	public String getResultadoFinal() {
		return resultadoFinal;
	}
	public void setResultadoFinal(String resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
