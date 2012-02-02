package com.ks.code.core.writer;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.zxing.WriterException;

public interface KorraCodeWriterCallback<T> {
	T write(T domain) throws WriterException, FileNotFoundException, IOException;
}
