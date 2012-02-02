package com.ks.code.core.writer;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.zxing.WriterException;

@Component
public class KorraCodeWriterTemplate {

	@SuppressWarnings("finally")
	public <T> T writeEncode(KorraCodeWriterCallback<T> strategy, T initValue){
		T result = initValue;
		boolean state = true;

		try {
			result = strategy.write(result);
		} catch (WriterException e) {
			state = false;
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			state = false;
			e.printStackTrace();
		} catch (IOException e) {
			state = false;
			e.printStackTrace();
		}finally{
			if(state == false){
				result = null;
			}
			return result;
		}
	}
}
