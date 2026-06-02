package finxchange;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyEngine {

    private ExchangeRateProvider rateProvider;

    public CurrencyEngine(ExchangeRateProvider provider) {
        this.rateProvider = provider;
    }

    public BigDecimal convert(String from, String to, BigDecimal amount) {
        BigDecimal rate = rateProvider.getRate(from, to);

        if (rate == null) {
            throw new IllegalArgumentException("Conversion rate not available!");
        }

        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }
}