package T4_01.service.impl;

import org.apache.commons.codec.digest.DigestUtils;

import T4_01.service.ToolService;

public class ToolServiceImpl implements ToolService {

	@Override
	public String loginsha1Hex(String password) {
		String sha1Hex = DigestUtils
				.sha1Hex(DigestUtils.sha1Hex(DigestUtils.sha1Hex(password)));
		return sha1Hex;
	}

	@Override
	public String rembersha1Hex(String password) {
		String sha1Hex = DigestUtils.sha1Hex(DigestUtils.sha1Hex(password));
		return sha1Hex;
	}
	@Override
	public String remberloginsha1Hex(String password) {
		String sha1Hex = DigestUtils.sha1Hex(password);
		return sha1Hex;
	}

}
