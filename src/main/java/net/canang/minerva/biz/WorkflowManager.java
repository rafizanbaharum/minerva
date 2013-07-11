package net.canang.minerva.biz;

import net.canang.minerva.core.model.CmGroup;
import net.canang.minerva.core.model.CmUser;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface WorkflowManager {

    CmUser getCurrentUser();

    CmGroup getAdminGroup();

    boolean isProcessDefExists(String processDef);

    String deploy(String processDef, String processFile);

    Map<String, Object> getVariables(String processId);

    Task findTask(String taskId);

    Task findTaskByVariable(String variable, Object value);

    List<Task> findTasks(String taskName);

    List<IdentityLink> getIdentityLinksForTask(Task task);

    List<Task> findAssignedTasks(String taskPrefix);

    List<Task> findAssignedTasks(String taskPrefix, Integer offset, Integer limit);

    List<Task> findAssignedTasks(String filter, String taskPrefix, Integer offset, Integer limit);

    List<Task> findCandidateTasks(String taskPrefix);

    List<Task> findCandidateTasks(String taskPrefix, Integer offset, Integer limit);

    List<Task> findCandidateTasks(String filter, String taskPrefix, Integer offset, Integer limit);

    Integer countAssignedTask(String taskPrefix);

    Integer countAssignedTask(String filter, String taskPrefix);

    Integer countCandidateTask(String taskPrefix);

    Integer countCandidateTask(String filter, String taskPrefix);

    void claimTask(Task task);

    void releaseTask(Task task);

    void stealTask(Task task);

    void assignTask(Task task);

    void assignTask(Task task, String username);

    void completeTask(Task task);

    void completeTask(Task task, Map<String, Object> variables);

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
