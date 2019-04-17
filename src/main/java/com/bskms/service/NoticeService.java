/**
 * 
 */
package com.bskms.service;

import com.bskms.bean.Notice;

/**
 * @author samsung
 *
 */
public interface NoticeService {

	Object getAllNoticeByLimit(Notice noticeParameter);

	Notice selectByPrimaryKey(Integer id);

	void addNotice(Notice notice);

	String updateStu(Notice notice);

	void delNoticeById(Integer parseInt);

}
