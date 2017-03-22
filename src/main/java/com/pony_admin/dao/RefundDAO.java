package com.pony_admin.dao;

import com.pony_admin.domain.RefundEntry;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/20
 */
public interface RefundDAO {

    List<RefundEntry> getAllRefund();
}
