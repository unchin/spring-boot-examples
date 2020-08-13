package com.example.init.attachments.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.init.attachments.entity.Attachments;
import com.example.init.attachments.mapper.AttachmentsMapper;
import com.example.init.attachments.service.AttachmentsService;
import com.example.init.attachments.vo.AttachmentsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 全局附件表 服务实现类
 * </p>
 *
 * @author StevenGuo
 * @since 2020-04-14
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class AttachmentsServiceImpl extends ServiceImpl<AttachmentsMapper, Attachments> implements AttachmentsService {

    static final Logger logger = LoggerFactory.getLogger(AttachmentsServiceImpl.class);

    /**
     * 平台文件存储的一级目录
     */
    @Value("${file.address.prefix}")
    private String fileAddressPrefix;
    @Value("${file.address.fileUploadRootDir}")
    private String fileUploadRootDir;
    @Value("${file.address.host}")
    private String host;

    @Autowired
    AttachmentsMapper attachmentsMapper;

    @Override
    public Map handle(Boolean flag, MultipartFile file, String type) throws IOException {
        AttachmentsInfo attachments = fileUpload(file, type);
        String relativePath = attachments.getUrl();
        String absolutePath = host + relativePath;
        Map<String, Object> result = new HashMap<>();
        if (flag) {
            result.put("link", absolutePath);
        } else {
            result.put("id", attachments.getId());
            result.put("link", relativePath);
            result.put("fileName", attachments.getFileName());
        }
        return result;
    }

    @Override
    public AttachmentsInfo fileUpload(MultipartFile file, String type) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        String saveName = DigestUtils.md5DigestAsHex((fileName + RandomUtil.randomNumber()).getBytes()) + "." + fileExtension;
        String relativePath = fileUploadRootDir + type + "/" + saveName;
        String savePath = fileAddressPrefix + relativePath;

        File dir = new File(fileAddressPrefix + fileUploadRootDir + type);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File convertFile = new File(savePath);
        FileOutputStream fileOutputStream = new FileOutputStream(convertFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();

        int id = insert(type, fileName, fileExtension, relativePath);


        AttachmentsInfo attachments = new AttachmentsInfo();
        attachments.setId(id);
        attachments.setFileName(fileName);
        attachments.setUrl(relativePath);
        return attachments;
    }

    @Override
    public int insert(String fileType, String fileName, String fileExtension, String path) {

        Attachments attachments = new Attachments();
        attachments.setFileType(fileType);
        attachments.setUrl(path);
        attachments.setFileName(fileName);
        attachments.setCreateDate(new Date());
        attachments.setFileExtension(fileExtension);
        //todo
        //attachments.setCreator(userId);

        attachmentsMapper.insert(attachments);

        return attachments.getId();
    }

    @Override
    public String delete(String path) throws IOException{
        Files.delete(Paths.get(fileAddressPrefix + path));
        UpdateWrapper<Attachments> wrapper = new UpdateWrapper<>();
        wrapper.eq("url", path);
        attachmentsMapper.delete(wrapper);
        return " 文件已被删除";
    }

    @Override
    public Attachments selectByUrl(String url) {
        Attachments attachments = new Attachments();
        attachments.setUrl(url);
        return attachmentsMapper.selectOne(new QueryWrapper<>(attachments));
    }
}
