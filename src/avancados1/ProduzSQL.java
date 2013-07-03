package avancados1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Vector;

public class ProduzSQL implements Runnable{
	
	private int comeco;
	private int fim;
	private Collection<String> sqls;
	
	public ProduzSQL (int comeco, int fim, Collection<String> sqls){
		this.comeco = comeco;
		this.fim = fim;
		this.sqls = sqls;
		
	}

	
	public void run() {
		
		for(int i = comeco; i < fim; i++){
			
			sqls.add("SQL"+i);
			
			
		}
	}

}