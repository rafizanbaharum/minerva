package net.canang.minerva.biz.impl;

import net.canang.minerva.biz.ManagerSupport;
import net.canang.minerva.biz.WorkflowManager;
import net.canang.minerva.core.dao.CmGroupDao;
import net.canang.minerva.core.model.CmGroup;
import net.canang.minerva.core.model.CmUser;
import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Service("workflowManager")
public class WorkflowManagerImpl extends ManagerSupport implements WorkflowManager, ApplicationContextAware {

    private static final Logger log = Logger.getLogger(WorkflowManagerImpl.class);

    private static final String WILDCARD = "%";

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    protected CmGroupDao groupDao;

    @Autowired(required = false)
    protected ProcessEngine processEngine;

    @Autowired(required = false)
    protected RuntimeService runtimeService;

    @Autowired(required = false)
    protected TaskService taskService;

    @Autowired(required = false)
    protected IdentityService identityService;

    @Autowired(required = false)
    protected HistoryService historyService;

    @Autowired(required = false)
    protected RepositoryService repositoryService;

    // ==================================================================================================== //
    // WORKFLOW
    // ==================================================================================================== //

    @PreDestroy
    public void preDestroy() {
        processEngine.close();
    }

    @Override
    public CmUser getCurrentUser() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth.getPrincipal() instanceof UserDetails) {
//            return ((FsUserDetails) auth.getPrincipal()).getUser();
//        } else {
//            return null;
//        }
        return null; // TODO
    }

    @Override
    public CmGroup getAdminGroup() {
        return null;// TODO: return groupDao.findByName(GRP_ADM);
    }

    @Override
    public boolean isProcessDefExists(String processDef) {
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        query.processDefinitionKey(processDef);
        return query.count() > 0;
    }

    @Override
    public String deploy(String processDef, String processFile) {
        return repositoryService.createDeployment().name(processDef).addClasspathResource(processFile).deploy().getId();
    }

    @Override
    public Map<String, Object> getVariables(String processId) {
        return runtimeService.getVariables(processId);
    }

    @Override
    public Task findTask(String taskId) {
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskId(taskId);
        return taskQuery.singleResult();
    }

    @Override
    public Task findTaskByVariable(String variable, Object value) {
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.processVariableValueEquals(variable, value);
        return taskQuery.singleResult();
    }

    @Override
    public List<Task> findTasks(String taskName) {
        log.debug("finding assigned task for user: " + getCurrentUser().getName());
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskName(taskName);
        taskQuery.orderByTaskCreateTime();
        taskQuery.desc();
        return taskQuery.list();
    }

    @Override
    public List<IdentityLink> getIdentityLinksForTask(Task task) {
        return taskService.getIdentityLinksForTask(task.getId());
    }

    @Override
    public List<Task> findAssignedTasks(String taskPrefix) {
        log.debug("finding assigned task for user: " + getCurrentUser().getName());
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskNameLike(taskPrefix + WILDCARD);
        taskQuery.taskAssignee(getCurrentUser().getName());
        taskQuery.orderByTaskCreateTime();
        taskQuery.desc();
        return taskQuery.list();
    }

    @Override
    public List<Task> findAssignedTasks(String taskPrefix, Integer offset, Integer limit) {
        log.debug("finding assigned task for user: " + getCurrentUser().getName());
        log.debug("task prefix: " + taskPrefix);
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskNameLike(WILDCARD + taskPrefix + WILDCARD);
        taskQuery.taskAssignee(getCurrentUser().getName());
        taskQuery.orderByTaskCreateTime();
        taskQuery.desc();
        return taskQuery.listPage(offset, limit);
    }

    @Override
    public List<Task> findAssignedTasks(String filter, String taskPrefix, Integer offset, Integer limit) {
        log.debug("finding assigned task for user: " + getCurrentUser().getName());
        log.debug("task prefix: " + taskPrefix);
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskNameLike(WILDCARD + taskPrefix + WILDCARD);
        taskQuery.taskAssignee(getCurrentUser().getName());
        taskQuery.orderByTaskCreateTime();
        taskQuery.desc();
        return taskQuery.listPage(offset, limit);
    }

    @Override
    public List<Task> findCandidateTasks(String taskPrefix) {
        log.debug("finding candidate task for user: " + getCurrentUser().getName());
        log.debug("task prefix: " + taskPrefix);
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskNameLike(WILDCARD + taskPrefix + WILDCARD);
        taskQuery.taskCandidateUser(getCurrentUser().getName());
        taskQuery.orderByTaskCreateTime();
        taskQuery.desc();
        return taskQuery.list();
    }

    @Override
    public List<Task> findCandidateTasks(String taskPrefix, Integer offset, Integer limit) {
        log.debug("finding candidate task for user: " + getCurrentUser().getName());
        log.debug("task prefix: " + taskPrefix);
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskNameLike(WILDCARD + taskPrefix + WILDCARD);
        taskQuery.taskCandidateUser(getCurrentUser().getName());
        taskQuery.orderByTaskCreateTime();
        taskQuery.desc();
        return taskQuery.listPage(offset, limit);
    }

    @Override
    public List<Task> findCandidateTasks(String filter, String taskPrefix, Integer offset, Integer limit) {
        log.debug("finding candidate task for user: " + getCurrentUser().getName());
        log.debug("task prefix: " + taskPrefix);
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskNameLike(WILDCARD + taskPrefix + WILDCARD);
        taskQuery.taskCandidateUser(getCurrentUser().getName());
        taskQuery.orderByTaskCreateTime();
        taskQuery.desc();
        return taskQuery.listPage(offset, limit);
    }

    @Override
    public Integer countAssignedTask(String taskPrefix) {
        log.debug("count assigned task for user: " + getCurrentUser().getName());
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskNameLike(WILDCARD + taskPrefix + WILDCARD);
        taskQuery.taskAssignee(getCurrentUser().getName());
        return (int) taskQuery.count();
    }

    @Override
    public Integer countAssignedTask(String filter, String taskPrefix) {
        log.debug("finding assigned task for user: " + getCurrentUser().getName());
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskNameLike(WILDCARD + taskPrefix + WILDCARD);
        taskQuery.taskAssignee(getCurrentUser().getName());
        return (int) taskQuery.count();
    }

    @Override
    public Integer countCandidateTask(String taskPrefix) {
        log.debug("count candidate task for user: " + getCurrentUser().getName());
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskNameLike(WILDCARD + taskPrefix + WILDCARD);
        taskQuery.taskCandidateUser(getCurrentUser().getName());
        return (int) taskQuery.count();
    }

    @Override
    public Integer countCandidateTask(String filter, String taskPrefix) {
        log.debug("finding candidate task for user: " + getCurrentUser().getName());
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskNameLike(WILDCARD + taskPrefix + WILDCARD);
        taskQuery.taskCandidateUser(getCurrentUser().getName());
        return (int) taskQuery.count();
    }

    @Override
    public void claimTask(Task task) {
        Validate.notNull(task, "Task cannot be null");
        log.debug("claiming for user: " + getCurrentUser().getName());
        taskService.claim(task.getId(), getCurrentUser().getName());
    }

    @Override
    public void releaseTask(Task task) {
        Validate.notNull(task, "Task cannot be null");
        log.debug("releasing for user: " + getCurrentUser().getName());
        taskService.claim(task.getId(), null);
    }

    @Override
    public void stealTask(Task task) {
        Validate.notNull(task, "Task cannot be null");
        log.debug("stealing for user: " + getCurrentUser().getName());
        taskService.claim(task.getId(), getCurrentUser().getName());
    }

    @Override
    public void assignTask(Task task) {
        Validate.notNull(task, "Task cannot be null");
        log.debug("assigning for user: " + getCurrentUser().getName());
        taskService.setAssignee(task.getId(), getCurrentUser().getName());
    }

    @Override
    public void assignTask(Task task, String username) {
        Validate.notNull(task, "Task cannot be null");
        taskService.setAssignee(task.getId(), username);
    }

    @Override
    public void completeTask(Task task) {
        Validate.notNull(task, "Task cannot be null");
        taskService.complete(task.getId());
    }

    @Override
    public void completeTask(Task task, Map<String, Object> variables) {
        Validate.notNull(task, "Task cannot be null");
        taskService.complete(task.getId(), variables);
    }
}
