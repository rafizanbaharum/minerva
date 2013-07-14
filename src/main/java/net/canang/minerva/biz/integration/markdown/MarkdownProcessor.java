package net.canang.minerva.biz.integration.markdown;

import org.markdown4j.ExtDecorator;
import org.markdown4j.Markdown4jProcessor;
import org.markdown4j.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @author rafizan.baharum
 * @since 7/14/13
 */
@Component("markdownProcessor")
public class MarkdownProcessor {

    private final static Markdown4jProcessor processor = new Markdown4jProcessor();

    @Autowired
    private AssetPlugin plugin;

    public MarkdownProcessor() {
//        processor.registerPlugins(plugin);
    }

    public void registerPlugins(Plugin... plugins) {
        processor.registerPlugins(plugins);
    }

    public String process(File file) throws IOException {
        return processor.process(file);
    }


    public String process(InputStream input) throws IOException {
        return processor.process(input);
    }


    public String process(Reader reader) throws IOException {
        return processor.process(reader);
    }


    public String process(String input) throws IOException {
        return processor.registerPlugins(new AssetPlugin()).process(input);
    }


    public void addStyleClass(String styleClass, String... tags) {
        processor.addStyleClass(styleClass, tags);
    }


    public void setDecorator(ExtDecorator decorator) {
        processor.setDecorator(decorator);
    }


    public void addHtmlAttribute(String name, String value, String... tags) {
        processor.addHtmlAttribute(name, value, tags);
    }
}
