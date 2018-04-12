import cn.pingweb.career.CompanyApplication;
import cn.pingweb.career.email.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CompanyApplication.class})
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMail() throws Exception {
        mailService.sendSimpleMail("1589510939@qq.com", "test", "test");
    }


}