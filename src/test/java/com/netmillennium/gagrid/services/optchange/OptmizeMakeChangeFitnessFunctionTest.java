package com.netmillennium.gagrid.services.optchange;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.netmillennium.gagrid.model.Gene;
import com.netmillennium.gagrid.services.optchange.OptimizeMakeChangeFitnessFunction;

public class OptmizeMakeChangeFitnessFunctionTest {

	
	@Test
	public void testOptmizeMakeChangeFitnessFunction()
	{
		List<Gene> genes = new ArrayList<Gene>(){{
			
			 add(new Gene(new Coin(Coin.CoinType.QUARTER, 3)));
			 add(new Gene(new Coin(Coin.CoinType.PENNY, 0)));
			 add(new Gene(new Coin(Coin.CoinType.NICKEL, 0)));
			 add(new Gene(new Coin(Coin.CoinType.DIME, 0)));
			}};
		
	      OptimizeMakeChangeFitnessFunction  function = new OptimizeMakeChangeFitnessFunction (75);
		
		  double fitness = function.evaluate(genes);
		  
		  Assertions.assertNotEquals(0, fitness);
	}
	
}
