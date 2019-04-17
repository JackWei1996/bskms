/**
 * 
 */
package com.bskms.service;

import com.bskms.bean.Sign;

/**
 * @author samsung
 *
 */
public interface SignService {

	Object getAllSignByLimit(Sign signParameter);

	Sign selectByPrimaryKey(Integer id);

	void addSign(Sign sign);

	String updateSign(Sign sign);

	void delSignById(Integer parseInt);

}
