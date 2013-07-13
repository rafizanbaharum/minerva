package net.canang.minerva.core.dao;

import net.canang.minerva.core.RecursiveGroupException;
import net.canang.minerva.core.model.CmPrincipal;
import net.canang.minerva.core.model.CmPrincipalType;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
public interface CmPrincipalDao {

    //principal

    CmPrincipal findById(Long id);

    CmPrincipal findByName(String name);

    List<CmPrincipal> findAllPrincipals();

    List<CmPrincipal> findPrincipals(String filter);

    List<CmPrincipal> findPrincipals(String filter, CmPrincipalType type);

    List<CmPrincipal> findPrincipals(Integer offset, Integer limit);

    Set<GrantedAuthority> loadEffectiveAuthorities(CmPrincipal principal) throws RecursiveGroupException;

}
