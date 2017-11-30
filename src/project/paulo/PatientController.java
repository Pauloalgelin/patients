package project.paulo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {
  @RequestMapping("/welcome")
  public String welcome() {
    return "patient/welcome";
  }
}
