package net.canang.minerva.biz.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public class EmailEvent extends ApplicationEvent {

    private String from;
    private String to;
    private String subject;
    private String body;

    public EmailEvent(String from, String to, String subject, String body) {
        super(from);
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
