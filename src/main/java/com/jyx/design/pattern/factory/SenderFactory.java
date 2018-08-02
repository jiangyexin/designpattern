package com.jyx.design.pattern.factory;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-02 17:54
 **/
public class SenderFactory {
    public static final String MAIL_TYPE = "mail";
    public static final String SMS_TYPE = "sms";
    public Sender produce(String type) {
        if (MAIL_TYPE.equals(type)) {
            return new MailSender();
        } else if (SMS_TYPE.equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型。type = [" + type + "]");
            return null;
        }
    }
}
