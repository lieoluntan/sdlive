package com.sdlive.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.sdlive.dao.GoTalkDao;
import com.sdlive.model.GoTalk;
import com.sdlive.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 毕书富
 * @version 创建时间:2018-3-23 下午6:28:00
 * 类说明
 */
@Repository("GoTalkDaoImpl")
public class GoTalkDaoImpl implements GoTalkDao{
	private Connection connection;
	boolean daoFlag = false;

	public GoTalkDaoImpl() {
		System.out.println("connection对象在GoTalkDaoImpl连接!");
	}

	@Override
	public boolean insert(GoTalk goTalk) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		connection = DBUtility.open();
		
		try {
			preparedStatement = connection
					.prepareStatement("insert INTO t_gotalk(uuid,name,username,usertype,ts,userpassword,extradata,jumpurl,domain,auth,serialTalk,pid,servername,openAndclose,urlRemark) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, goTalk.getUuid());
			preparedStatement.setString(2, goTalk.getName());
			preparedStatement.setString(3, goTalk.getUsername());
			preparedStatement.setInt(4, goTalk.getUsertype());
			preparedStatement.setInt(5, goTalk.getTs());
			preparedStatement.setString(6, goTalk.getUserpassword());
			preparedStatement.setString(7, goTalk.getExtradata());
			preparedStatement.setString(8, goTalk.getJumpurl());
			preparedStatement.setString(9, goTalk.getDomain());
			preparedStatement.setString(10, goTalk.getAuth());
			preparedStatement.setInt(11, goTalk.getSerialTalk());
			preparedStatement.setInt(12, goTalk.getPid());
			preparedStatement.setString(13, goTalk.getServername());
			preparedStatement.setString(14, "open");
			preparedStatement.setString(15, goTalk.getUrlRemark());
			preparedStatement.executeUpdate();
			System.out.println("^^在执行GoTalkDaoImpl中的添加insert");
			daoFlag = true;
			return daoFlag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("^^在执行GoTalkDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
			e.printStackTrace();
			daoFlag = false;
			return daoFlag;
		} finally {
			ResultSet rs = null;
			DBUtility.close(rs, preparedStatement, connection);
		}
	}

}
