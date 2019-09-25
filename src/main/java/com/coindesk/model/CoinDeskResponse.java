package com.coindesk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import java.util.Map;

/**
 * {@link Data} @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor in one @Data annotation
 * {@link JsonIgnoreProperties} Annotation ignores processing of JSON properties
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinDeskResponse {

    private Map<String, Currency> bpi;
    private Time time;



}


