package com.iweb.pojo;

import com.iweb.DAO.ManagerPowerDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YangXinYue
 * @date 2023/7/18 10:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    private int managerID;
    private String managerName;
}
