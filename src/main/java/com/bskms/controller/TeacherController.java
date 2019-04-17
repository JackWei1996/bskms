/**
 * 
 */
package com.bskms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bskms.bean.Children;
import com.bskms.bean.ClaTea;
import com.bskms.bean.Classes;
import com.bskms.bean.Notice;
import com.bskms.bean.Page;
import com.bskms.bean.Pay;
import com.bskms.bean.Sign;
import com.bskms.bean.User;
import com.bskms.service.ClassService;
import com.bskms.service.NoticeService;
import com.bskms.service.PageService;
import com.bskms.service.SignService;
import com.bskms.service.StudentService;
import com.bskms.service.UserService;
import com.bskms.utils.PropertyUtil;

/**
 * @author samsung
 *
 */
@Controller
@RequestMapping(value = "/ls")
public class TeacherController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private SignService signService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/stu")
	public String stu(Model model) {
		
		return "ls/stuPage";
	}
	//学生管理
	
		/**
		 * Method name: teacherPage <BR>
		 * Description: 教师管理页面 <BR>
		 * 
		 * @return String<BR>
		 */
		@RequestMapping(value = "/stuMG")
		public String teaMG() {
			return "ls/student";
		}
		
		/**
		 * Method name: getAllStudentByLimit <BR>
		 * Description: 根据条件获取所有教师 <BR>
		 * 
		 * @param userParameter
		 * @return Object<BR>
		 */
		@RequestMapping("/getAllStudentByLimit")
		@ResponseBody
		public Object getAllStudentByLimit(Children stuParameter) {
			return studentService.getAllStudentByLimit(stuParameter);
		}
		
		/**
		 * Method name: addStuPage <BR>
		 * Description: 增加教师界面 <BR>
		 * 
		 * @return String<BR>
		 */
		@RequestMapping(value = "/addStuPage")
		public String addStuPage(Integer id, Model model) {
			model.addAttribute("manageStu", id);
			if (null != id) {
				Children student = studentService.selectByPrimaryKey(id);
				model.addAttribute("manageStu", student);
			}
			List<Classes> classes=classService.selectAllClasses();
			model.addAttribute("cla", classes);
			return "ls/StuPageAdd";
		}
		
		/**
		 * Method name: addStu <BR>
		 * Description: 教师添加 <BR>
		 * 
		 * @param user
		 * @return String<BR>
		 */
		@ResponseBody
		@RequestMapping("/addStu")
		public String addStu(Children student) {
			try {
				
				studentService.addStudent(student);
				return "SUCCESS";
			} catch (Exception e) {
				return "ERR";
			}
		}

		/**
		 * Method name: updateStudent <BR>
		 * Description: 更新教师 <BR>
		 * 
		 * @param user
		 * @return String<BR>
		 */
		@ResponseBody
		@RequestMapping("/updateStudent")
		public String updateStudent(Children studnet) {
			return studentService.updateStu(studnet);
		}
		
		/**
		 * Method name: delClaTea <BR>
		 * Description: 批量删除教师<BR>
		 * 
		 * @param ids
		 * @return String<BR>
		 */
		@RequestMapping(value = "delStudent")
		@ResponseBody
		@Transactional
		public String delStudent(String[] ids) {
			try {
				for (String id : ids) {
					studentService.delStudentById(Integer.parseInt(id));
				}
				return "SUCCESS";
			} catch (Exception e) {
				
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return "ERROR";
			}
		}
		
		//公告管理
		
			/**
			 * Method name: gg <BR>
			 * Description: 教师管理页面 <BR>
			 * 
			 * @return String<BR>
			 */
			@RequestMapping(value = "/gg")
			public String gg() {
				return "ls/notice";
			}
			
			/**
			 * Method name: getAllNoticeByLimit <BR>
			 * Description: 根据条件获取所有教师 <BR>
			 * 
			 * @param userParameter
			 * @return Object<BR>
			 */
			@RequestMapping("/getAllNoticeByLimit")
			@ResponseBody
			public Object getAllNoticeByLimit(Notice noticeParameter) {
				return noticeService.getAllNoticeByLimit(noticeParameter);
			}
			
			/**
			 * Method name: addStuPage <BR>
			 * Description: 增加教师界面 <BR>
			 * 
			 * @return String<BR>
			 */
			@RequestMapping(value = "/addNoticePage")
			public String addNoticePage(Integer id, Model model) {
				model.addAttribute("manageNotice", id);
				if (null != id) {
					Notice notice = noticeService.selectByPrimaryKey(id);
					model.addAttribute("manageNotice", notice);
				}
				
				return "ls/noticeAdd";
			}
			
			/**
			 * Method name: addStu <BR>
			 * Description: 教师添加 <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/addNotice")
			public String addNotice(Notice notice) {
				try {
					notice.setCreatTime(new Date());
					noticeService.addNotice(notice);
					return "SUCCESS";
				} catch (Exception e) {
					return "ERR";
				}
			}

			/**
			 * Method name: updateStudent <BR>
			 * Description: 更新教师 <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/updateNotice")
			public String updateNotice(Notice notice) {
				return noticeService.updateStu(notice);
			}
			
			/**
			 * Method name: delClaTea <BR>
			 * Description: 批量删除教师<BR>
			 * 
			 * @param ids
			 * @return String<BR>
			 */
			@RequestMapping(value = "delNotice")
			@ResponseBody
			@Transactional
			public String delNotice(String[] ids) {
				try {
					for (String id : ids) {
						noticeService.delNoticeById(Integer.parseInt(id));
					}
					return "SUCCESS";
				} catch (Exception e) {
					
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return "ERROR";
				}
			}
			
			//考勤管理
			
			/**
			 * Method name: lskq <BR>
			 * Description: 教师管理页面 <BR>
			 * 
			 * @return String<BR>
			 */
			@RequestMapping(value = "/lskq")
			public String lskq() {
				return "ls/sign";
			}
			
			/**
			 * Method name: getAllSignByLimit <BR>
			 * Description: 根据条件获取所有教师 <BR>
			 * 
			 * @param userParameter
			 * @return Object<BR>
			 */
			@RequestMapping("/getAllSignByLimit")
			@ResponseBody
			public Object getAllSignByLimit(Sign signParameter) {
				return signService.getAllSignByLimit(signParameter);
			}
			
		
			//打卡
			@RequestMapping(value = "/qianDaoTui")
			public String qianDaoTui() {
				return "ls/daKa";
			}
			/**
			 * Method name: addStu <BR>
			 * Description: 教师添加 <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/addSign")
			public String addSign(Sign sign) {
			    Subject subject = SecurityUtils.getSubject();
				User user = (User) subject.getPrincipal();
				try {
					Date date=new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
					String time = formatter.format(date).split(" ")[2];
					String time1 = formatter.format(date).split(" ")[1];
					
					String s=PropertyUtil.getConfigureProperties("startTime");
					
					if(time.equals("上午") && time1.compareTo(s)>0) {
						sign.setState(1);
					}else if(time.equals("下午") && time1.compareTo(s)<0) {
						sign.setState(3);
					}
					sign.setType(1);
					sign.setSignIn(date);
					sign.setKqrId(user.getUserId());
					sign.setKqrType(user.getUserState());
					signService.addSign(sign);
					return "SUCCESS";
				} catch (Exception e) {
					return "ERR";
				}
			}

			/**
			 * Method name: updateStudent <BR>
			 * Description: 更新教师 <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/updateSign")
			public String updateSign(Sign sign) {
				return signService.updateSign(sign);
			}
			
			/**
			 * Method name: delClaTea <BR>
			 * Description: 批量删除教师<BR>
			 * 
			 * @param ids
			 * @return String<BR>
			 */
			@RequestMapping(value = "delSign")
			@ResponseBody
			@Transactional
			public String delSign(String[] ids) {
				try {
					for (String id : ids) {
						signService.delSignById(Integer.parseInt(id));
					}
					return "SUCCESS";
				} catch (Exception e) {
					
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return "ERROR";
				}
			}
			
}
