package com.eixox.usecases.colour;

import java.util.Random;

import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

public class RandomHexColorList extends UsecaseImplementation<RandomHexColorList.Parameters, String[]>{
	public static class Parameters {
		public int quantity;
	}
	
	protected Random rand;
	
	@Override
	protected void mainFlow(UsecaseExecution<Parameters, String[]> execution) throws Exception {
		
		rand = new Random();
		
		int quantity = execution.params.quantity;
		if (quantity < 1) quantity = 10;
		execution.result = new String[quantity];
		
		for (int i = 0; i < quantity; i++) {
			String r, g, b, hex;

			r = "000" + Integer.toHexString(rand.nextInt(255));
			g = "000" + Integer.toHexString(rand.nextInt(255));
			b = "000" + Integer.toHexString(rand.nextInt(255));
			
			hex = r.substring(r.length() - 2)
				+ g.substring(g.length() - 2)
				+ b.substring(b.length() - 2);
			
			execution.result[i] = hex;
		}
		
		execution.result_type = UsecaseResultType.SUCCESS;	
	}
}
