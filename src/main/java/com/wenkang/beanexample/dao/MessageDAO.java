package com.wenkang.beanexample.dao;
import com.wenkang.beanexample.bean.Message;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
/**
 * Created by wenka on 2017/4/7.
 */
public class MessageDAO
{
    public static List<Message> queryMessageList()
    {
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList;
        SqlSession sqlSession = null;
        try
        {
            sqlSession = dbAccess.getSqlSession();
            messageList = sqlSession.selectList("Message.queryMessageList");

        } finally
        {
            if (sqlSession!=null)
            {
                sqlSession.close();
            }
        }
        return messageList;
    }
}
