package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FreePatchUtil {
    private static String patchFile="D:/patchppm.txt";//补丁文件,由eclipse svn plugin生成
    private static String projectPath= "";
    //"D:/SVN/development/ppm-service-parent/ppm-open-api-server";//项目文件夹路径
    private static String webContent= "";//"WebContent";//web应用文件夹名
    //class存放路径//"D:/document/develop2/tomcat8.5-192/tomcat-8.5-ppm-open-api-192/webapps/ppm-open-api-server/WEB-INF/classes";
    private static String classPath= "";
    private static String desPath= "D:/SVN/SZRDC-HF2/SourceCode/3_Testing/8_辽宁BSS3.0/1_CPCP配置中心/1_CPCP服务/V3.1.2/V3.1.2.137/1、补丁包";
    //"D:/tmp/update_pkg";//补丁文件包存放路径
    private static String version="ppm";//补丁版本

    /**
    在svn生成补丁文件patch.txt的基础上（新增修改的文件），通过读取其中改动文件fileList，在指定代码路径情况下生成
     增量.class文件的补丁包上面的路径根据实际情况配置。在jdk1.8 或以上运行环境下的ide上run class.main即可生成
     TODO 目前只考虑到单个文件包情况，工程下jar修改、匿名内部类的多个class有待支持
     ps 如果修改一个方法的param，这种情况涉及到编译器方法重载的问题，必须提供所有调用此方法的 .class文件否则程序会报错
     */
    public static void main(String[] args) throws Exception {
        Long currTime1 = System.currentTimeMillis();
        List<String> fileList = getPatchFileList();
        copyFiles(fileList);
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒.");
        //在待复制文件在40-50个间 测试单线程56-65ms，多线程72-76ms
    }

    private static List<String> getPatchFileList() throws Exception{
        List<String> fileList= new ArrayList<>();
        BufferedReader dr=new BufferedReader(new InputStreamReader(new FileInputStream(patchFile),StandardCharsets.UTF_8));
        String line;
        while((line=dr.readLine())!=null){
            if(line.contains("Index:")){
                line=line.replaceAll(" ","");
                line=line.substring(line.indexOf(":")+1);
                fileList.add(line);
            }
        }
        return fileList;
    }
    private static void copyFiles(List<String> list){
        for(String fullFileName:list){
            if(fullFileName.contains("src/main/")){//对源文件目录下的文件处理
                String fileName=fullFileName.replace("src/main/java","");
                fileName=fileName.replace("src/main/resources","");
                fullFileName=classPath+fileName;
                if(fileName.endsWith(".java")){
                    fileName=fileName.replace(".java",".class");
                    fullFileName=fullFileName.replace(".java",".class");
                }
                String tempDesPath=fileName.substring(0,fileName.lastIndexOf("/"));
                String desFilePathStr=desPath+"/"+version+"/WEB-INF/classes"+tempDesPath;
                String desFileNameStr=desPath+"/"+version+"/WEB-INF/classes"+fileName;
                File desFilePath=new File(desFilePathStr);
                if(!desFilePath.exists()){
                    boolean mkdirFlag = desFilePath.mkdirs();
                    if(!mkdirFlag){
                        System.out.println("创建目录失败，请查询原因");
                    }
                }
                copyFile(fullFileName, desFileNameStr);
                System.out.println(fullFileName+"复制完成");
            }else{//对普通目录的处理
                String desFileName=fullFileName.replaceAll(webContent,"");
                fullFileName=projectPath+"/"+fullFileName;//将要复制的文件全路径
                String fullDesFileNameStr=desPath+"/"+version+desFileName;
                String desFilePathStr=fullDesFileNameStr.substring(0,fullDesFileNameStr.lastIndexOf("/"));
                File desFilePath=new File(desFilePathStr);
                if(!desFilePath.exists()){
                    boolean mkdirFlag = desFilePath.mkdirs();
                    if(!mkdirFlag){
                        System.out.println("创建目录失败，请查询原因");
                    }
                }
                copyFile(fullFileName, fullDesFileNameStr);
                System.out.println(fullDesFileNameStr+"复制完成");
            }
        }
    }
    private static void copyFile(String sourceFileNameStr, String desFileNameStr) {
        File sourceFile=new File(sourceFileNameStr);
        File targetFile=new File(desFileNameStr);
//        try {
//            copyFile(sourceFile, targetFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(() -> {
                try (BufferedInputStream inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
                     BufferedOutputStream outBuff = new BufferedOutputStream(new FileOutputStream(targetFile))) {
                    // 新建 自动资源管理文件输入流输出流并对它进行缓冲
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = inBuff.read(b)) != -1) {
                        outBuff.write(b, 0, len);
                    }
                    // 刷新此缓冲的输出流
                    outBuff.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        );
    }
//    private static void copyFile(File sourceFile, File targetFile) throws IOException {
//        try (BufferedInputStream inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
//             BufferedOutputStream outBuff = new BufferedOutputStream(new FileOutputStream(targetFile))) {
//            // 新建 自动资源管理文件输入流输出流并对它进行缓冲
//            // 缓冲数组
//            byte[] b = new byte[1024 * 5];
//            int len;
//            while ((len = inBuff.read(b)) != -1) {
//                outBuff.write(b, 0, len);
//            }
//            // 刷新此缓冲的输出流
//            outBuff.flush();
//        }
//    }
}
