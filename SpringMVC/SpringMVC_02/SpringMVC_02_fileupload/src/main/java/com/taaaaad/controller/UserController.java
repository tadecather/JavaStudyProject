package com.taaaaad.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 文件上传
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传....");

        // 使用 Fileupload 组件完成文件上传
        // 文件上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            // 创建文件夹
            file.mkdirs();
        }

        // 解析 Request 对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);
        // 遍历
        for (FileItem item : items){
            // 判断 item 是否是一个上传文件项
            if (item.isFormField()){
                // 普通文件项
            }else {
                // 上传文件项
                // 获取到文件上传名称
                String fileName = item.getName();
                // 把文件名设置为唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                // 完成文件上传
                System.out.println(path);
                item.write(new File(path, fileName));
                // 删除临时文件
                item.delete();
            }
        }

        return "success";
    }


    /**
     * SpringMVC 上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传2....");

        // 使用 Fileupload 组件完成文件上传
        // 文件上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            // 创建文件夹
            file.mkdirs();
        }


        // 上传文件项
        // 获取到文件上传名称
        String fileName = upload.getOriginalFilename();
        // 把文件名设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        // 完成文件上传
        System.out.println(path);
        upload.transferTo(new File(path, fileName));
        
        return "success";
    }

    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器上传....");

        // 定义上传文件服务器路径
        String path = "http://localhost:9090/fileuploadserver_war/uploads/";

        // 上传文件项
        // 获取到文件上传名称
        String fileName = upload.getOriginalFilename();
        // 把文件名设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        // 完成文件上传
//        System.out.println(path);

        // 创建客户端对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource resource = client.resource(path + fileName);
        // 上传文件
        resource.put(upload.getBytes());

        return "success";
    }


}
