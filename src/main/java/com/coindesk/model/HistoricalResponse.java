package com.coindesk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;


/**
 * {@link Data} @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor in one @Data annotation
 * {@link JsonIgnoreProperties} Annotation ignores processing of JSON properties
 * {@link NoArgsConstructor} Constructor with no params
 */

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class HistoricalResponse {

    private Map<LocalDate, BigDecimal> bpi;

    public Map<LocalDate, BigDecimal> getBpi() {
        return bpi;
    }
}