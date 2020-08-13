package com.example.init.attachments.controller;

import com.example.init.attachments.service.AttachmentsService;
import com.example.init.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;


/**
 * <p>
 * 全局附件表 前端控制器
 * </p>
 *
 * @author StevenGuo
 * @since 2020-04-14
 */
@RestController("attachments")
@RequestMapping("/attachments")
@Api(tags = "附件管理")
public class AttachmentsController {
    static final Logger logger = LoggerFactory.getLogger(AttachmentsController.class);


    @Resource
    AttachmentsService attachmentsService;

    /**
     * 平台文件存储的一级目录
     */
    @Value("${file.address.prefix}")
    private String fileAddressPrefix;
    @Value("${file.address.fileUploadRootDir}")
    private String fileUploadRootDir;

    @GetMapping("/download")
    @ApiOperation("文件下载")
    public String downloadFile(HttpServletResponse response, String path, String fileName) {
        try {

            File file = new File(fileAddressPrefix + path);
            if (file.exists()) {
                response.setContentType("application/octet-stream");
                response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
                byte[] buffer = new byte[1024];
                try (
                        FileInputStream fis = new FileInputStream(file);
                        BufferedInputStream bis = new BufferedInputStream(fis)
                ) {
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    @ApiOperation("文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "附件类型（图片IMAGE,文档DOC，音频AUDIO，视频VIDEO，其他OTHER））", required = true)
    })
    public Map fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) throws IOException {
        return attachmentsService.handle(false, file, type);
    }

    @PostMapping(value = "/uploadForRichText", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    @ApiOperation("富文本文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "附件类型（图片IMAGE,文档DOC，音频AUDIO，视频VIDEO，其他OTHER））", required = true)
    })
    public Map uploadForRichText(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) throws IOException {
        return attachmentsService.handle(true, file, type);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    @ApiOperation("文件删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path", value = "附件url", required = true)
    })
    public Result delete(@RequestParam("path")  String path) throws IOException {
        String result = attachmentsService.delete(path);
        return Result.success(result);
    }

}

