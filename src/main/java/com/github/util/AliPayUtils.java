package com.github.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class AliPayUtils {

    private static final String SERVER_URL = "https://openapi.alipaydev.com/gateway.do";

    private static final String APP_ID = "2016100100636201";

    private static final String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDPl/wIc8fuu3ci4P/Ecjv4QsIf8104I6qCwhPSf5BxQDXj2pbffRncaLAWk4EhFRhxEtexkxdAjkDJWEnUA7YqVm9FheVUOf/1S9BO0x5guBhK9M+Pf4ETfOPjS3tfC+NcYIFyewysJTrgh7doUYPRbMgkY98CAZim/7QeDmZQrLYHYmZuUhcoz8psEtC/FDTVXc+frkg7qSYK3lEpD9KM3AAs60bvMQAFnTl2U70ejlVHvZE5ilxVLhZsa80v1Yqk3ly5sAqwCunLIzOZGUGstFJgCPxT8bRmwSRQI9Lsp7t97xyerCRid02eQJk4n7sfRSZdo3BjM7A0lzKu8yZbAgMBAAECggEAYaDDeaIhw6dMJw4TmupyQ5X5v5bvHyi+1tG5CsTNREWDUo4JaD9oOxzMu0FReCJ4pSzMXYmkZMrBsy8fQWMhd5XArLyElnDUbCLkaz2kSq4pVo79UioPpP+WGN31vkRT/6yvFAzEb+zuXIvW+Gtlh8cV9O83ALWJefhFV+FDwuotQ2r84ujwKV21JbFRak1tJLoP58PgKlQTgbJ5rfTdVWB8tC/oi6lkZcGabOoUokYT5G/aC1j1Hrfy7CVnqMKlm+0qCnBm2eDglPFq+oCyprynRI6mof8+LTNRtGqUBRsrvceCS558YGPwG81Keb8CYBXlAHCk878/VmDrdnZyiQKBgQD190rg6ejQykXnc8EDI1A8R+zDdue4edJSklEs0xQ5gtumkQBexl4sVAF3NZJ5xtmHgzQZ3bs6EJpi5xBAlAhFqzoKFEGptca5i2p3zfXUO1MEJqg3qpPb/JHbKqFDOWtF9ocFEC9DLSH3NQeR9xOvhdrL4BWzWmhoblp1q+XMFwKBgQDYD/T3SSQRiDpHA0NVSmBHPhWI5o2y9viGZJNTqPa6YsCzRnoL/KcR/vzDa3f3VMsSI35bal6btoS4XNAs/x9r17SR13znVWK+FYbqKIz2bBhNylw/hvjs/DE0iH2VF+dS1+gSFPSz1WNJmvS3oDkxE0VZcwyq9yrB5qUt+p9OXQKBgFAAMvacngDrCXmSiMDAh6RTsIqS7iNuXB5HQOfXb8iU62Rt3TT2SEMav69KWW4KY05UOmn/WJo2NEDe7sZSX65pVuNYW1MbsJtA4Uw+TSrOcN30xNn2PUlcCQTEBNecoWuMF7Zp4TV0RIvnT6MGPfzlCJkvNV+0lCkDW6DSXFfZAoGAPwMAVTIOg9Jv9I/eDjy/sWdIzoE2qA/g0Qj58ncfZaIxQtd19pL7goMT4kYwWYBwLN0PF8gAyXbEZCQlTkolNsVU0we+VJURVBBhJV8oJSHHQMCYgKpzZGH0U7bOsTGkdAOlmchkySGdcDTx06+1njtZiUnFUwL8hEoouC0UUr0CgYBphi3mQqxtNaj3+Wobc+g61nqK4LSyxAfEgnWFJel9pxDZTdatkKEhN7X199QCYN4+dZbb9s9z3JplW2vnDgbY0QqQAYmIbt4q8jN1DjH0Tez22sOWXSgosznv9JArRdq/9ADw3NMG4l9QB4059Uf+PqGjWDDBLW93Lf/JJqRWuQ==";

    private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkPWIlJo8A4GsyqBfD2p2tM8iz6E1a1gc6E4a57RU43eFc8MQU30N+DutegJeCB1J78NoR8a3euGXuO1a4Zul/Wh7G7nL4ei5PwGuYn1cYvI1Ipc8pTSAowockejo93lFMc7XWYL3dl+exsI+3HOnYHFgboWgQqe5YZz76GgkSvhqxy6XwsGyAUVD0LhWgIVT6BjGGwu7DQ1R/Bb90vpC9YbhS34P3WjabCIkmWNwxmyn/oNRuo8i74O//+cm49ozDEkMhDdR2jMjBxywA0U/WTNinOGvY0QC/rHuucTbwhhqQHBpp16FU6S+8OnWABCsQqK9UY4W/VweWYit4D+oTwIDAQAB";

    static void init() throws AlipayApiException {
        // 初始化请求客户端，其中封装了签名、请求、验签的功能
        AlipayClient alipayClient = new DefaultAlipayClient(SERVER_URL, APP_ID, APP_PRIVATE_KEY, "json", "UTF-8", PUBLIC_KEY, "RSA2");
        // 根据接口名初始化对应的请求类，其中封装了具体的接口名
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        // 通过创建接口模型，可快速传入所需请求参数
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        request.setBizModel(model);
        model.setOutTradeNo(Long.toString(System.currentTimeMillis()));
        model.setTotalAmount("88.88");
        model.setSubject("Iphone6 16G");
        // 通过执行请求，可获取所有返回报文（getBody()），也可通过具体某个出参获取具体返回参数（例如：getQrCode()）
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        System.out.println(response.getBody());
        System.out.println(response.getQrCode());
    }

    public static void main(String[] args) throws AlipayApiException {
        AliPayUtils.init();
    }
}
