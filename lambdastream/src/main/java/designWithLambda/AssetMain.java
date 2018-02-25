package designWithLambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Uwe Sauerbrei on 25.02.2018
 */
public class AssetMain {

    private final List<Asset> assets = Arrays.asList(
            new Asset(Asset.AssetType.BOND, 1000),
            new Asset(Asset.AssetType.BOND, 2000),
            new Asset(Asset.AssetType.STOCK, 3000),
            new Asset(Asset.AssetType.STOCK, 4000)
    );

    public static void main(String[] args) {
        new AssetMain().doIt();
    }

    private void doIt() {
        totalOfAllBonds();
        totalOfAllAssets();
        sumAllStocks();
        sumAllBonds();
        sumAllValues();
    }

    private void totalOfAllBonds() {
        System.out.println("Total of all Bonds improved: " + AssetUtil.totalAssetValuesImproved(assets, asset -> asset.getType() == Asset.AssetType.BOND));
    }

    private void totalOfAllAssets() {
        System.out.println("Total of all assets improved: " + AssetUtil.totalAssetValuesImproved(assets, asset -> true));
    }

    private void sumAllStocks() {
        System.out.println("Total of all stocks: " + AssetUtil.totalStockValues(assets));
    }

    private void sumAllBonds() {
        System.out.println("Total of all bonds: " + AssetUtil.totalBondValues(assets));
    }

    private void sumAllValues() {
        System.out.println("Total of all assets: " + AssetUtil.totalAssetValues(assets));
    }
}
