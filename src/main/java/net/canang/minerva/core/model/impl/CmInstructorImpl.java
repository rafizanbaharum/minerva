package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmInstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_INSTRUCTOR")
@Entity(name = "CmInstructor")
public class CmInstructorImpl extends CmActorImpl implements CmInstructor{
}
