package caelum_17_8;

import java.util.Collection;
import java.util.HashSet;

public class BancoDeDados {
	
	public static void main(String[] args) throws InterruptedException {
		Collection<String> sqls = new HashSet<String>();
		
		ProduzSQL p1 = new ProduzSQL(0, 10000, sqls);
		Thread t1 = new Thread(p1);
		ProduzSQL p2 = new ProduzSQL(10000, 20000, sqls);
		Thread t2 = new Thread(p2);
		ProduzSQL p3 = new ProduzSQL(20000, 30000, sqls);
		Thread t3 = new Thread(p3);
		
		t1.start();
		t2.start();
		t3.start();
		// faz com que n�s (n�s = thread que roda o main)
		// aguardemos o fim dessas tr�s threads
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Threads produtoras de SQLs finalizadas!");
		// verifica se todas as SQLs foram executadas
		
		for (int i = 0; i < 15000; i++) {
			if (!sqls.contains("SQL" + i)) {
				throw new IllegalStateException("n�o encontrei a SQL" + i);
			}
		}
		// verifica se null n�o se encontra!
		if (sqls.contains(null)) {
			throw new IllegalStateException("n�o devia ter null aqui dentro!");
		}
		System.out.println("Fim da execucao com sucesso");
	}
}