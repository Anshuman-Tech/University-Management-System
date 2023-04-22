package com.ums.university.management.system.Service.DAO;

public interface EmailService {

    void simpleEmail(String to,String body,String subject);

    void emailWithSingleAttachment(String to,String body,String subject,String attachment);

    void emailWithMultipleAttachments(String to,String body,String subject,String[] attachment);
}
