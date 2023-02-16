package com.campingmapping.team4.spring.t436mall.controller.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/Category")
public class CategoryController {

	@GetMapping("/paybyline")
	@ResponseBody
	public String adasdfasdf(@RequestParam("JsonOrderList") String jsonData) {

		String json = jsonData;
		String paymentUrl = null;
		try {
			// 建立連接
			URL url = new URL(
					"https://sandbox-api-pay.line.me/v2/payments/request");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 設置請求方法
			con.setRequestMethod("POST");

			// 設置header，加入Content-Type:application/json
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("X-LINE-ChannelId", "1657918027");
			con.setRequestProperty("X-LINE-ChannelSecret",
					"2b4a8fd0185a8c0934e4f72b3dc529f1");

			// 設置允許寫出
			con.setDoOutput(true);

			// 寫出json數據
			OutputStream os = con.getOutputStream();
			byte[] input = json.getBytes("utf-8");
			os.write(input, 0, input.length);
			os.close();

			// 讀取伺服器返回的數據
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream(), "utf-8"));
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
				String jsonStr = responseLine;
				try {
					ObjectMapper mapper = new ObjectMapper();
					JsonNode root = mapper.readTree(jsonStr);
					paymentUrl = root.path("info").path("paymentUrl")
							.path("web").asText();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentUrl;
	}

}
