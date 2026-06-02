package finxchange;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class StaticRateProvider implements ExchangeRateProvider {

    private Map<String, BigDecimal> rates = new HashMap<>();

    public StaticRateProvider() {
        // Base: USD
        rates.put("USD_INR", new BigDecimal("83.20"));
        rates.put("USD_EUR", new BigDecimal("0.92"));
        rates.put("USD_GBP", new BigDecimal("0.78"));

        // Reverse rates
        rates.put("INR_USD", new BigDecimal("0.012"));
        rates.put("EUR_USD", new BigDecimal("1.08"));
        rates.put("GBP_USD", new BigDecimal("1.27"));
    }

    @Override
    public BigDecimal getRate(String from, String to) {
        return rates.get(from + "_" + to);
    }
}