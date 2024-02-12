package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FilePermission;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: sky-take-out
 * @description:
 * @author: Liming Huang
 * @create-time: 2023-10-21 22:19
 **/

@RestController
@RequestMapping("/admin/common")
@Api(tags="通用接口")
@Slf4j
public class CommonController {
    @Resource
    private AliOssUtil aliOssUtil;
    /**
     * file uploading
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("file uploading")
    public Result<String> upload(MultipartFile file) {  //这里的file作为参数名，必须与提供的参数名保持一致，可见api开发文档
        log.info("文件上传:{}",file);
        //

        try {
            //获取原始文件名
            String originalFileName = file.getOriginalFilename();
            //获取文件扩展名，另：String.substring()方法可以只接受一个参数
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            //生成一个新文件名称
            String objectName = UUID.randomUUID().toString()+extension;

            //使用新文件名称ojectName 上传文件，防止文件重名被覆盖
            String filepath = aliOssUtil.upload(file.getBytes(),objectName);
            return Result.success(filepath);
        } catch (IOException e) {
            log.error("文件上传失败: {}",e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }

}
