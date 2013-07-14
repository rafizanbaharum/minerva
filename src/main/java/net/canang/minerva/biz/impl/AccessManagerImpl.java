package net.canang.minerva.biz.impl;

import net.canang.minerva.biz.AccessManager;
import net.canang.minerva.biz.ManagerSupport;
import net.canang.minerva.biz.integration.springacl.CmAclDao;
import net.canang.minerva.biz.integration.springacl.CmPermission;
import net.canang.minerva.biz.integration.springacl.CmRecord;
import net.canang.minerva.core.model.CmFlowState;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Transactional
public class AccessManagerImpl extends ManagerSupport implements AccessManager {

    @Autowired
    private CmAclDao aclDao;

    @Autowired
    private TaskService taskService;

    @Override
    public List<CmRecord> findAuthorizedRecords(String filter, Class clazz, Integer offset, Integer limit) {
        return aclDao.findRecord(filter, clazz, CmPermission.VIEW, offset, limit);
    }

    @Override
    public List<CmRecord> findAuthorizedRecords(String filter, Date startDate, Date endDate, Class clazz, Integer offset, Integer limit) {
        return aclDao.findRecord(filter, startDate, endDate, clazz, CmPermission.VIEW, offset, limit);
    }

    @Override
    public List<CmRecord> findAuthorizedRecords(String filter, CmFlowState flowType, Date startDate, Date endDate, Class clazz, Integer offset, Integer limit) {
        return aclDao.findRecord(filter, flowType, startDate, endDate, clazz, CmPermission.VIEW, offset, limit);
    }

    @Override
    public List<CmRecord> findAuthorizedRecords(String filter, Class clazz) {
        return aclDao.findRecord(filter, clazz, CmPermission.VIEW);
    }

    @Override
    public List<CmRecord> findAuthorizedRecords(Class clazz, Integer offset, Integer limit) {
        return aclDao.findRecord(clazz, CmPermission.VIEW, offset, limit);
    }

    @Override
    public Integer countAuthorizedRecord(String filter, Date startDate, Date endDate, Class clazz) {
        return aclDao.countRecord(filter, startDate, endDate, clazz, CmPermission.VIEW);
    }

    @Override
    public Integer countAuthorizedRecord(String filter, CmFlowState flowType, Date startDate, Date endDate, Class clazz) {
        return aclDao.countRecord(filter, flowType, startDate, endDate, clazz, CmPermission.VIEW);
    }

    @Override
    public Integer countAuthorizedRecord(String filter, Class clazz) {
        return aclDao.countRecord(filter, clazz, CmPermission.VIEW);
    }

    private List<CmRecord> decorate(List<CmRecord> records, String variableName) {
        for (CmRecord record : records) {
            // TODO:
//            Task task = taskService.findTaskByVariable(variableName, record.getId());
//            // if assignee null, populate candidate or assignee?
//            if (null != task) {
//                record.setAssignee(task.getAssignee());
//                if (null == task.getAssignee()) record.setCandidate(getIdentityLinksForTaskAsString(task));
//                if (null == task.getAssignee()) record.setAssignee(getIdentityLinksForTaskAsString(task));
//            }
        }
        return records;
    }

    private String getIdentityLinksForTaskAsString(Task task) {
        StringBuilder builder = new StringBuilder();
        List<IdentityLink> identityLinks = taskService.getIdentityLinksForTask(task.getId());
        for (IdentityLink identityLink : identityLinks) {
            builder.append(identityLink.getGroupId());
            builder.append(",");
        }
        builder.delete(builder.length() - 1, builder.length()); // reverse the last comma
        return builder.toString();
    }

}
