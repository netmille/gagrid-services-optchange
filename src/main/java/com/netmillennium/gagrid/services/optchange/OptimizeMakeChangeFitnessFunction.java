package com.netmillennium.gagrid.services.optchange;

import java.util.List;


import com.netmillennium.gagrid.model.Gene;
import com.netmillennium.gagrid.parameter.IFitnessFunction;
/**
 * This example demonstrates how to create a IFitnessFunction <br/>
 *
 * Your IFitness function will vary depending on your particular use case. <br/>
 * 
 * For this fitness function, we simply want to calculate the value of  <br/>
 * 
 * an individual solution relative to other solutions. <br/>
 * 
 * <br/>
 * 
 * 
 */

public class OptimizeMakeChangeFitnessFunction implements IFitnessFunction {

    int targetAmount = 0;

    public OptimizeMakeChangeFitnessFunction(int targetAmount) {
        this.targetAmount = targetAmount;
    }

    @Override
    public double evaluate(List<Gene> genes) {

        int changeAmount = getAmountOfChange(genes);
        int totalCoins = getTotalNumberOfCoins(genes);
        int changeDifference = Math.abs(targetAmount - changeAmount);

        double fitness = (99 - changeDifference);

        // Step 2: If the solution amount equals the target amount, then
        // we add additional fitness points for solutions representing fewer
        // total coins.
        // -----------------------------------------------------------------
        if (changeAmount == targetAmount) {
            fitness += 100 - (10 * totalCoins);
        }

        return fitness;

    }

    private int getAmountOfChange(List<Gene> genes) {
        Gene quarterGene = (Gene) genes.get(0);
        Gene dimeGene = (Gene) genes.get(1);
        Gene nickelGene = (Gene) genes.get(2);
        Gene pennyGene = (Gene) genes.get(3);

        int numQuarters = ((Coin) quarterGene.getVal()).getNumberOfCoins();
        int numDimes = ((Coin) dimeGene.getVal()).getNumberOfCoins();
        int numNickels = ((Coin) nickelGene.getVal()).getNumberOfCoins();
        int numPennies = ((Coin) pennyGene.getVal()).getNumberOfCoins();

        return (numQuarters * 25) + (numDimes * 10) + (numNickels * 5) + numPennies;
    }

    private int getTotalNumberOfCoins(List<Gene> genes) {

        int totalNumberOfCoins = 0;

        for (Gene gene : genes) {
            int numberOfCoins = ((Coin) gene.getVal()).getNumberOfCoins();
            totalNumberOfCoins = totalNumberOfCoins + numberOfCoins;

        }
        return totalNumberOfCoins;

    }
}
