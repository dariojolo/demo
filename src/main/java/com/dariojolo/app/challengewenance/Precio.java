package com.dariojolo.app.challengewenance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Precio {
    private String lprice;
    private String curr1;
    private String curr2;
}
