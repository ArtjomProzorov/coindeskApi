package com.coindesk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


/**
 * {@link Data} @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor in one @Data annotation
 * {@link JsonIgnoreProperties} Annotation ignores processing of JSON properties
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {


    private String rate;
    private String description;
    private String code;



}
