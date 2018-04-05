package lambda.designWithLambda;

/**
 * Created by Uwe Sauerbrei on 25.02.2018
 */
class Asset {

    public enum AssetType {BOND, STOCK}

    private final AssetType type;
    private final int value;

    Asset(AssetType type, int value) {
        this.type = type;
        this.value = value;
    }

    AssetType getType() {
        return type;
    }

    int getValue() {
        return value;
    }

    private void doIt() {
    }
}
