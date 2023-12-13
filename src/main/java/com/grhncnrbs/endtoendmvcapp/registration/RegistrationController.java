package com.grhncnrbs.endtoendmvcapp.registration;

import com.grhncnrbs.endtoendmvcapp.event.RegistrationCompleteEvent;
import com.grhncnrbs.endtoendmvcapp.user.User;
import com.grhncnrbs.endtoendmvcapp.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/registration-form")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new RegistrationRequest());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") RegistrationRequest registrationRequest) {
        User user = userService.registerUser(registrationRequest);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user, ""));
        return "redirect:/registration/registration-form?success";
    }
}
