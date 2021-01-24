package com.abc.performancemanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//员工每个月的效绩
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Achievements {

    private String acId;
    private String acTeam;
    private String acPost;
    private String acDate;
    private Double acValue;
    private String acDepart;
    private Double acSalary;

}
