package LE.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DoUrlHttpService {	
//	protected final static Log log = LogFactory.getLog(DoUrlHttpService.class);
	/**
	 * Post请求
	 *
	 * @param url         请求地址
	 * @param requestData 请求参数--key=value&key=value格式
	 * @param name        接口名称
	 * @return 响应报文
	 * @throws Exception
	 */
	public static String doPost(String url, String requestData, String name) throws Exception {
		HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
//		log.info(name + "--URL：" + url);
//		log.info(name + "--请求报文：" + requestData);
		StringBuilder sb = new StringBuilder();
		String tempString;
		InputStream inputStream = null;
		OutputStream out = null;
		BufferedReader reader = null;
		try {
			// 设置请求方式为POST
			httpConn.setRequestMethod("POST");
			httpConn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.connect();
			
			out = httpConn.getOutputStream(); // 获取输出流对象
			httpConn.getOutputStream().write(requestData.getBytes(StandardCharsets.UTF_8)); // 发送报文编码为UTF-8
			out.flush();
			
			// 服务器响应状态
			int code = httpConn.getResponseCode();
			if (code == HttpURLConnection.HTTP_OK) {
				inputStream = httpConn.getInputStream();
			} else {
				inputStream = httpConn.getErrorStream();
			}
			
//			byte[] b = new byte[3];
//			inputStream.read(b);
//	        if (b[0] == -17 && b[1] == -69 && b[2] == -65){
	        	reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
//	        }else{//返回流非UTF-8 默认其为GBK编码
//	        	reader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
//	        }
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
			}
		} catch (Exception e) {
			throw new Exception(name + "异常，异常信息为：" + e.getMessage(), e);
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (out != null) {
				out.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
//		String responseData = HtmlUtils.htmlUnescape(sb.toString());
//		log.info(name + "--响应报文：" + responseData);
//		return responseData;
		return sb.toString();
	}
}
