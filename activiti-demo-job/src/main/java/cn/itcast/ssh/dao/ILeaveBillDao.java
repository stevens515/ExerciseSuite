package cn.itcast.ssh.dao;

import cn.itcast.ssh.domain.LeaveBill;

import java.util.List;


public interface ILeaveBillDao {

    List<LeaveBill> findLeaveBillList();

    void saveLeaveBill(LeaveBill leaveBill);

    LeaveBill findLeaveBillById(Long id);

    void updateLeaveBill(LeaveBill leaveBill);

    void deleteLeaveBillById(Long id);


}
