package com.ks.code.core.writer;

import java.util.Hashtable;

import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.qrcode.QRCodeWriter;


@Component
public class KorraCodeMultiFormatWriter implements Writer {
	
	 public BitMatrix encode(String contents, BarcodeFormat format, int width, int height) throws WriterException {
	    return encode(contents, format, width, height, null);
	  }
/**
 * barcode format
 * 
 * 	QR_CODE,
	DATA_MATRIX,
	UPC_E,
	UPC_A,
	EAN_8,
	EAN_13,
	UPC_EAN_EXTENSION,
	CODE_128,
	CODE_39,
	CODE_93,
	CODABAR,
	ITF,
	RSS14,
	PDF417,
	RSS_EXPANDED
 */
	  public BitMatrix encode(String contents, BarcodeFormat format, int width, int height, Hashtable hints) throws WriterException {
	    Writer writer;
	    if (format == BarcodeFormat.QR_CODE) {
		  writer = new QRCodeWriter();
	    } else if (format == BarcodeFormat.EAN_8) {
	      writer = new EAN8Writer();
	    } else if (format == BarcodeFormat.EAN_13) {
	      writer = new EAN13Writer();
//	    } else if (format == BarcodeFormat.UPC_A) {
//	      writer = new UPCAWriter();
	    } else if (format == BarcodeFormat.CODE_39) {
	      writer = new Code39Writer();
	    } else if (format == BarcodeFormat.CODE_128) {
	      writer = new Code128Writer();
	    } else if (format == BarcodeFormat.ITF) {
	      writer = new ITFWriter();
	    } else {
	      throw new IllegalArgumentException("No encoder available for format " + format);
	    }
	    return writer.encode(contents, format, width, height, hints);
	  }
}
