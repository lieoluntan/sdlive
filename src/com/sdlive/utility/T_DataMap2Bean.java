package com.sdlive.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import com.sdlive.model.Department;

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
