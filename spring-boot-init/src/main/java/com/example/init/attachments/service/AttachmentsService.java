package com.example.init.attachments.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.init.attachments.entity.Attachments;
import com.example.init.attachments.vo.AttachmentsInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 全局附件表 服务类
 * </p>
 *
 * @author StevenGuo
 * @since 2020-04-14
 */
public interface AttachmentsService extends IService<Attachments> {

    Map handle(Boolean flag,MultipartFile file,String type) throws IOException;

    AttachmentsInfo fileUpload(MultipartFile file, String type) throws IOException;

    int insert(String fileType,String originalFilename,String fileExtension,String path);

    String delete(String path) throws IOException;

    Attachments selectByUrl(String url);
}
