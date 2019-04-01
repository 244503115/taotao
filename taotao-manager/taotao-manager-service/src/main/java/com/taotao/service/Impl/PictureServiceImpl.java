package com.taotao.service.Impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.service.PictureService;
import com.taotao.utils.FtpUtil;
import com.taotao.utils.IDUtils;

@Service
public class PictureServiceImpl implements PictureService {

	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@Override
	public Map uploadPicture(MultipartFile uploadFile) throws Exception {
		Map resultMap = new HashMap();
		try {
			// 生成一个新的文件名
			// 取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			// 生成新的文件名
			// UUID.randomUUID();
			String newName = IDUtils.genImageName();
			// 上传图片
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH,
					imagePath, newName, uploadFile.getInputStream());
			if (!result) {
				resultMap.put("error", 1);
				resultMap.put("massage", "文件上传失败");
				return resultMap;
			}
			resultMap.put("error", 0);
			resultMap.put("url", IMAGE_BASE_URL+ imagePath +"/" + newName);
			return resultMap;
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("massage", "文件上传发生异常");
			return resultMap;
		}
	}

}
