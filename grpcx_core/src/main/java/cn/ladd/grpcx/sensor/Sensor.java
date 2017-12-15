package cn.ladd.grpcx.sensor;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class Sensor {
	public static void main(String[] args) {
		File file=new File("MyPrinter.jar");
		try {
			for(int i=0;i!=1000;++i)
			{
				System.out.println("Loop begin");
				URL url=file.toURI().toURL();
				URL[] urls=new URL[]{url};
				URLClassLoader classLoader=new URLClassLoader(urls);
				Class printerThreadClass=classLoader.loadClass("cn.ladd.printer.PrinterThread");
				BaseThread printerThread=(BaseThread) printerThreadClass.newInstance();
				printerThread.start();
				classLoader.close();
				Thread.sleep(20*1000);
				printerThread.stopCurrentThread();
				Thread.sleep(4*1000);
				System.out.println("Loop end");
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
