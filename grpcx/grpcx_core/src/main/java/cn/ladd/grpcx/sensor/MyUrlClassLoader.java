package cn.ladd.grpcx.sensor;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.jar.JarFile;

/**
 * Fix a jvm bug: URLClassLoader will lock resource jar files in Windows before JDK 1.7
 * @author ladd
 * @date 20171203
 *
 */
public class MyUrlClassLoader extends URLClassLoader{
	
	public MyUrlClassLoader(URL[] urls, ClassLoader parent) {
	    super(urls, parent);
	}
	
	/**
     * Closes all open jar files
     */
    public void close() {
        try {
            Class clazz = java.net.URLClassLoader.class;
            Field ucp = clazz.getDeclaredField("ucp");
            ucp.setAccessible(true);
            Object sunMiscURLClassPath = ucp.get(this);
            Field loaders = sunMiscURLClassPath.getClass().getDeclaredField("loaders");
            loaders.setAccessible(true);
            Object collection = loaders.get(sunMiscURLClassPath);
            for (Object sunMiscURLClassPathJarLoader : ((Collection) collection).toArray()) {
                try {
                    Field loader = sunMiscURLClassPathJarLoader.getClass().getDeclaredField("jar");
                    loader.setAccessible(true);
                    Object jarFile = loader.get(sunMiscURLClassPathJarLoader);
                    ((JarFile) jarFile).close();
                } catch (Throwable t) {
                    
                }
            }
        } catch (Throwable t) {
 
        }
        return;
    }

}
