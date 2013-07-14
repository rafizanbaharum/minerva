package net.canang.minerva.biz;

import net.canang.minerva.biz.integration.springacl.CmRecord;
import net.canang.minerva.core.model.CmFlowState;

import java.util.Date;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface AccessManager {

    List<CmRecord> findAuthorizedRecords(String filter, Class clazz, Integer offset, Integer limit);

    List<CmRecord> findAuthorizedRecords(String filter, Date startDate, Date endDate, Class clazz, Integer offset, Integer limit);

    List<CmRecord> findAuthorizedRecords(String filter, CmFlowState flowType, Date startDate, Date endDate, Class clazz, Integer offset, Integer limit);

    List<CmRecord> findAuthorizedRecords(String filter, Class clazz);

    List<CmRecord> findAuthorizedRecords(Class clazz, Integer offset, Integer limit);

    Integer countAuthorizedRecord(String filter, Date startDate, Date endDate, Class clazz);

    Integer countAuthorizedRecord(String filter, CmFlowState flowType, Date startDate, Date endDate, Class clazz);

    Integer countAuthorizedRecord(String filter, Class clazz);
}
