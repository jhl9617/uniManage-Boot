package org.webMonster.uniManageBoot.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchRoom {

    private String sv1;  //search value
    private String sv2;  //search value
    private String sv3;  //search value

}
