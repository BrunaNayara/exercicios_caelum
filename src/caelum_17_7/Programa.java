package caelum_17_7;

public class Programa implements Runnable {

	 private int id;
	 // colocado getter e setter do atributo id
	
	 public void run () {
		 for (int i = 0; i < 10000; i++) {
			 System.out.println("Programa " + id + " valor: " + i);
		 }
	 }

	 public int getId() {
			return this.id;
		}
	 
	public void setId(int i) {
		this.id = i;
		
	}
}