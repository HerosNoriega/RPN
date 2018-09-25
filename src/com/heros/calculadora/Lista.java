package com.heros.calculadora;

import com.heros.calculadora.util.Ecuacion;

public class Lista {
    private NodoString cabeza;
    private NodoString cola;
    private int longitud;

    public Lista() {
      this.cabeza = null;
      this.longitud = 0;
    }

    /**
     * longitud() funcion que retorna un tipo de dato int 
     * @return retorna un tipo de dato int que es la longitud de la lista
     */
    public int longitud() {
      return this.longitud;
    }
    
    /**
     * estaVacio() funcion a retornar un tipo de dato boolean
     * @return retorna si la lista esta vacio con un tipo de dato boolean
     */
    public boolean estaVacio() {
      return cabeza == null;
    }

    /**
     * getPrimero() funcion a retornar un tipo de dato Ecuacion 
     * @return la primera ecuacion ingresada a la lista
     */
    public Ecuacion getPrimero() {

        if (estaVacio()) {
          System.out.println("Empty");
          return cabeza.data;
        } else {
          System.out.println("The First Node: \'" + cabeza.data.getEcuacion() + 
        		  									cabeza.data.getResultado() + "\'");
          return cabeza.data;
        }
    }

    /**
     * getUltimo() una funcion para obtener la Ecuacion ultima ingresada
     * @return retorna un tipo de dato Ecuacion que seria el ultimo en la lista
     */
    public Ecuacion getUltimo() {
      if (estaVacio()) {
        System.out.println("Empty");
        return cabeza.data;
      } else {
        System.out.println("The Last Node: \'" + cola.data.getEcuacion() + 
        										cola.data.getResultado() + "\'");
        return cola.data;
      }
    }
    
    /**
     * agregar() funcion para agregar una Ecuacion a la lista 
     * @param ecuacion es el dato a ingresar en el caso del tipo de dato Ecuacion 
     * @param position La posicion a ingresar la ecuacion en la lista
     */
    public void agregar(Ecuacion ecuacion, int position) {
    	if(position > 0) {
    		NodoString currentNode = new NodoString();
    		NodoString nextNode = new NodoString();
    		NodoString tempNode = new NodoString();
    		tempNode.data = ecuacion;
    		
    		if(position == 1) {
    			agregarPrimero(ecuacion);
    		} else if(position == longitud) {
    			agregarUltimo(ecuacion);
    		} else if(position < longitud && position > longitud) {
    			System.out.println("Trying to add \'"  + "\' out of range in Position: " + position);
    		} else {
    			currentNode = cabeza;

    	        int i = 1;
    	        while(i < (position - 1)) {
    	        	currentNode = currentNode.link;
    	            i++;
    	        }

    	        nextNode = currentNode.link;
    	        currentNode.link = tempNode;
    	        tempNode.link = nextNode;
    	        
    	        System.out.println("Added: \'" + ecuacion.getEcuacion() + " : " + 
    	        		ecuacion.getResultado() +"\' in Position: " + position);

    	        longitud++;
    			
    		}
    	}
    }

    /**
     * agregarPrimero() funcion para agregar a la primera pocision 
     * @param ecuacion tipo de dato Ecuacion a ingresar en la primera posicion 
     */
    public void agregarPrimero(Ecuacion ecuacion) {
    	NodoString newNode = new NodoString();
      
      newNode.data = ecuacion;
      newNode.link = null;

      if (estaVacio()) {
    	  cabeza = newNode;
    	  cola = cabeza;
          System.out.println("Added: \'" + ecuacion.getEcuacion() + " Resultado " + 
        		  							ecuacion.getResultado() + "\' in Position: " + 1);
      } else {
        newNode.link = cabeza;
        cabeza = newNode;
        System.out.println("Added: \'" + ecuacion.getEcuacion() + " Resultado " +
        									ecuacion.getResultado() + "\' in Position: " + 1);
      }
      longitud++;
    }
    
    /**
     * agregarUltimo() es una funcion para ingresar un dato a la ultima posicion
     * @param ecuacion tipo de dato Ecuacion sera ingresado a la ultima posicion 
     */
    public void agregarUltimo(Ecuacion ecuacion) {
    	NodoString newNode = new NodoString();

      newNode.data = ecuacion;
      newNode.link = null;

      if (estaVacio()) {
    	  agregarPrimero(ecuacion);
      } else {
    	  NodoString currentNode = cabeza;
        while (currentNode.link != null) {
            currentNode = currentNode.link;
        }
        currentNode.link = newNode;
        cola = newNode;
        System.out.println("Added: \'" + ecuacion.getEcuacion() + "\' in Position: " + (longitud() + 1));
      }
      longitud++;
    }

    /**
     * removerPrimero() funcion a remover el dato en la primera posicion 
     */
    public void removerPrimero() {
        if (estaVacio()) {
          System.out.println("List empty");
        } else {
          System.out.println("Removing: \'" + cabeza.data + "\' in Position: " + 1);
          cabeza = cabeza.link;
        }
        longitud--;
    }

    /**
     * removerUltimo() funcion para remover el dato en la ultima posicion 
     */
    public void removerUltimo() {
      if (estaVacio()) {
        System.out.println("List Empty");
      } else {
    	  NodoString currentNode = new NodoString();
        currentNode = cabeza;
        while (currentNode.link.link != null) {
          currentNode = currentNode.link;
        }
        currentNode.link = null;
        System.out.println("Removing: \'" + currentNode.data + "\' in Position: " + longitud);
      }
      longitud--;
    }

