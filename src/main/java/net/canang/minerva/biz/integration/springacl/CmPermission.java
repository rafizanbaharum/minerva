package net.canang.minerva.biz.integration.springacl;

import org.springframework.security.acls.domain.AbstractPermission;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public class CmPermission extends AbstractPermission {

    private static final long serialVersionUID = 1L;

    public static final CmPermission VIEW = new CmPermission(1 << 0, 'V'); //   0000001 // 1
    public static final CmPermission CREATE = new CmPermission(1 << 1, 'C'); // 0000010 // 2
    public static final CmPermission UPDATE = new CmPermission(1 << 2, 'U'); // 0000100 //  4
    public static final CmPermission DELETE = new CmPermission(1 << 3, 'D'); // 0001000 // 8
    public static final CmPermission CANCEL = new CmPermission(1 << 4, 'K'); // 0010000 // 16
    public static final CmPermission PRINT = new CmPermission(1 << 5, 'P'); //  0100000 // 32
    public static final CmPermission ADMIN = new CmPermission(1 << 6, 'A'); //  1000000 // 64

    protected CmPermission(int mask, char code) {
        super(mask, code);
    }

    protected CmPermission(int mask) {
        super(mask);
    }
}