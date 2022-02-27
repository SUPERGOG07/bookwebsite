package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.FileUtil;
import util.Result;
import util.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FileController {
    //upload
    @RequestMapping(value = "/upload",method = {RequestMethod.POST})
    public Result upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("1");
        String result= FileUtil.upload(file,request);
        if(result.equals("upload-success")){
            return ResultUtil.data(null,result);
        }
        else {
            return ResultUtil.error(result);
        }
    }

    //download
    @RequestMapping(value = "/download",method = {RequestMethod.POST})
    public Result download(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam("fileName") String fileName) throws IOException{

        String result=FileUtil.download(response, request, fileName);
        if(result.equals("download-success")){
            return ResultUtil.data(null,result);
        }
        else {
            return ResultUtil.error(result);
        }
    }

}
