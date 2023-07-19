package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YangXinYue
 * @date 2023/7/17 19:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {
    private int suggestionID;
    private int userID;
    private String userName;
    private String suggestion;

}
