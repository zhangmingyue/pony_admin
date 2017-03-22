package com.pony_admin.service.Impl;

import com.pony_admin.dao.RefundDAO;
import com.pony_admin.domain.RefundEntry;
import com.pony_admin.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/20
 */
@Service
public class RefundServiceImpl implements RefundService {
    @Autowired
    private RefundDAO refundDAO;

    @Override
    public List<RefundEntry> getAllRefund() {
        return refundDAO.getAllRefund();
    }
}
