package com.iweb.DAO;

import com.iweb.pojo.Address;

/**
 * @author YangXinYue
 * @date 2023/7/18 11:55
 */
public interface AddressDAO {
    /**用于向地址表增加数据
     * @param a 需要将所需内容封装在一个地址对象中
     */
    void insert(Address a);
}
