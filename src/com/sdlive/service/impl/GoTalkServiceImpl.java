package com.sdlive.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sdlive.dao.GoTalkDao;
import com.sdlive.model.GoTalk;
import com.sdlive.service.GoTalkService;
import com.sdlive.utilityTalk.MD5Util;

/**
 *树袋老师
 * @author 作者 毕书富
 * @version 创建时间:2018-3-23 下午6:29:04
 * 类说明
 */
@Service("GoTalkServiceImpl")
public class GoTalkServiceImpl implements GoTalkService{
	@Resource(name="GoTalkDaoImpl")
	private GoTalkDao goTalkDao;
	Logger logger = Logger.getLogger(GoTalkServiceImpl.class);
	MD5Util md5=new MD5Util();
	
	@Override
	public boolean insert(GoTalk goTalk) {
		// TODO Auto-generated method stub
		GoTalk defaultGoTalk=new GoTalk();
		goTalk.setDomain(defaultGoTalk.getDomain());
		goTalk.setSerialTalk(defaultGoTalk.getSerialTalk());
		goTalk.setUsertype(defaultGoTalk.getUsertype());
		goTalk.setPid(defaultGoTalk.getPid());
		
		String authStr ="5NIWjlgmvqwbt494"+goTalk.getTs()+goTalk.getSerialTalk()+goTalk.getUsertype();
		String auth=md5.MD5(authStr);
		
		
		
		System.out.println(goTalk);
		return false;
	}
	
}
