package com.google.zxing.qrcode;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/applicationContext*.xml"
		})
public class QRCodeWriterTest{

	@Test
	public void web_Test(){
//		 QRCodeWriter q = new QRCodeWriter();
//		 String text = "한글 테스트";
//		 text = new String(text.getBytes("UTF-8"), "ISO-8859-1");
//		 int width=200;
//		int height=200;
//		BitMatrix bitMatrix = q.encode(text, BarcodeFormat.QR_CODE, width, height);
//		 out.clear(); // clear buffer
//		 ServletOutputStream outputStream = response.getOutputStream();
//		 MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);
//		 outputStream.flush();
//		 outputStream.close();

		QRCodeWriter q = new QRCodeWriter();
		  try {
		   String text = "test";
		   text = new String(text.getBytes("UTF-8"), "ISO-8859-1");
		   BitMatrix bitMatrix = q.encode(text, BarcodeFormat.QR_CODE, 100, 100);
		   MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File("d:\\qrcode.png")));
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
	}
//http://code.google.com/p/zxing/wiki/GettingStarted
}
