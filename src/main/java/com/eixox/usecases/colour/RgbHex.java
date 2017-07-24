package com.eixox.usecases.colour;

import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

/**
 * Converts RGB color values to a hexadecimal string.
 * 
 * All values must be integers, ranging from 0 ~ 255.
 * 
 * @author Fabio Y. Goto
 */
public class RgbHex extends UsecaseImplementation<RgbHex.Parameters, String> {
	public static class Parameters {
		@Required 
		public int r;

		@Required 
		public int g;
		
		@Required 
		public int b;
	}

	@Override
	protected void mainFlow(UsecaseExecution<Parameters, String> execution) throws Exception {
		String r, g, b;

		r = ("000" + Integer.toHexString(execution.params.r));
		g = ("000" + Integer.toHexString(execution.params.g));
		b = ("000" + Integer.toHexString(execution.params.b));
		
		System.out.println(r.substring(r.length() - 2));
		
		execution.result = r.substring(r.length() - 2)
				 + g.substring(g.length() - 2)
				 + b.substring(b.length() - 2);
		execution.result_type = UsecaseResultType.SUCCESS;
	}
}
