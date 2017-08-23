package pdf.kit;

import lombok.Data;

import java.util.Map;

/**
 * 授权文件模板
 * Created by huang on 17-8-23.
 */
@Data
public class AuthorizationTemplate {

    /**
     * 标题
     */
    private String title;

    /**
     * 所选服务
     */
    private Map<String, String> service;

    /**
     * 授权内容标题
     */
    private String authorizationContentTile;

    /**
     * 授权内容
     */
    private String authorizationContent;

    /**
     * 授权确认时间
     */
    private String authorizationDate;

}
