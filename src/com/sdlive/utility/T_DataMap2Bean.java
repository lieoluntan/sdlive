package com.sdlive.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import com.sdlive.model.Department;
import com.sdlive.model.GoTalk;

import com.sdlive.system.model.Resource;
import com.sdlive.system.model.Role;
import com.sdlive.system.model.RoleResource;
import com.sdlive.system.model.UserPK;
import com.sdlive.system.model.UserPK_Role;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午1:42:03 类说明
 */

public class T_DataMap2Bean {

	public Department MapToDepartment(Map<String, Object> map) {
		String name = (String) map.get("name");
		String remark = (String) map.get("remark");
		String createDate = (String) map.get("createDate");
		String modifyDate = (String) map.get("modifyDate");
		String createPeople = (String) map.get("createPeople");
		String modifyPeople = (String) map.get("modifyPeople");
		String openAndclose = (String) map.get("modifyPeople");
		String uuid = (String) map.get("uuid");
		Department department = new Department(uuid, name, remark);
		return department;

	}
	
	  public GoTalk MapToGoTalk(Map<String, Object> map) {
		    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		    String name = (String) map.get("name");
		    String urlRemark = (String) map.get("urlRemark");
		    String openAndclose = (String) map.get("openAndclose");
		    String domain = (String) map.get("domain");
		    
		    String serialTalk = (String) map.get("serialTalk");
		    if(serialTalk==null){
		    	serialTalk="0";
		    }
		    int serialTalk2=Integer.parseInt(serialTalk);
		    
		    String username = (String) map.get("username");
		    
		    
		    String usertype = (String) map.get("usertype");
		    if(usertype==null){
		    	usertype="0";
		    }
		    int userType2=Integer.parseInt(usertype);
		    String pid = (String) map.get("pid");
		    if(pid==null){
		    	pid="0";
		    }
		    int pid2=Integer.parseInt(pid);
		    
		    String ts = (String) map.get("ts");
		    int ts3;
		    String ts2 = null;
		    if(ts!=null){
		    	SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			    Date date=null;
			    try {
			    	date = format.parse(ts);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			    int timestamp = (int) (date.getTime() / 1000.0);
			    ts2=timestamp+"";
			    
		    }else{
		    	ts2="0";
		    	ts3=Integer.parseInt(ts2);
		    }
		    ts3=Integer.parseInt(ts2);
		    
		    String auth = (String) map.get("auth");
		    
		    String userpassword = (String) map.get("userpassword");
		    String servername = (String) map.get("servername");
		    String extradata = (String) map.get("extradata");
		    String jumpurl = (String) map.get("jumpurl");
		    
		    String createDate = (String) map.get("createDate");
		    String modifyDate = (String) map.get("modifyDate");
		    String createPeople = (String) map.get("createPeople");
		    String modifyPeople = (String) map.get("modifyPeople");
		    
		    GoTalk goTalk = new GoTalk(uuid, name, urlRemark, openAndclose, domain,serialTalk2,  username, userType2, pid2, ts3, auth, 
		    		userpassword, servername, extradata, jumpurl, createDate, modifyDate, createPeople, modifyPeople);
		    
		    goTalk.setName(name);
		    goTalk.setUsername(username);
		    goTalk.setUsertype(userType2);
		    goTalk.setTs(ts3);
		    goTalk.setUserpassword(userpassword);
		    goTalk.setExtradata(extradata);
		    goTalk.setJumpurl(jumpurl);
		    
		    
		    return goTalk;
		  }//end method



	public Role MapToRole(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		Role role = new Role(uuid, name, null, null, null, null, null, null);
		return role;
	}
	



	public UserPK MapToUserPK(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String uLogUser = (String) map.get("uLogUser");
		String uPassWord = (String) map.get("uPassWord");
		String uName = (String) map.get("uName");
		String empUuid = (String) map.get("empUuid");
		List<String> roleList = (List<String>) map.get("roleList");
		UserPK userPK = new UserPK(uuid, uLogUser, uPassWord, uName, roleList,
				empUuid);
		return userPK;
	}// end method MapToEmp

	public Role MapToUserRole(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		String modifyDate = (String) map.get("modifyDate");
		String createPeople = (String) map.get("createPeople");
		String modifyPeople = (String) map.get("modifyDate");
		String createDate = (String) map.get("createDate");
		String remark = (String) map.get("remark");
		List<String> rsList = (List<String>) map.get("rsList");
		Role role = new Role(uuid, name, modifyDate, createPeople,
				modifyPeople, createDate, remark, rsList);
		return role;
	}

	public Resource MapToResource(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String name = (String) map.get("name");
		// String campus = (String) map.get("campus");
		// String remark = (String) map.get("remark");

		// ClassRoom classRoom = new ClassRoom(uuid, name, campus, remark);

		Resource resource = new Resource(uuid, name, null, null, null, null,
				null);
		return resource;
	}// end method MapToEmp

	public RoleResource MapToRoleResource(Map<String, Object> map) {

		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String roleid = (String) map.get("roleid");
		String resourceid = (String) map.get("resourceid");

		RoleResource resource = new RoleResource(uuid, roleid, resourceid);
		return resource;
	}


	public UserPK_Role MapToUserPK_Role(Map<String, Object> map) {
		String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
		String userPkid = (String) map.get("userPkid");
		String roleid = (String) map.get("roleid");

		UserPK_Role userPK_role = new UserPK_Role(uuid, userPkid, roleid);
		return userPK_role;
	}// end method


}// end class T_DataMap2Bean
