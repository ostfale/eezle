package lambda.designWithLambda;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Uwe Sauerbrei on 25.02.2018
 */
class AssetUtil {

    static int totalAssetValues(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(Asset::getValue)
                .sum();
    }

    static int totalBondValues(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(asset -> asset.getType() == Asset.AssetType.BOND ? asset.getValue() : 0)
                .sum();
    }

    static int totalStockValues(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(asset -> asset.getType() == Asset.AssetType.STOCK ? asset.getValue() : 0)
                .sum();
    }

    /**
     * Simple use of the strategy pattern.
     *
     * @param assets        List of assets
     * @param assetSelector predicate used as a filter
     * @return summed values of filtered data
     */
    static int totalAssetValuesImproved(final List<Asset> assets, final Predicate<Asset> assetSelector) {
        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }
}
