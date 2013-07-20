package net.canang.minerva.biz.integration.markdown;

import org.markdown4j.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * {{asset id=11}}
 *
 * @author rafizan.baharum
 * @since 7/14/13
 */
@Component("assetPlugin")
public class AssetPlugin extends Plugin {

    private Logger log = LoggerFactory.getLogger(AssetPlugin.class);

    public AssetPlugin() {
        super("asset");
    }


    @Override
    public void emit(StringBuilder out, List<String> lines, Map<String, String> params) {
        log.debug("emit");
        out.append("TEST");
    }
}
