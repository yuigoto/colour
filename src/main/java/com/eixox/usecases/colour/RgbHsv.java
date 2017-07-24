package com.eixox.usecases.colour;

import java.util.HashMap;

import com.eixox.colour.ColourConverters;
import com.eixox.restrictions.Required;
import com.eixox.usecases.UsecaseExecution;
import com.eixox.usecases.UsecaseImplementation;
import com.eixox.usecases.UsecaseResultType;

/**
 * Converts RGB color values to the HSV colorspace.
 * 
 * RGB values must range from 0 ~ 255.
 * 
 * @author Fabio Y. Goto
 */
public class RgbHsv extends UsecaseImplementation<RgbHsv.Parameters, HashMap<String, Integer>> {
	public static class Parameters {
		@Required
		public int r;
		
		@Required
		public int g;

		@Required
		public int b;
	}
	
	@Override
	protected void mainFlow(UsecaseExecution<Parameters, HashMap<String, Integer>> execution) throws Exception {
		HashMap<String, Integer> hsv = ColourConverters.RgbHsv(
				execution.params.r, 
				execution.params.g, 
				execution.params.b 
		);
		
		execution.result = hsv;
		execution.result_type = UsecaseResultType.SUCCESS;
	}
}
