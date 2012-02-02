package com.ks.code.core.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.ks.code.creator.domain.CodeCreator;
import com.ks.code.creator.domain.aggregate.CodeFile;
import com.ks.code.creator.domain.aggregate.CodeSizeType;

@Component
public class CodeTemplate {

	@Autowired private KorraCodeMultiFormatWriter codeWriter;
	@Autowired private KorraCodeWriterTemplate korraCodeWriterTemplate;
	
	@Value("${korra.code.dir}") private String codeDir;
	@Value("${korra.code.url}") private String codeUrl;	
	@Value("${korra.short.url}") private String shortUrl;	
	
	public CodeCreator write(final CodeCreator codeCreator) {
		KorraCodeWriterCallback<CodeCreator> strategy = new KorraCodeWriterCallback<CodeCreator>() {
			@Override
			public CodeCreator write(CodeCreator codeCreator) throws WriterException, FileNotFoundException, IOException {
				
				
				for (int i = 0; i < CodeSizeType.values().length; i++) {
					CodeSizeType codeSizeType = CodeSizeType.values()[i];
					int width = 0; int height = 0;
					if(codeSizeType.name().equals(CodeSizeType.P100.name())){
						width = 100; height = 100;
					} else if(codeSizeType.name().equals(CodeSizeType.P200.name())){
						width = 200; height = 200;
					} else if(codeSizeType.name().equals(CodeSizeType.P400.name())){
						width = 400; height = 400;
					}
					if(width == 0) {
						width = 100; height = 100;
					}
					String fileName = Long.toString(System.currentTimeMillis()) + "_" + codeSizeType.name().toLowerCase() + ".png";
					String fileDir = codeDir + File.separator + fileName;
					CodeFile codeFile = new CodeFile();
					BarcodeFormat barcodeFormat = BarcodeFormat.valueOf(codeCreator.getCodeFormat().name());
					BitMatrix bitMatrix = codeWriter.encode(shortUrl + codeCreator.getShortUrl(), barcodeFormat, width, height);
					MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File(fileDir)));	
					codeFile.setFileDir(fileDir);
					codeFile.setFileUrl(codeUrl + "/" + fileName);
					codeFile.setCodeCreator(codeCreator);//역상
					codeCreator.getCodeFiles().add(codeFile);
				}
				return codeCreator;
			}
		};
		CodeCreator result = korraCodeWriterTemplate.writeEncode(strategy, codeCreator);
		
		return result;
	}
	
}
