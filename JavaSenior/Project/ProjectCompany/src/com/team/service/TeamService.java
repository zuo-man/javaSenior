package com.team.service;

import com.team.domain.*;

/**
 * @Description	关于开发团队成员的管理：添加、删除等
 * @version
 * @date 2021年10月3日下午5:48:34
 */

public class TeamService {
	//用来为开发团队新增成员自动生成团队中的唯一ID
	private static int counter = 1;//给memberId赋值使用
	private final int MAX_MEMBER = 5;//限制开发团队的人数
	private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
	private int total;//记录开发团队中实际的人数
	
	
	public TeamService() {
		super();
	}
	
	/**
	 * 	获取开发团队中所有的成员
	 */
	public Programmer[] getTeam(){
		Programmer[] team = new Programmer[total];
		for(int i = 0;i < team.length;i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	
	/**
	 * 	将指定的员工添加到开发团队中
	 */
	public void addMember(Employee e) throws TeamException {
		if(total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		if(!(e instanceof Programmer)) {//！非，若不是程序员
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		if(isExist(e)) {//若方法能对上员工，则返回true，执行抛异常
			throw new TeamException("该员工已在本开发团队中");
		}
		Programmer p = (Programmer)e;//将e强转成programmer类型
//		if("BUSY".equals(p.getStatus().getNAME())) {//if(p.getStatus().getNAME().equals("BUSY"))
//			throw new TeamException("该员工已是某团队成员");
//		}else if("VOCATION".equals(p.getStatus().getNAME())) {
//			throw new TeamException("该员工正在休假，无法添加");
//		}
		switch (p.getStatus()) {//bete\short\char\int\Stirng\枚举类对象
			case BUSY:
				throw new TeamException("该员工已是某团队成员");
			case VOCATION:
				throw new TeamException("该员工正在休假，无法添加");
		}

		//获取team已有成员中架构师、设计师、程序员的人数
		int numOfArch = 0 , numOfDes = 0 , numOfPro = 0;
		for(int i = 0;i < total;i++) {
			if(team[i] instanceof Architect) {//先判断小范围的，看team[i]是否为架构师
				numOfArch++;
			}else if(team[i] instanceof Designer) {
				numOfDes++;
			}else if(team[i] instanceof Programmer) {
				numOfPro++;
			}		
		}
		if(p instanceof Architect) {
			if(numOfArch >= 1) {
				throw new TeamException("团队至多只能有一名架构师");
			}
		}else if(p instanceof Designer) {
			if(numOfDes >= 2) {
				throw new TeamException("团队至多只能有两名设计师");
			}
		}else if(p instanceof Programmer) {
			if(numOfPro >= 3) {
				throw new TeamException("团队至多只能有三名程序员");
			}
		}
		
		//将p（或e）添加到现有的team中
		team[total++] = p;
		//p的属性赋值
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
		
		
	}
	
	//判断指定的员工是否已经存在于现有的开发团队中
	private boolean isExist(Employee e) {
		for(int i = 0;i < total;i++) {
			if(team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 	从团队中删除成员
	 */
	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for(;i < total;i++) {
			if(team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		//未找到指定memberId的情况
		if(i == total) {
			throw new TeamException("找不到指定mermberId的员工，删除失败");
		}
		
		//将后面元素依次往前移，后一个元素覆盖前一个元素，实现删除操作
		for(int j = i+1;j < total; j++) {
			team[j-1] = team[j];
		}
		team[total - 1] = null;//将最后元素赋值为null
		total--;
		//写法二：
//		team[--total] = null;
	}
	
	
}
