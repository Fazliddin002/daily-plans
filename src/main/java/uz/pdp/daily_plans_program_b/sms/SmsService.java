package uz.pdp.daily_plans_program_b.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.daily_plans_program_b.security.entity.User;

import java.time.LocalDateTime;

@Service
public class SmsService {
    public void sendSMS(User user, String reminderText) {

        Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));

        Message.creator(new PhoneNumber(user.getPhone()),
                new PhoneNumber("<FROM number - ie your Twilio number"), "Assalomu alaykum "+user.getFirstName()+" "+reminderText+" name note time\n").create();

        new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }
}
