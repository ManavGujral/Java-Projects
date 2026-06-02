package finxchange;

import java.math.BigDecimal;

public interface ExchangeRateProvider {
    BigDecimal getRate(String from, String to);
}