    /**
     * remover() es una funcion para remover un dato en la posicion dada
     * @param position resive la posicion en dato int para remover el dato
     */
    public void remover(int position) {
    	NodoString currentNode = new NodoString();
      if (estaVacio()) {
        System.out.println("Empty List");
      } else if (position == 0) {
        System.out.println("Not a valid position");
      } else if (position > 0 && position <= longitud) {
         if (position == 1) {
           System.out.println("Removing: \'" + cabeza.data + "\' in Position: " + 1);
           cabeza = cabeza.link;
           longitud--;
         } else if (position == longitud) {
          currentNode = cabeza;
          while (currentNode.link.link != null) {
            currentNode = currentNode.link;
          }
          currentNode.link = null;
          System.out.println("Removing: \'" + currentNode.data + "\' in Position: " + longitud());
          longitud--;
        } else {
          currentNode = cabeza;
          for (int i = 1; i < position -1; i++) {
            currentNode = currentNode.link;
          }
          currentNode.link = currentNode.link.link;
          System.out.println("Removing: \'" + currentNode.data + "\' in Position: " + position);
          longitud--;
        }
      }
    }

    /**
     * get() obtiene el dato en la posicion dada
     * @param position resive la posicion en dato int 
     * @return retorna el tipo de dato en la posicion dada
     */
    public Ecuacion get(int position) {
    	NodoString currentNode = new NodoString();
      if (estaVacio() || position == 0) {
        System.out.println("Empty List");
      } else if (position > 0 && position <= longitud) {
        currentNode = cabeza;
        for (int i = 0; i < position - 1; i++) {
          currentNode = currentNode.link;
        }
        //System.out.println("Getting: \'" + currentNode.data + "\' in Position: " + position);
      } else {
        System.out.println("No Node found in position: " + position);
      }
      return currentNode.data;
    }

    /**
     * getPosicion() funcion para obtener la posicion donde se encuentra la ecuacion 
     * @param ecuacion resive un dato de tipo Ecuacion para ser buscado en la lista 
     * @return retorna un tipo de dato int que seria la posicion de la Ecuacion buscada
     */
    public int getPosicion(Ecuacion ecuacion) {
    	NodoString currentNode = new NodoString();
       int positionNode = 1;
       currentNode = cabeza;
       while ((currentNode.data != ecuacion) && (positionNode < longitud)) {
         currentNode = currentNode.link;
         positionNode++;
       }
       if (currentNode.data == ecuacion) {
         System.out.println("Searching for " + "'" + ecuacion + "'" + " Position: " + positionNode);
         return positionNode;
       } else {
         System.out.println("No Position Found for " + ecuacion);
         return 0;
       }
    }

    /**
     * print() imprimira la lista completa de datos 
     */
    public void print() {
        System.out.println("Linked List: ");
        if (longitud == 0) {
          System.out.println("empty");
        } else {

        	NodoString currentNode = cabeza;
          int counter = 1;

          while (currentNode.link != null) {
              System.out.println(counter + " > " + "Data: \'" + currentNode.data.getEcuacion() + " : " + 
            		  											currentNode.data.getResultado() + "\'");
              currentNode = currentNode.link;
              counter++;
          }
          System.out.println(counter + " > " + "Data: \'" + currentNode.data.getEcuacion() + " : " + 
        		  											currentNode.data.getResultado() + "\'");
        }
    }
    
    /**
     * ordenarAscendente() ordena los datos ascendente por los resultados obtenidos en la ecuacion 
     */
    public void ordenarAscendente() {
		if(longitud == 0) {
			System.out.println("No hay datos");
			
		} else if(longitud == 1) {
			System.out.println("No hay datos que ordenar");
			
		} else if (longitud > 1){
			
			NodoString auxiliar = cabeza;

		    for(int i = 0; i < longitud; i ++){
		      
		      NodoString menor = auxiliar;
		      NodoString auxiliarComparacion = auxiliar.link;

		      for(int j = 1; j < longitud; j++){

		        if(auxiliarComparacion == null){
		          break;
		        }
		        
		        
		        if(menor.data.getResultado() > auxiliarComparacion.data.getResultado()) {
		          menor = auxiliarComparacion;
		        }
		        auxiliarComparacion = auxiliarComparacion.link;
		      }

		      Ecuacion temporal = auxiliar.data;
		      auxiliar.data = menor.data;
		      menor.data = temporal;

		      auxiliar = auxiliar.link;
		    }
		}
	}

    /**
     * ordenarDescendente() ordena los datos descendente por los resultados obtenidos en la ecuacion 
     */
    public void ordenarDescendente() {
		if(longitud == 0) {
			System.out.println("No hay datos");
			
		} else if(longitud == 1) {
			System.out.println("No hay datos que ordenar");
			
		} else if (longitud > 1){
			
			NodoString auxiliar = cabeza;

		    for(int i = 0; i < longitud; i ++){
		      
		      NodoString menor = auxiliar;
		      NodoString auxiliarComparacion = auxiliar.link;

		      for(int j = 1; j < longitud; j++){

		        if(auxiliarComparacion == null){
		          break;
		        }
		        
		        
		        if(menor.data.getResultado() < auxiliarComparacion.data.getResultado()) {
		          menor = auxiliarComparacion;
		        }
		        auxiliarComparacion = auxiliarComparacion.link;
		      }

		      Ecuacion temporal = auxiliar.data;
		      auxiliar.data = menor.data;
		      menor.data = temporal;

		      auxiliar = auxiliar.link;
		    }
		}
	}

}
