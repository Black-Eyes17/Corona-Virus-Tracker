package com.example.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.springframework.stereotype.Component;

@Component
public class InputStreamProcessing {
    
	public String processInputStream(InputStream inputStream) throws IOException {
		if (inputStream != null) {
			Writer inputWriter = new StringWriter();

			char[] buffer = new char[2048];
			try {
				Reader inputReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				int counter;
				while ((counter = inputReader.read(buffer)) != -1) {
					inputWriter.write(buffer, 0, counter);
				}
			} finally {
				inputStream.close();
			}
			return inputWriter.toString();
		} else {
			return "No Contents";
		}
	}

}
