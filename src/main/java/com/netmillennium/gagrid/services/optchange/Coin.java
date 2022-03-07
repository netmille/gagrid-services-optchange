package com.netmillennium.gagrid.services.optchange;

import java.io.Serializable;

/**
 * 
 * POJO to model a coin
 * 
 * 
 *
 */
public class Coin implements Serializable {

    public static enum CoinType {
                                 PENNY, QUARTER, NICKEL, DIME
    };

    private int numberOfCoins = 0;

    private CoinType coinType = null;

    public Coin(CoinType coinType, int numberOfCoins) {
        this.coinType = coinType;
        this.numberOfCoins = numberOfCoins;
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    public CoinType getCoinType() {
        return coinType;
    }

    public void setCoinType(CoinType coinType) {
        this.coinType = coinType;
    }

	@Override
	public String toString() {
		return "Coin [numberOfCoins=" + numberOfCoins + ", coinType=" + coinType + "]";
	}

}
