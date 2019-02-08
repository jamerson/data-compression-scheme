package nl.company.challenge.compression;

public abstract class DecodingStrategyFactory {

    public static DecodingStrategyInterface getStrategy() {
        boolean useTrivial = System.getenv().get("USE_TRIVIAL_IMPLEMENTATION") != null && System.getenv().get("USE_TRIVIAL_IMPLEMENTATION").equals("1");

        if(useTrivial)
            return new TrivialDecodingStrategyImpl();
        return new RegularDecodingStrategyImpl();
    }
}