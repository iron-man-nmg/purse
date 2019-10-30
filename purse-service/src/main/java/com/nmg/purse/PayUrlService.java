package com.nmg.purse;

import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by xiadingli on 2019/10/30.
 */
public class PayUrlService {
    /** payUrl */
    private static final String PAY_URL = "https://mobile.yangkeduo.com/order_checkout.html?sku_id=91182140531&group_id=13245051&goods_id=6620183&goods_number=1&page_from=24&refer_page_element=open_btn&source_channel=0&refer_page_name=login&refer_page_id=10169_1571299499304_4DicPU3Ofd&refer_page_sn=10169&_x_share_id=7615d123c4414d258be55183e13e8d74";

    public void login(){
        try {
        String  url=PAY_URL;//想采集的网址
        String refer=PAY_URL;
        URL link=new URL(url);
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getCookieManager().setCookiesEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false); //此行必须要加
        webClient.getOptions().setTimeout(300000);

        String cs[] ="api_uid=rBUBXl2y0tR8qjgrT5i1Ag==; _nano_fp=Xpd8X59oX0djlpXxn9_PVY554vw_k_p0jDDE4GZS; ua=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_14_5)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F78.0.3904.70%20Safari%2F537.36; webp=1; chat_list_rec_list=chat_list_rec_list_Gijqlj; msec=1800000; JSESSIONID=53A587283BFE5D2C37FBC7DC7FF23F4D; pdd_user_id=5602058817679; pdd_user_uin=KMEKN7IEJQB2AN25R5OGJID5BI_GEXDA; PDDAccessToken=YR7C64DHSN7ED6IBQXV4KU3QRVVKSVVK4QYMJKOP6L7OWQ2BDSWQ1108f0e; rec_list_personal=rec_list_personal_lkbldm; rec_list_index=rec_list_index_rBeFcH".split(";");
            CookieManager cookieManager = webClient.getCookieManager();

            for (String c : cs) {
                Cookie cookie = null;
                String css[] = c.split("=");
                if(css.length == 1) {
                    cookie = new Cookie("mobile.yangkeduo.com",css[0], "");
                }else{
                    cookie = new Cookie("mobile.yangkeduo.com",css[0], css[1]);
                }
                cookieManager.addCookie(cookie);
            }
            webClient.setCookieManager(cookieManager);

        WebRequest request=new WebRequest(link);
        request.setCharset(StandardCharsets.UTF_8);
        request.setAdditionalHeader(":authority","mobile.yangkeduo.com");
            request.setAdditionalHeader(":method","GET");
            request.setAdditionalHeader(":path","/order_checkout.html?sku_id=91182140531&group_id=13245051&goods_id=6620183&goods_number=1&page_from=24&refer_page_element=open_btn&source_channel=0&refer_page_name=login&refer_page_id=10169_1571299499304_4DicPU3Ofd&refer_page_sn=10169&_x_share_id=7615d123c4414d258be55183e13e8d74");
            request.setAdditionalHeader(":scheme","https");



        request.setAdditionalHeader("Referer", refer);//设置请求报文头里的refer字段
        ////设置请求报文头里的User-Agent字段
        request.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        //wc.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        //wc.addRequestHeader和request.setAdditionalHeader功能应该是一样的。选择一个即可。
        //其他报文头字段可以根据需要添加

            HtmlPage page =  webClient.getPage(request);


            System.out.println(page.asXml());

            //获取支付宝按钮位置，
            //选中
            //获取立即支付按钮位置
            //点击
            //获取页面url

            System.out.println(page.asText());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        PayUrlService payUrlService=new PayUrlService();
        payUrlService.login();
    }
}
