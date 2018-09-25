package com.heros.calculadora;

import com.heros.calculadora.util.Ecuacion;

public class Lista {
    private NodoString head;
    private NodoString tail;
    private int size;

    public Lista() {
      this.head = null;
      this.size = 0;
    }

    public int size() {
      return this.size;
    }

    public boolean isEmpty() {
      return head == null;
    }

    public NodoString getFirst() {

        if (isEmpty()) {
          System.out.println("Empty");
          return head;
        } else {
          System.out.println("The First Node: \'" + head.data.getEcuacion() + 
        		  									head.data.getResultado() + "\'");
          return head;
        }
    }

    public NodoString getLast() {
      if (isEmpty()) {
        System.out.println("Empty");
        return head;
      } else {
        System.out.println("The Last Node: \'" + tail.data.getEcuacion() + 
        											tail.data.getResultado() + "\'");
        return tail;
      }
    }
    
    public void add(Ecuacion ecuacion, int position) {
    	if(position > 0) {
    		NodoString currentNode = new NodoString();
    		NodoString nextNode = new NodoString();
    		NodoString tempNode = new NodoString();
    		tempNode.data = ecuacion;
    		
    		if(position == 1) {
    			addFirst(ecuacion);
    		} else if(position == size) {
    			addLast(ecuacion);
    		} else if(position < size && position > size) {
    			System.out.println("Trying to add \'"  + "\' out of range in Position: " + position);
    		} else {
    			currentNode = head;

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

    	        size++;
    			
    		}
    	}
    }

    public void addFirst(Ecuacion ecuacion) {
    	NodoString newNode = new NodoString();
      
      newNode.data = ecuacion;
      newNode.link = null;

      if (isEmpty()) {
          head = newNode;
          tail = head;
          System.out.println("Added: \'" + ecuacion.getEcuacion() + " Resultado " + 
        		  							ecuacion.getResultado() + "\' in Position: " + 1);
      } else {
        newNode.link = head;
        head = newNode;
        System.out.println("Added: \'" + ecuacion.getEcuacion() + " Resultado " +
        									ecuacion.getResultado() + "\' in Position: " + 1);
      }
      size++;
    }
    
    public void addLast(Ecuacion node) {
    	NodoString newNode = new NodoString();

      newNode.data = node;
      newNode.link = null;

      if (isEmpty()) {
        addFirst(node);
      } else {
    	  NodoString currentNode = head;
        while (currentNode.link != null) {
            currentNode = currentNode.link;
        }
        currentNode.link = newNode;
        tail = newNode;
        System.out.println("Added: \'" + node.getEcuacion() + "\' in Position: " + (size() + 1));
      }
      size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
          System.out.println("List empty");
        } else {
          System.out.println("Removing: \'" + head.data + "\' in Position: " + 1);
          head = head.link;
        }
        size--;
    }

    public void removeLast() {
      if (isEmpty()) {
        System.out.println("List Empty");
      } else {
    	  NodoString currentNode = new NodoString();
        currentNode = head;
        while (currentNode.link.link != null) {
          currentNode = currentNode.link;
        }
        currentNode.link = null;
        System.out.println("Removing: \'" + currentNode.data + "\' in Position: " + size);
      }
      size--;
    }

    public void remove(int position) {
    	NodoString currentNode = new NodoString();
      if (isEmpty()) {
        System.out.println("Empty List");
      } else if (position == 0) {
        System.out.println("Not a valid position");
      } else if (position > 0 && position <= size) {
         if (position == 1) {
           System.out.println("Removing: \'" + head.data + "\' in Position: " + 1);
           head = head.link;
           size--;
         } else if (position == size) {
          currentNode = head;
          while (currentNode.link.link != null) {
            currentNode = currentNode.link;
          }
          currentNode.link = null;
          System.out.println("Removing: \'" + currentNode.data + "\' in Position: " + size());
          size--;
        } else {
          currentNode = head;
          for (int i = 1; i < position -1; i++) {
            currentNode = currentNode.link;
          }
          currentNode.link = currentNode.link.link;
          System.out.println("Removing: \'" + currentNode.data + "\' in Position: " + position);
          size--;
        }
      }
    }

    public NodoString get(int position) {
    	NodoString currentNode = new NodoString();
      if (isEmpty() || position == 0) {
        System.out.println("Empty List");
      } else if (position > 0 && position <= size) {
        currentNode = head;
        for (int i = 0; i < position - 1; i++) {
          currentNode = currentNode.link;
        }
        //System.out.println("Getting: \'" + currentNode.data + "\' in Position: " + position);
      } else {
        System.out.println("No Node found in position: " + position);
      }
      return currentNode;
    }

    public int getPosition(NodoString node) {
    	NodoString currentNode = new NodoString();
       int positionNode = 1;
       currentNode = head;
       while ((currentNode.data != node.data) && (positionNode < size)) {
         currentNode = currentNode.link;
         positionNode++;
       }
       if (currentNode.data == node.data) {
         System.out.println("Searching for " + "'" + node.data + "'" + " Position: " + positionNode);
         return positionNode;
       } else {
         System.out.println("No Position Found for " + node.data);
         return 0;
       }
    }

    public void print() {
        System.out.println("Linked List: ");
        if (size == 0) {
          System.out.println("empty");
        } else {

        	NodoString currentNode = head;
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
    
    public void ordenarAscendente() {
		if(size == 0) {
			System.out.println("No hay datos");
			
		} else if(size == 1) {
			System.out.println("No hay datos que ordenar");
			
		} else if (size > 1){
			
			NodoString auxiliar = head;

		    for(int i = 0; i < size; i ++){
		      
		      NodoString menor = auxiliar;
		      NodoString auxiliarComparacion = auxiliar.link;

		      for(int j = 1; j < size; j++){

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

    public void ordenarDescendente() {
		if(size == 0) {
			System.out.println("No hay datos");
			
		} else if(size == 1) {
			System.out.println("No hay datos que ordenar");
			
		} else if (size > 1){
			
			NodoString auxiliar = head;

		    for(int i = 0; i < size; i ++){
		      
		      NodoString menor = auxiliar;
		      NodoString auxiliarComparacion = auxiliar.link;

		      for(int j = 1; j < size; j++){

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
