package util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


public class FileUtil {

    public static String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        if("".equals(fileName)){
            return "空文件异常";
        }
        System.out.println("上传文件:"+fileName);
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址："+realPath);

        InputStream is = file.getInputStream(); //文件输入流
        OutputStream os = new FileOutputStream(new File(realPath,fileName));
        try{
            int len=0;
            byte[] buffer = new byte[1024];
            while((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
                os.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
            return "上传失败";
        }
        finally {
            is.close();
            os.close();
        }
        return "upload-success";
    }

    public static String download(HttpServletResponse response,HttpServletRequest request,String fileName) throws IOException{
        String path = request.getSession().getServletContext().getRealPath("/download");

        //1、设置response 响应头
        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path,fileName);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        try{
            byte[] buff =new byte[1024];
            int index=0;
            //4、执行 写出操作
            while((index= input.read(buff))!= -1){
                out.write(buff, 0, index);
                out.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
            return "下载失败";
        }finally {
            out.close();
            input.close();
        }
        return "download-success";

    }


}
