package net.canang.minerva.biz.integration.springacl;

import net.canang.minerva.core.model.CmFlowState;

import java.util.Date;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmAclDao {

    List<CmRecord> findRecord(String filter, Class clazz, CmPermission view);

    List<CmRecord> findRecord(String filter, Class clazz, CmPermission view, Integer offset, Integer limit);

    List<CmRecord> findRecord(String filter, CmFlowState flowType, Date startDate, Date endDate, Class clazz, CmPermission view, Integer offset, Integer limit);

    List<CmRecord> findRecord(String filter, Date startDate, Date endDate, Class clazz, CmPermission view, Integer offset, Integer limit);

    Integer countRecord(Date startDate, Date endDate, Class clazz, CmPermission view);

    Integer countRecord(String filter, Class clazz, CmPermission view);

    Integer countRecord(String filter, Date startDate, Date endDate, Class clazz, CmPermission view);

    Integer countRecord(String filter, CmFlowState flowState, Date startDate, Date endDate, Class clazz, CmPermission view);

    List<CmRecord> findRecord(Class clazz, CmPermission view, Integer offset, Integer limit);
}
