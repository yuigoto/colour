package com.eixox.usecases.colour;

import java.util.HashMap;

import com.eixox.colour.ColourConverters;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

/**
 * Converts CMYK color values to the RGB colorspace.
 * 
 * All values must be integers, ranging from 0 ~ 100.
 * 
 * @author Fabio Y. Goto
 */
public class CmykRgb extends UsecaseImplementation<CmykRgb.Parameters, HashMap<String, Integer>> {
	public static class Parameters {
		@Required
		public int c;

		@Required 
		public int m;

		@Required 
		public int y;

		@Required 
		public int k;
	}

	@Override
	protected void mainFlow(UsecaseExecution<Parameters, HashMap<String, Integer>> execution) throws Exception {
		HashMap<String, Integer> rgb = ColourConverters.CmykRgb(
			execution.params.c, 
			execution.params.m, 
			execution.params.y, 
			execution.params.k
		);
		
		execution.result = rgb;
		execution.result_type = UsecaseResultType.SUCCESS;
	}
}
